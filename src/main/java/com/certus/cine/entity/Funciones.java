package com.certus.cine.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "funciones")
public class Funciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    @Column(name = "hora", nullable = false)
    private Date hora;
    @Column(name = "numeroEntradas", nullable = false)
    private int numeroEntradas;
    @Column(name = "precioEntrada", nullable = false)
    private int precioEntrada;

    /*@ManyToMany
    @JoinTable(
        name = "pelicula_funciones",
        joinColumns = @JoinColumn(name = "proyeccion_id"),
        inverseJoinColumns = @JoinColumn(name = "peliculas_id")
    )*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelicula_id", nullable = false)
    private Pelicula pelicula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salas_id", nullable = false)
    private Salas salas;

    public Salas getSalas() {
        return salas;
    }

    public void setSalas(Salas salas) {
        this.salas = salas;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getHora() {
        return hora;
    }
    public void setHora(Date hora) {
        this.hora = hora;
    }
    public int getNumeroEntradas() {
        return numeroEntradas;
    }
    public void setNumeroEntradas(int numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
    }
    public int getPrecioEntrada() {
        return precioEntrada;
    }
    public void setPrecioEntrada(int precioEntrada) {
        this.precioEntrada = precioEntrada;
    }
    public Funciones() {
        super();
    }
}
