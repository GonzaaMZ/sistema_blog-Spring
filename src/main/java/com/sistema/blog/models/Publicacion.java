package com.sistema.blog.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "publicaciones", uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo"})})
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Getter @Setter
    private Long id;

    @Column(name = "titulo", nullable = false)
    @Getter @Setter
    private String titulo;

    @Column(name = "descripcion", nullable = false)
    @Getter @Setter
    private String descripcion;

    @Column(name = "contenido", nullable = false)
    @Getter @Setter
    private String contenido;

}
