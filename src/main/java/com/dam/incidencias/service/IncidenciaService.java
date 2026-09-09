package com.dam.incidencias.service;

import java.util.List;

import com.dam.incidencias.domain.Incidencia;

public interface IncidenciaService {
    List<Incidencia> getAllIssues();

    Incidencia saveIncidencia(Incidencia incidencia);

    Incidencia findID(Long id);

    void deleteIncidencia(Long id);

    boolean checkLogin(String name, String password);
}