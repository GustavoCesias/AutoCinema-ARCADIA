package com.certus.cine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.certus.cine.dto.ProjectionZoneDTO;
import com.certus.cine.dto.ProjectionZoneRespuesta;
import com.certus.cine.service.ProjectionZoneServicio;
import com.certus.cine.util.AppConstants;

@RestController
@RequestMapping("/api/ProjectionZone")
public class ProjectionZoneController {

    @Autowired
    private ProjectionZoneServicio projectionZoneServicio;

    @GetMapping()
    public ProjectionZoneRespuesta listarProjectionZone(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroDePagina,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.ORDENAR_POR_DEFECTO, required = false) String ordenarPor,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.ORDENAR_DIRECCION_POR_DEFECTO, required = false) String sortDir) {
        return projectionZoneServicio.obtenerTodasProjectionZones(numeroDePagina, medidaDePagina, ordenarPor, sortDir);
    }

    @PostMapping
    public ResponseEntity<ProjectionZoneDTO> guardarProjectionZone(@RequestBody ProjectionZoneDTO projectionZoneDTO) {
        return new ResponseEntity<>(projectionZoneServicio.creaProjectionZone(projectionZoneDTO), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectionZoneDTO> obtenerProjectioZonePorId(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(projectionZoneServicio.obtenerProjectionZonePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectionZoneDTO> actualizarProjectionZone(@RequestBody ProjectionZoneDTO projectionZoneDTO,
            @PathVariable(name = "id") long id) {
        ProjectionZoneDTO nuevaProjectionZoneDTO = projectionZoneServicio.actualizarProjectionZone(projectionZoneDTO, id);
        return new ResponseEntity<>(nuevaProjectionZoneDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProjectionZone(@PathVariable(name = "id") long id) {
        projectionZoneServicio.eliminarProjectionZone(id);
        return new ResponseEntity<>("Publicacion eliminada con exito", HttpStatus.OK);
    }

}
