package com.no_country.salud_vital.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DatosCancelamientoConsulta(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamiento motivo) {
}
