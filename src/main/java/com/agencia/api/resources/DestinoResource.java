package com.agencia.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.api.entities.Destino;
import com.agencia.api.services.DestinoService;

@RestController
@RequestMapping("/destinos")
@CrossOrigin(origins = "http://localhost:3000")
public class DestinoResource {
	
	@Autowired
	private DestinoService service;
	
	@GetMapping
	private List<Destino> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Destino> save(@RequestBody Destino destino) {
		service.save(destino);
		return ResponseEntity.ok().body(destino);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Destino> delete(@PathVariable Long id) {
		service.delete(id);
		Destino destino = service.getById(id);
		return ResponseEntity.ok().body(destino);
	}
}
