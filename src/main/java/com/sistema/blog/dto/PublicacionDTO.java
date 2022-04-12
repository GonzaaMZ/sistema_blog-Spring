package com.sistema.blog.dto;

import lombok.Getter;
import lombok.Setter;

public class PublicacionDTO {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String titulo;

    @Getter @Setter
    private String contenido;

    @Getter @Setter
    private String descripcion;

    public PublicacionDTO(Long id, String titulo, String contenido, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.descripcion = descripcion;
    }

    public PublicacionDTO() {
    }
}
