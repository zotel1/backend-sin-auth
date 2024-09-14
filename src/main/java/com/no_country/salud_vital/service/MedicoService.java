package com.no_country.salud_vital.service;

import com.no_country.salud_vital.domain.consulta.Consulta;
import com.no_country.salud_vital.domain.consulta.ConsultaRepository;
import com.no_country.salud_vital.domain.medico.DatosListadoMedico;
import com.no_country.salud_vital.domain.medico.Especialidad;
import com.no_country.salud_vital.domain.medico.Medico;
import com.no_country.salud_vital.domain.medico.MedicoRepository;
import com.no_country.salud_vital.mapper.MedicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoMapper medicoMapper;

    public List<Medico> obtenerMedicosDisponibles(String especialidad, LocalDateTime fecha) {
        Especialidad especialidadDefinida = Especialidad.valueOf(especialidad.toUpperCase());
        List<Medico> medicos = medicoRepository.findByEspecialidad(especialidadDefinida)
                .stream()
                .filter(Medico::getActivo)
                .collect(Collectors.toList());
        List<Consulta> consultaEnFecha = consultaRepository.findByFecha(fecha);

        Set<Medico> medicosOcupados = consultaEnFecha.stream()
                .map(Consulta::getMedico)
                .collect(Collectors.toSet());

        return medicos.stream()
                .filter(medico -> !medicosOcupados.contains(medico))
                .collect(Collectors.toList());
    }

    public Page<DatosListadoMedico> getDatosMedicos(List<Medico> medicos, Pageable paginacion){

        List<DatosListadoMedico> datosMedicos = medicos.stream()
                .map(DatosListadoMedico::new)
                .collect(Collectors.toList());

        return new PageImpl<>(datosMedicos,paginacion,datosMedicos.size());

    }

    public  Page<String> getEspecialidades(Pageable paginacion) {
        List<String> especialidades = Arrays.stream(Especialidad.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        int start = (int) paginacion.getOffset();
        int end = Math.min((start + paginacion.getPageSize()), especialidades.size());
        Page<String> page = new PageImpl<>(especialidades.subList(start, end), paginacion, especialidades.size());
        return page;
    }
}