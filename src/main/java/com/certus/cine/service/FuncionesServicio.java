package com.certus.cine.service;

import com.certus.cine.dto.FuncionesDTO;

public interface FuncionesServicio {
    public FuncionesDTO crearFuncion(long peliculaId, long projectionZoneId, FuncionesDTO funcionesDTO);
}
