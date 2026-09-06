package com.example.demo.SpringBootIncidencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.SpringBootIncidencia.domain.Incidencia;

@Repository
public interface IncidenciaDAO extends JpaRepository<Incidencia, Long> {
}
