package com.no_country.salud_vital.controller;

import com.no_country.salud_vital.service.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;
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
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/consultas")
@SuppressWarnings("all")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private AgendaDeConsultaService service;
    @GetMapping
    @Operation(summary = "Obtiene el listado de consultas")
    public ResponseEntity<Page<DatosDetalleConsulta>> listar(@PageableDefault(size = 10, sort = {"fecha"}) Pageable paginacion) {
        var response = service.consultar(paginacion);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Transactional
    @Operation(
            summary = "registra una consulta en la base de datos",
            description = "",
            tags = { "consulta", "post" })
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos) throws ValidacionDeIntegridad {
        var response = service.agendar(datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @Transactional
    @Operation(
            summary = "cancela una consulta de la agenda",
            description = "requiere motivo",
            tags = { "consulta", "delete" })
    public ResponseEntity cancelar(@RequestBody @Valid DatosCancelamientoConsulta dados) {
        service.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{idPaciente}")
    public Page<DatosDetalleConsulta> getConsultasPorId(@PathVariable Long idPaciente,
                                                        @PageableDefault(size = 10, sort = {"fecha"})Pageable paginacion){
        return consultaService.getConsultasPorPacienteId(idPaciente, paginacion);
    }
}