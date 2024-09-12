package com.no_country.salud_vital.controller;

import jakarta.validation.Valid;

import com.no_country.salud_vital.domain.consulta.AgendaDeConsultaService;
import com.no_country.salud_vital.domain.consulta.DatosAgendarConsulta;
import com.no_country.salud_vital.domain.consulta.DatosCancelamientoConsulta;
import com.no_country.salud_vital.domain.consulta.DatosDetalleConsulta;

import com.no_country.salud_vital.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService service;

    @GetMapping
    public ResponseEntity<Page<DatosDetalleConsulta>> listar(@PageableDefault(size = 10, sort = {"fecha"}) Pageable paginacion) {
        var response = service.consultar(paginacion);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleConsulta> agendar(@RequestBody @Valid DatosAgendarConsulta datos) throws ValidacionDeIntegridad {
        var response = service.agendar(datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> cancelar(@RequestBody @Valid DatosCancelamientoConsulta datos) {
        service.cancelar(datos);
        return ResponseEntity.noContent().build();
    }
}

