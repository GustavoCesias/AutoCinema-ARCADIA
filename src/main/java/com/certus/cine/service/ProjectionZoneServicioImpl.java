package com.certus.cine.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.certus.cine.dto.ProjectionZoneDTO;
import com.certus.cine.dto.ProjectionZoneRespuesta;
import com.certus.cine.entity.ProjectionZone;
import com.certus.cine.exceptions.ResourceNotFoundExceptions;
import com.certus.cine.repository.ProjectionZoneRepository;

@Service
public class ProjectionZoneServicioImpl implements ProjectionZoneServicio {

    @Autowired
    private ProjectionZoneRepository projectionZoneRepository;

    @Override
    public ProjectionZoneDTO creaProjectionZone(ProjectionZoneDTO projectionZoneDTO) {
        ProjectionZone projectionZone = mapearEntidad(projectionZoneDTO);

        ProjectionZone nuevaProjectionZone = projectionZoneRepository.save(projectionZone);

        return mapearDTO(nuevaProjectionZone);
    }

    @Override
    public ProjectionZoneRespuesta obtenerTodasProjectionZones(int numeroDePagina, int medidaDePagina,
            String ordenarPor, String sorDirt) {

        Sort sort = sorDirt.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending()
                : Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

        Page<ProjectionZone> projectionZone = projectionZoneRepository.findAll(pageable);

        List<ProjectionZone> listaProjectionZones = projectionZone.getContent();
        List<ProjectionZoneDTO> contenido = listaProjectionZones.stream().map(this::mapearDTO)
                .collect(Collectors.toList());

        ProjectionZoneRespuesta projectionZoneRespuesta = new ProjectionZoneRespuesta();
        projectionZoneRespuesta.setContenido(contenido);
        projectionZoneRespuesta.setNumeroPagina(projectionZone.getNumber());
        projectionZoneRespuesta.setMedidaPagina(projectionZone.getSize());
        projectionZoneRespuesta.setTotalElementos(projectionZone.getTotalElements());
        projectionZoneRespuesta.setTotalPaginas(projectionZone.getTotalPages());
        projectionZoneRespuesta.setUltima(projectionZone.isLast());

        return projectionZoneRespuesta;
    }

    @Override
    public ProjectionZoneDTO obtenerProjectionZonePorId(long id) {
        ProjectionZone projectionZone = projectionZoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("ProjectionZone", "id", id));

        return mapearDTO(projectionZone);
    }

    @Override
    public ProjectionZoneDTO actualizarProjectionZone(ProjectionZoneDTO projectionZoneDTO, long id) {
        ProjectionZone projectionZone = projectionZoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("ProjectionZone", "id", id));

        projectionZone.setNombre(projectionZoneDTO.getNombre());
        projectionZone.setCapacidad(projectionZoneDTO.getCapacidad());

        ProjectionZone updatedProjectionZone = projectionZoneRepository.save(projectionZone);

        return mapearDTO(updatedProjectionZone);
    }

    @Override
    public void eliminarProjectionZone(long id) {
        ProjectionZone projectionZone = projectionZoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("ProjectionZone", "id", id));

        projectionZoneRepository.delete(projectionZone);
    }

    // Métodos auxiliares de mapeo

    private ProjectionZoneDTO mapearDTO(ProjectionZone projectionZone) {
        ProjectionZoneDTO projectionZoneRespuesta = new ProjectionZoneDTO();
        projectionZoneRespuesta.setId(projectionZone.getId()); // Configura el ID
        projectionZoneRespuesta.setNombre(projectionZone.getNombre());
        projectionZoneRespuesta.setCapacidad(projectionZone.getCapacidad());
        return projectionZoneRespuesta;
    }

    private ProjectionZone mapearEntidad(ProjectionZoneDTO projectionZoneDTO) {
        ProjectionZone projectionZone = new ProjectionZone();
        projectionZone.setId(projectionZoneDTO.getId());
        projectionZone.setNombre(projectionZoneDTO.getNombre());
        projectionZone.setCapacidad(projectionZoneDTO.getCapacidad());
        return projectionZone;
    }
}
