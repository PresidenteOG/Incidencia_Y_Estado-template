package com.example.demo.SpringBootIncidencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.SpringBootIncidencia.dao.EstadoDAO;
import com.example.demo.SpringBootIncidencia.domain.Estado;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoDAO estadoDAO;

    @Override
    public List<Estado> getAllEstados() {
        return estadoDAO.findAll();
    }

    @Override
    public Estado getEstadoById(Long id) {
        return estadoDAO.findById(id).orElse(null);
    }

    @Override
    public Estado saveEstado(Estado estado) {
        return estadoDAO.save(estado);
    }

    @Override
    public void deleteEstado(Long id) {
        estadoDAO.deleteById(id);
    }
}
