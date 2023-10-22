package com.certus.cine.service;


import com.certus.cine.dto.ProjectionZoneDTO;
import com.certus.cine.dto.ProjectionZoneRespuesta;

public interface ProjectionZoneServicio {
    public ProjectionZoneDTO creaProjectionZone(ProjectionZoneDTO projectionZoneDTO);

    public ProjectionZoneRespuesta obtenerTodasProjectionZones(int numeroDePagina, int medidaDePagina, String ordenarPor, String sorDirt);
	
	public ProjectionZoneDTO obtenerProjectionZonePorId(long id);
	
	public ProjectionZoneDTO actualizarProjectionZone(ProjectionZoneDTO projectionZoneDTO, long id);
	
	public void  eliminarProjectionZone(long id );
}
