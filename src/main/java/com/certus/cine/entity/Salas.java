package com.certus.cine.entity;

import java.util.HashSet;

//import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "salas")
public class Salas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreSala;
    private int capacidad;

    /*@ManyToMany
    @JoinTable(
        name = "sala_funciones",
        joinColumns = @JoinColumn(name = "sala_id"),
        inverseJoinColumns = @JoinColumn(name = "funciones_id")
    )
    private HashSet<Funciones> funciones = new HashSet<>();*/
    
    @OneToMany(mappedBy = "salas", cascade = CascadeType.ALL, orphanRemoval = true)
	private HashSet<Funciones> funciones = new HashSet<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreSala() {
        return nombreSala;
    }
    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Salas() {
        super();
    }


}
