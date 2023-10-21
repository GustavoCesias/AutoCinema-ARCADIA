package com.certus.cine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certus.cine.dto.ProjectionZoneDTO;
import com.certus.cine.entity.ProjectionZone;
import com.certus.cine.repository.ProjectionZoneRepository;

@Service
public class ProjectionZoneServicioImpl implements ProjectionZoneServicio {

    @Autowired
    private ProjectionZoneRepository projectionZoneRepository;

    @Override
    public ProjectionZoneDTO creaProjectionZone(ProjectionZoneDTO projectionZoneDTO) {
        // Convertimos de DTO a entidad
        ProjectionZone projectionZone = new ProjectionZone();
        projectionZone.setId(projectionZoneDTO.getId());
        projectionZone.setNombre(projectionZoneDTO.getNombre());
        projectionZone.setCapacidad(projectionZoneDTO.getCapacidad());

        ProjectionZone nuevaProjectionZone = projectionZoneRepository.save(projectionZone);

        // Convertimos de entidad a DTO

        ProjectionZoneDTO projectionZoneRespuesta = new ProjectionZoneDTO();
        projectionZoneRespuesta.setId(nuevaProjectionZone.getId());
        projectionZoneRespuesta.setNombre(nuevaProjectionZone.getNombre());
        projectionZoneRespuesta.setCapacidad(nuevaProjectionZone.getCapacidad());

        return null;
    }

}
