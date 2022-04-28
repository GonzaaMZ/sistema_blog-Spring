package com.sistema.blog.dto;

import com.sistema.blog.models.Comentario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

public class PublicacionDTO {

    @Getter @Setter
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "El titulo de la publicación debe tener al menos 2 caracteres")
    @Getter @Setter
    private String titulo;

    @NotEmpty
    @Getter @Setter
    private String contenido;

    @NotEmpty
    @Size(min = 10, message = "La descripción de la publicación debe tener al menos 10 caracteres")
    @Getter @Setter
    private String descripcion;

    @Getter @Setter
    private Set<Comentario> comentarios;

    public PublicacionDTO(Long id, String titulo, String contenido, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.descripcion = descripcion;
    }

    public PublicacionDTO() {
    }
}
