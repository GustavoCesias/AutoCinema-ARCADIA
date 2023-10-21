package com.certus.cine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certus.cine.dto.FuncionesDTO;
import com.certus.cine.entity.Funciones;
import com.certus.cine.repository.FuncionesRepository;

@Service
public class FuncionesServicioImpl implements FuncionesServicio {

    @Autowired
    private FuncionesRepository funcionesRepository;

    @Override
    public FuncionesDTO crearFuncion(FuncionesDTO funcionesDTO) {
        // Convertimos de DTO a entidad
        Funciones funciones = new Funciones();
        funciones.setId(funcionesDTO.getId());
        funciones.setFecha(funcionesDTO.getFecha());
        funciones.setHora(funcionesDTO.getHora());

        Funciones nuevaFunciones = funcionesRepository.save(funciones);

        // Convertimos de entidad a DTO

        FuncionesDTO funcionesRespuesta = new FuncionesDTO();
        funcionesRespuesta.setId(nuevaFunciones.getId());
        funcionesRespuesta.setFecha(nuevaFunciones.getFecha());
        funcionesRespuesta.setHora(nuevaFunciones.getHora());

        return null;
    }

}
