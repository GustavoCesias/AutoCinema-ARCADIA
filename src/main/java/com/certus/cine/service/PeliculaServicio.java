package com.certus.cine.service;



import com.certus.cine.dto.PeliculaDTO;
import com.certus.cine.dto.PeliculaRespuesta;

public interface PeliculaServicio {

	public PeliculaDTO publicarPelicula(PeliculaDTO peliculaDTO);
	
	public PeliculaRespuesta obtenerTodasLasPeliculas(int numeroDePagina, int medidaDePagina, String ordenarPor, String sorDirt);
	
	public PeliculaDTO obtenerPeliculaPorId(long id);
	
	public PeliculaDTO actualizarPelicula(PeliculaDTO peliculaDTO, long id);
	
	public void  eliminarPelicula(long id );
	
}
