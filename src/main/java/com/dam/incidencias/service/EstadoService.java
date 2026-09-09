package com.dam.incidencias.service;

import java.util.List;

import com.dam.incidencias.domain.Estado;

public interface EstadoService {

    List<Estado> getAllEstados();

    Estado getEstadoById(Long id);

    Estado saveEstado(Estado estado);

    void deleteEstado(Long id);
}
