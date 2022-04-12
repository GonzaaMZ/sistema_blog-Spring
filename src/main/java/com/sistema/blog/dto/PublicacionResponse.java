package com.sistema.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PublicacionResponse {

    @Getter @Setter
    private List<PublicacionDTO> contenido;

    @Getter @Setter
    private int numeroPagina;

    @Getter @Setter
    private int medidaPagina;

    @Getter @Setter
    private long totalElementos;

    @Getter @Setter
    private int totalPaginas;

    @Getter @Setter
    private boolean ultima;
}
