package com.dam.incidencias.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dam.incidencias.domain.Estado;

@Repository
public interface EstadoDAO extends JpaRepository<Estado, Long> {}
