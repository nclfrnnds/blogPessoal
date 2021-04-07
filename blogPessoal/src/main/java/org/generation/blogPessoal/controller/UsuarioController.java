package org.generation.blogPessoal.controller;

import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.model.UsuarioLogin;
import org.generation.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> usuarioLogin) {
		
		return usuarioService.Logar(usuarioLogin).map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		
		Optional<Usuario> user = usuarioService.CadastrarUsuario(usuario);
		
		try {
			return ResponseEntity.ok(user.get());
		} 
		catch (Exception err) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	

}
