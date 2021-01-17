package org.generation.brazil.hotel.controller;

import java.util.List;

import org.generation.brazil.hotel.model.Hospedagem;
import org.generation.brazil.hotel.repository.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospedagem")
@CrossOrigin("*")
public class HospedagemController {

	@Autowired
	private HospedagemRepository repository;

	// METODO GET
	
	// http://localhost:8080/hospedagem
	@GetMapping
	public ResponseEntity<List<Hospedagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
}
