package com.dam.incidencias.domain;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "incidencia")
@Data
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String labor;
    private String titol;
    private String descripcion;
    private LocalDateTime data_obertura;
    private LocalDateTime data_tancament;
    private String temps_resolucio;
    private String prioritat;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
}


