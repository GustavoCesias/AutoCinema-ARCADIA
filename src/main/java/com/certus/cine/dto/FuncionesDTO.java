package com.certus.cine.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

public class FuncionesDTO {

    private Long id;
    private Date fecha;
    private Time hora;
    private Set<Long> projectionZoneIds; // Para almacenar los IDs de las zonas de proyección asociadas.
    private Set<Long> peliculaIds; // Para almacenar los IDs de las películas asociadas.
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Time getHora() {
        return hora;
    }
    public void setHora(Time hora) {
        this.hora = hora;
    }
    public Set<Long> getProjectionZoneIds() {
        return projectionZoneIds;
    }
    public void setProjectionZoneIds(Set<Long> projectionZoneIds) {
        this.projectionZoneIds = projectionZoneIds;
    }
    public Set<Long> getPeliculaIds() {
        return peliculaIds;
    }
    public void setPeliculaIds(Set<Long> peliculaIds) {
        this.peliculaIds = peliculaIds;
    }

    public FuncionesDTO() {
    }

    
}
