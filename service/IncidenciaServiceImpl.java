package com.example.demo.SpringBootIncidencia.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.SpringBootIncidencia.dao.EstadoDAO;
import com.example.demo.SpringBootIncidencia.dao.IncidenciaDAO;
import com.example.demo.SpringBootIncidencia.domain.Estado;
import com.example.demo.SpringBootIncidencia.domain.Incidencia;

@Service
public class IncidenciaServiceImpl implements IncidenciaService {

    @Autowired
    private IncidenciaDAO IncidenciaDAO;

    @Autowired
    private EstadoDAO EstadoDAO;

    @Override
    public List<Incidencia> getAllIssues() {
        return IncidenciaDAO.findAll();
    }

    @Override
    public Incidencia saveIncidencia(Incidencia incidencia) {

        boolean esNueva = (incidencia.getId() == null);

        if (esNueva) {
            // Nueva incidencia
            incidencia.setData_obertura(LocalDateTime.now());

            // Si no viene estado del formulario, ponemos por defecto ABIERTO (id = 1)
            if (incidencia.getEstado() == null || incidencia.getEstado().getId() == null) {
                Estado estadoAbierto = EstadoDAO.findById(1L).orElse(null);
                incidencia.setEstado(estadoAbierto);
            }

        } else {
            // UPDATE → recuperamos la original para no perder la fecha de apertura
            Incidencia original = IncidenciaDAO.findById(incidencia.getId()).orElse(null);

            if (original != null) {
                incidencia.setData_obertura(original.getData_obertura());
            }
            // OJO: aquí NO tocamos incidencia.setEstado(...)
            // porque ya viene del formulario con el nuevo estado
        }

        // Si el estado es CERRADO, calculamos tiempos
        if (incidencia.getEstado() != null &&
                incidencia.getEstado().getId() != null &&
                incidencia.getEstado().getId().equals(3L)) {

            incidencia.setData_tancament(LocalDateTime.now());

            long minutosTotales = java.time.Duration
                    .between(incidencia.getData_obertura(), incidencia.getData_tancament())
                    .toMinutes();

            long horas = minutosTotales / 60;
            long minutos = minutosTotales % 60;

            incidencia.setTemps_resolucio(horas + "h " + minutos + "m");
        } else {
            // Si NO está cerrada, por si acaso dejamos estos a null
            incidencia.setData_tancament(null);
            incidencia.setTemps_resolucio(null);
        }

        return IncidenciaDAO.save(incidencia);
    }

    @Override
    public Incidencia findID(Long id) {
        return IncidenciaDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteIncidencia(Long id) {
        IncidenciaDAO.deleteById(id);
    }

    String nameR = "admin";
    String paswordR = "admin";

    @Override
    public String Check(String name, String password) {
        if (name.equals(nameR) && password.equals(paswordR)) {
            return "redirect:/Incidencia";
        } else {
            return "/Incidencia-login";
        }
    }
}
