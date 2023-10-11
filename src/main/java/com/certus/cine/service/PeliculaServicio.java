package com.certus.cine.service;

import java.util.List;

import com.certus.cine.dto.PeliculaDTO;
import com.certus.cine.dto.PeliculaRespuesta;

public interface PeliculaServicio {

	public PeliculaDTO publicarPelicula(PeliculaDTO peliculaDTO);
	
	public PeliculaRespuesta obtenerTodasLasPeliculas(int numeroDePagina, int medidaDePagina);
	
	public PeliculaDTO obtenerPeliculaPorId(long id);
	
	public PeliculaDTO actualizarPelicula(PeliculaDTO peliculaDTO, long id);
	
	public void  eliminarPelicula(long id );
	
}
