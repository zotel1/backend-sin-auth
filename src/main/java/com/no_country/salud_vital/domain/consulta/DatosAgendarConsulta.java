package com.no_country.salud_vital.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import com.no_country.salud_vital.domain.medico.Especialidad;

import java.time.LocalDateTime;

public record DatosAgendarConsulta(

        @NotNull
        Long idPaciente,
        Long idMedico,
        @NotNull
        @Future
        LocalDateTime fecha,
        Especialidad especialidad) {
}
