package com.certus.cine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certus.cine.dto.FuncionesDTO;
import com.certus.cine.service.FuncionesServicio;

@RestController
@RequestMapping("/api/funciones")
public class FuncionesController {
    
    @Autowired
    private FuncionesServicio funcionesServicio;

    @PostMapping
    public ResponseEntity<FuncionesDTO> guardarFunciones(@RequestBody FuncionesDTO funcionesDTO){
        return new ResponseEntity<>(funcionesServicio.crearFuncion(funcionesDTO), HttpStatus.CREATED);
        
    }
}
