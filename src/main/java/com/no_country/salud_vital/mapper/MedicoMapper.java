package com.no_country.salud_vital.mapper;

import com.no_country.salud_vital.domain.medico.DatosListadoMedico;
import com.no_country.salud_vital.domain.medico.Medico;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper implements  Mapper<Medico, DatosListadoMedico> {

    private final ModelMapper modelMapper;

    public MedicoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public DatosListadoMedico mapTo(Medico medico) {
        return modelMapper.map(medico, DatosListadoMedico.class);
    }

    @Override
    public Medico mapFrom(DatosListadoMedico datosListadoMedico) {
        return modelMapper.map(datosListadoMedico, Medico.class);
    }
}