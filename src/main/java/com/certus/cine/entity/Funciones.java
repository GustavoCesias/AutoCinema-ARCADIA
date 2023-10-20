package com.certus.cine.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "funciones", uniqueConstraints = {@UniqueConstraint(columnNames = {"fecha", "hora"})})
public class Funciones {
    
    @Id
	@GeneratedValue(strategy =   GenerationType.IDENTITY)
	private Long id;
	@Column(name = "fecha", nullable = false)
    private Date fecha;
    @Column(name = "hora", nullable = false)
    private Time hora;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "funciones_projection_zones",
        joinColumns = @JoinColumn(name = "funcion_id"),
        inverseJoinColumns = @JoinColumn(name = "projection_zone_id")
    )
    private Set<ProjectionZone> projectionZones = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "funciones_peliculas",
        joinColumns = @JoinColumn(name = "funcion_id"),
        inverseJoinColumns = @JoinColumn(name = "pelicula_id")
    )
    private Set<Pelicula> peliculas = new HashSet<>();
    
    @Column(name = "projection_zone_id") // Columna para el ID de ProjectionZone
    private Long projectionZoneId;
    
    @Column(name = "pelicula_id") // Columna para el ID de Pelicula
    private Long peliculaId;



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
    public Funciones(Long id, Date fecha, Time hora) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
    }
    public Funciones() {
        super();
    }
}
