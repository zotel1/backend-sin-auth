package com.no_country.salud_vital.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import com.no_country.salud_vital.domain.consulta.DatosAgendarConsulta;
import com.no_country.salud_vital.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteActivo implements ValidadorDeConsultas{
    @Autowired
    private PacienteRepository repository;

    public void validar(DatosAgendarConsulta datos){
        if(datos.idPaciente()==null){
            return;
        }
        var pacienteActivo=repository.findActivoById(datos.idPaciente());

        if(!pacienteActivo){
            throw new ValidationException("No se puede permitir agendar citas con pacientes inactivos en el sistema");
        }
    }
}
