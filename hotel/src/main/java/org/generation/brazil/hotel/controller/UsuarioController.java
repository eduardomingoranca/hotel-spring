package org.generation.brazil.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.generation.brazil.hotel.exception.UsuarioException;
import org.generation.brazil.hotel.model.Usuario;
import org.generation.brazil.hotel.repository.UsuarioRepository;
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

// anotação que informa que o controller vai trabalhar com a arquitetura REST
@RestController
// anotação que informa a rota da requisição
@RequestMapping("/usuario")
// informa a origem da requisiçao
@CrossOrigin("*")
public class UsuarioController {

	// injeção de dependencia
	@Autowired
	private UsuarioRepository repository;

	// METODO GET
	
	// http://localhost:8080/usuario -- obtém todos os usuários
	@GetMapping
	// ResponseEntity --> a entidade usuario vai retornar os dados que ela tem cadastrado
	public ResponseEntity<List<Usuario>> GetAll() {		
		// retornando todos os usuários
		return ResponseEntity.ok(repository.findAll());
	}
		
	// http://localhost:8080/usuario/{codigo} -- substitua {código} pelo número	
	@GetMapping("/{codigo}")
	// PathVariable --> anotação que recebe o valor que vem na variável e coloca na rota
	public ResponseEntity<Usuario> GetById(@PathVariable long codigo) {				
		Optional<Usuario> usuario = repository.findById(codigo);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}
		throw new UsuarioException("Usuário não encontrado");
	}
	
	// http://localhost:8080/usuario/nome/{nome} -- substitua {nome} pelo nome do usuário
	@GetMapping("nome/{nome}")
	public ResponseEntity<List<Usuario>> GetByName(@PathVariable String nome) {
		// retornando o usuário pelo nome
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	// METODO POST
	
	// http://localhost:8080/usuario
	@PostMapping
	// @RequestBody --> anotação que informa que a requisição será enviada pelo body, ou seja, pelo corpo da requisição  
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		// retorna que cadastrou o usuário
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	// METODO PUT
	
	// http://localhost:8080/usuario	
	// atualizando um usuário
	@PutMapping
	public ResponseEntity<Usuario> Put(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	// METODO DELETE
	
	// http://localhost:8080/usuario/nome/{nome} -- substitua {nome} pelo nome do usuário
	@DeleteMapping("/{codigo}")
	public void Delete(@PathVariable long codigo) {
		repository.deleteById(codigo);
	}
			
}
