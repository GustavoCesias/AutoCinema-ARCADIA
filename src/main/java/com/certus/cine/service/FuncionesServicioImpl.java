package com.certus.cine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certus.cine.dto.FuncionesDTO;
import com.certus.cine.entity.Funciones;
import com.certus.cine.entity.Pelicula;
import com.certus.cine.entity.ProjectionZone;
import com.certus.cine.exceptions.ResourceNotFoundExceptions;
import com.certus.cine.repository.FuncionesRepository;
import com.certus.cine.repository.PeliculaRepository;
import com.certus.cine.repository.ProjectionZoneRepository;

@Service
public class FuncionesServicioImpl implements FuncionesServicio {

    @Autowired
    private FuncionesRepository funcionesRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private ProjectionZoneRepository projectionZoneRepository;

    @Override
    public FuncionesDTO crearFuncion(long peliculaId, long projectionZoneId, FuncionesDTO funcionesDTO) {
        Funciones funciones = mapearEntidad(funcionesDTO);
        Pelicula pelicula = peliculaRepository.findById(peliculaId)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Pelicula", "id", peliculaId));

        ProjectionZone projectionZone = projectionZoneRepository.findById(projectionZoneId)
                .orElseThrow(() -> new ResourceNotFoundExceptions("ProjectionZone", "id", projectionZoneId));
        
        funciones.setPelicula(pelicula);
        funciones.setProjectionZone(projectionZone);

        Funciones nuevaFuncion = funcionesRepository.save(funciones);

        return mapearDTO(nuevaFuncion);

    }

    private FuncionesDTO mapearDTO(Funciones funciones) {
        FuncionesDTO funcionesDTO = new FuncionesDTO();
        funcionesDTO.setId(funciones.getId());
        funcionesDTO.setFecha(funciones.getFecha());
        funcionesDTO.setHora(funciones.getHora());

        return funcionesDTO;

    }

    private Funciones mapearEntidad(FuncionesDTO funcionesDTO) {
        Funciones funciones = new Funciones();
        funciones.setId(funcionesDTO.getId());
        funciones.setFecha(funcionesDTO.getFecha());
        funciones.setHora(funcionesDTO.getHora());

        return funciones;
    }

}
