package com.example.demo.SpringBootIncidencia.service;

import java.util.List;

import com.example.demo.SpringBootIncidencia.domain.Estado;

public interface EstadoService {

    List<Estado> getAllEstados();

    Estado getEstadoById(Long id);

    Estado saveEstado(Estado estado);

    void deleteEstado(Long id);
}
