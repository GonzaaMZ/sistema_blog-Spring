package com.sistema.blog.service;

import com.sistema.blog.dto.PublicacionDTO;
import com.sistema.blog.dto.PublicacionResponse;


public interface PublicacionService {

    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO);

    public PublicacionResponse obtenerPublicaciones(int numeroPagina, int tamañoPagina, String ordenarPor, String sortDir);

    public PublicacionDTO obtenerPublicacionByID(long id);

    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id);

    public void eliminarPublicacion(long id);
}
