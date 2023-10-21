package com.certus.cine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certus.cine.dto.ProjectionZoneDTO;
import com.certus.cine.service.ProjectionZoneServicio;

@RestController
@RequestMapping("/api/ProjectionZone")
public class ProjectionZoneController {
    
    @Autowired
    private ProjectionZoneServicio projectionZoneServicio;

    @PostMapping
    public ResponseEntity<ProjectionZoneDTO> guardarProjectionZone(@RequestBody ProjectionZoneDTO projectionZoneDTO){
        return new ResponseEntity<>(projectionZoneServicio.creaProjectionZone(projectionZoneDTO), HttpStatus.CREATED);
        
    }

}
