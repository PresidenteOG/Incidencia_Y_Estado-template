package com.dam.incidencias;

import com.dam.incidencias.service.EstadoService;
import com.dam.incidencias.service.IncidenciaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IncidenciasApplicationTests {

    @Autowired
    private IncidenciaService incidenciaService;

    @Autowired
    private EstadoService estadoService;

    @Test
    void contextLoads() {
    }

    @Test
    void seedDataIsLoaded() {
        assertThat(estadoService.getAllEstados()).hasSize(3);
        assertThat(incidenciaService.getAllIssues()).hasSizeGreaterThanOrEqualTo(10);
    }

    @Test
    void loginCheckAcceptsOnlyTheDemoAccount() {
        assertThat(incidenciaService.checkLogin("admin", "admin")).isTrue();
        assertThat(incidenciaService.checkLogin("admin", "wrong")).isFalse();
    }
}
