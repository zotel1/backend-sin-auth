package com.no_country.salud_vital.domain.paciente;

import jakarta.validation.constraints.NotNull;
import com.no_country.salud_vital.domain.direccion.DatosDireccion;

public record DatosActualizacionPaciente(
        @NotNull
        Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion) {
}
