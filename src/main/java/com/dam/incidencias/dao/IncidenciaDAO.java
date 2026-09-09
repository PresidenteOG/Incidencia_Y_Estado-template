package com.dam.incidencias.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dam.incidencias.domain.Incidencia;

@Repository
public interface IncidenciaDAO extends JpaRepository<Incidencia, Long> {
}
