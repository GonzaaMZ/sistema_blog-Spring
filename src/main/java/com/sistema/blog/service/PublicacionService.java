package com.sistema.blog.service;

import com.sistema.blog.dto.PublicacionDTO;

import java.util.List;

public interface PublicacionService {

    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO);

    public List<PublicacionDTO> obtenerPublicaciones();

    public PublicacionDTO obtenerPublicacionByID(long id);

    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id);

    public void eliminarPublicacion(long id);
}
