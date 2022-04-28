package com.sistema.blog.service;

import com.sistema.blog.dto.ComentarioDTO;
import com.sistema.blog.models.Comentario;

import java.util.List;

public interface ComentarioService {

    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentarioDTO);

    public List<ComentarioDTO> obtenerComentariosPorPublicacionId(long publicacionId);

    public ComentarioDTO obtenerComentarioById(long publicacionId, long comentarioId);

    public ComentarioDTO actualizarComentario(long publicacionId, long comentarioId, ComentarioDTO solicitudComentario);

    public void eliminarComentario(long publicacionId, long comentarioId);
}
