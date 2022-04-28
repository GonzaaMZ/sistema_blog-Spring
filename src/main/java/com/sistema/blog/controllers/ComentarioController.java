package com.sistema.blog.controllers;


import com.sistema.blog.dto.ComentarioDTO;
import com.sistema.blog.models.Comentario;
import com.sistema.blog.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/publicaciones/{publicacionId}/comentarios")
    public List<ComentarioDTO> listarComentariosPorPublicacionId(@PathVariable(value = "publicacionId") long publicacionId){

        return comentarioService.obtenerComentariosPorPublicacionId(publicacionId);

    }


    @PostMapping("/publicaciones/{publicacionId}/comentarios")
    public ResponseEntity<ComentarioDTO> guardarComentario (@PathVariable(value = "publicacionId") long publicacionId,
                                                            @Valid @RequestBody ComentarioDTO comentarioDTO){

        return new ResponseEntity<>(comentarioService.crearComentario(publicacionId, comentarioDTO), HttpStatus.CREATED);

    }

    @GetMapping("/publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<ComentarioDTO> obtenerComentarioById(@PathVariable(value = "publicacionId") long publicacionId,
                                                               @PathVariable(value = "id") long comentarioId){

        ComentarioDTO comentarioDTO = comentarioService.obtenerComentarioById(publicacionId, comentarioId);
        return new ResponseEntity<>(comentarioDTO, HttpStatus.OK);
    }

    @PutMapping("/publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<ComentarioDTO> actualizarComentario(@PathVariable(value = "publicacionId") long publicacionId,
                                                              @PathVariable(value = "id") long comentarioId,
                                                              @Valid  @RequestBody ComentarioDTO comentarioDTO){
        ComentarioDTO comentarioActualizado = comentarioService.actualizarComentario(publicacionId, comentarioId,comentarioDTO);

        return new ResponseEntity<>(comentarioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<String> eliminarComentario(@PathVariable(value = "publicacionId") long publicacionId,
                                                     @PathVariable(value = "id") long comentarioId){
        comentarioService.eliminarComentario(publicacionId, comentarioId);
        return new ResponseEntity<>("Comentario eliminado con exito", HttpStatus.OK);
    }





}
