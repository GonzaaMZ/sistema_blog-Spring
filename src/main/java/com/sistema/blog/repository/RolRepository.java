package com.sistema.blog.repository;

import java.util.Optional;

import com.sistema.blog.models.Rol;
import com.sistema.blog.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {

    public Optional<Rol> findByNombre(String nombre);

}
