package org.generation.blogPessoal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.generation.blogPessoal.dto.UsuarioDTO;
import org.generation.blogPessoal.mapper.UsuarioMapper;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.model.UsuarioLogin;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.generation.blogPessoal.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	public Optional<List<UsuarioDTO>> buscarTodosOsUsuarios() {
		List<Usuario> usuarios = repository.findAll();
		return Optional.of(usuarios.stream().map(UsuarioMapper::toDTO).collect(Collectors.toList()));
	}

	public Optional<UsuarioDTO> buscarUsuarioPorId(@PathVariable long id) {
		Optional<Usuario> usuario = repository.findById(id);
		return Optional.of(UsuarioMapper.toDTO(usuario.get()));
	}
	
	public Optional<UsuarioDTO> cadastrarUsuario(UsuarioDTO dto) {

		Usuario usuario = UsuarioMapper.toModel(dto);
		
		if (repository.findByNomeDeUsuario(usuario.getNomeDeUsuario()).isPresent() && usuario.getId() == 0) {
			return Optional.empty();
		}
		
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		
		return Optional.of(UsuarioMapper.toDTO(repository.save(usuario)));
	}

	public Optional<UsuarioDTO> atualizarUsuario(UsuarioDTO dto) {

		Usuario usuario = UsuarioMapper.toModel(dto);

		if(repository.findById(usuario.getId()).isPresent()) {

			Optional<Usuario> buscaUsuario = repository.findByNomeDeUsuario(usuario.getNomeDeUsuario());

			if ((buscaUsuario.isPresent()) && ( buscaUsuario.get().getId() != usuario.getId()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

			usuario.setSenha(criptografarSenha(usuario.getSenha()));

			return Optional.ofNullable(UsuarioMapper.toDTO(repository.save(usuario)));

		}

		return Optional.empty();
	}
	
	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}

	public void excluirUsuario(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {
		var credenciais = new UsernamePasswordAuthenticationToken(usuarioLogin.get().getNomeDeUsuario(), usuarioLogin.get().getSenha());
		
		Authentication authentication = authenticationManager.authenticate(credenciais);
        
		if (authentication.isAuthenticated()) {

			Optional<Usuario> usuario = repository.findByNomeDeUsuario(usuarioLogin.get().getNomeDeUsuario());

			if (usuario.isPresent()) {

				usuarioLogin.get().setId(usuario.get().getId());
                usuarioLogin.get().setNome(usuario.get().getNome());
                usuarioLogin.get().setFoto(usuario.get().getFoto());
                usuarioLogin.get().setToken(gerarToken(usuarioLogin.get().getNomeDeUsuario()));
                usuarioLogin.get().setSenha("");
                usuarioLogin.get().setTipo(usuario.get().getTipo());
								
				return usuarioLogin;		
			}
        }      
		
		return Optional.empty();
	}
	
	private String gerarToken(String usuario) {
		return "Bearer " + jwtService.generateToken(usuario);
	}

}
