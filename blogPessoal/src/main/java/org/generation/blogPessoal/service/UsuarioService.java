package org.generation.blogPessoal.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.model.UsuarioLogin;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Usuario> cadastro(Usuario usuario) {
		
		if (repository.findByUsuario(usuario.getUsuario()).isPresent() && usuario.getId() == 0) {
			return null;
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		return Optional.of(repository.save(usuario));
	}
	
	public Optional<UsuarioLogin> login(Optional<UsuarioLogin> usuarioLogin) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Optional<Usuario> usuario = repository.findByUsuario(usuarioLogin.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(encoder.matches(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = usuarioLogin.get().getUsuario() + ":" + usuarioLogin.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);
				
				usuarioLogin.get().setToken(authHeader);
				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setFoto(usuario.get().getFoto());
				usuarioLogin.get().setTipo(usuario.get().getTipo());
				
				return usuarioLogin;
				
			}
		}
		
		return null;
	}

	public Optional<List<Usuario>> getAll() {
		return Optional.of(repository.findAll());
	}
	
	public Optional<Usuario> getById(@PathVariable long id) {
		return repository.findById(id);
	}
	
	public Optional<Usuario> put(@RequestBody Usuario usuario) {
		return Optional.of(repository.save(usuario));
	}

	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
