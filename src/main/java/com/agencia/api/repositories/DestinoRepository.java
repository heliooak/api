package com.agencia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.api.entities.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

}
