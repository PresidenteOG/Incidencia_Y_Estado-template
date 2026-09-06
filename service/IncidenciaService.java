package com.example.demo.SpringBootIncidencia.service;

import java.util.List;

import com.example.demo.SpringBootIncidencia.domain.Incidencia;

public interface IncidenciaService {
    List<Incidencia> getAllIssues();

    Incidencia saveIncidencia(Incidencia incidencia);

    Incidencia findID(Long id);

    void deleteIncidencia(Long id);

    String Check(String name, String password);
}