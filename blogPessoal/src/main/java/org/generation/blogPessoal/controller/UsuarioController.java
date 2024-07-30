package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.dto.UsuarioDTO;
import org.generation.blogPessoal.model.UsuarioLogin;
import org.generation.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getAll() {
		Optional<List<UsuarioDTO>> usuarios = service.buscarTodosOsUsuarios();
		return ResponseEntity.ok(usuarios.get());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> getById(@PathVariable long id) {
		return service.buscarUsuarioPorId(id)
			.map(response -> ResponseEntity.ok(response))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<UsuarioDTO> post(@RequestBody UsuarioDTO dto) {
		Optional<UsuarioDTO> user = service.cadastrarUsuario(dto);
		try {
			return ResponseEntity.ok(user.get());
		} 
		catch (Exception err) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Optional<UsuarioDTO>> put(@RequestBody UsuarioDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualizarUsuario(dto));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		service.excluirUsuario(id);
	}

	@PostMapping("/login")
	public ResponseEntity<UsuarioLogin> authentication(@RequestBody Optional<UsuarioLogin> usuarioLogin) {
		return service.autenticarUsuario(usuarioLogin).map(response -> ResponseEntity.ok(response))
			.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

}
