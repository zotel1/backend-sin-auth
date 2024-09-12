package com.no_country.salud_vital.domain.consulta.validaciones;

import com.no_country.salud_vital.domain.consulta.ConsultaRepository;
import jakarta.validation.ValidationException;
import com.no_country.salud_vital.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConConsulta implements  ValidadorDeConsultas{
    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosAgendarConsulta datos) {
        if(datos.idMedico()==null)
            return;

        var medicoConConsulta= repository.existsByMedicoIdAndFecha(datos.idMedico(),datos.fecha());
        if(medicoConConsulta){
            throw new ValidationException("este medico ya tiene una consulta en ese horario");
        }
    }
}
