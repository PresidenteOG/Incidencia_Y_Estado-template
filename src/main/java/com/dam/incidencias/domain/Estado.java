package com.dam.incidencias.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estado")
@Data
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del estado (ejemplo: ABIERTO, CERRADO, ON_GOING)
    private String nombre;
}
