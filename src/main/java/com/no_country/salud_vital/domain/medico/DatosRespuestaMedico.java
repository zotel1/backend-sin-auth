package com.no_country.salud_vital.domain.medico;

import com.no_country.salud_vital.domain.direccion.DatosDireccion;

public record DatosRespuestaMedico(Long id, String nombre, String email, String telefono, String documento,
                                   DatosDireccion direccion) {
}
