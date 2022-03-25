package com.agencia.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agencia.api.entities.Destino;
import com.agencia.api.repositories.DestinoRepository;

@Service
public class DestinoService {

	@Autowired
	private DestinoRepository repository;
	
	// GET Method lista geral
	@Transactional(readOnly = true)
	public List<Destino> findAll() {
		List<Destino> resultado = repository.findAll();
		return resultado;
	}
	
	// GET Method por id
	public Destino getById(Long id) {
		Optional<Destino> destino = repository.findById(id);
		if(destino.isPresent()) {
			return destino.get();		
		} else {
			return null;
		}
	}
	
	// POST Method
	public void save(Destino destino) {
		repository.save(destino);
	}
	
	// DELETE Method
	public void delete(Long id) {
		repository.deleteById(id);
	}
		
}
