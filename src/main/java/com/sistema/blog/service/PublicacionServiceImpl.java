package com.sistema.blog.service;


import com.sistema.blog.dto.PublicacionDTO;
import com.sistema.blog.exceptions.ResourceNotFoundException;
import com.sistema.blog.models.Publicacion;
import com.sistema.blog.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    //Create
    @Override
    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO) {

       Publicacion publicacion = mapearEntidad(publicacionDTO);

       Publicacion newPublicacion = publicacionRepository.save(publicacion);

       PublicacionDTO publicacionResponse = mapearDTO(newPublicacion);

        return publicacionResponse;
    }

    //Get All
    @Override
    public List<PublicacionDTO> obtenerPublicaciones() {

        List<Publicacion> publicaciones = publicacionRepository.findAll();
        return publicaciones.stream().map(publicacion -> mapearDTO(publicacion)).collect(Collectors.toList());

    }

    //Get by ID
    @Override
    public PublicacionDTO obtenerPublicacionByID(long id) {
        Publicacion publicacion = publicacionRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion" ,"ID", id));
        return mapearDTO(publicacion);
    }

    @Override
    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id) {
        Publicacion publicacion = publicacionRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "ID", id));

        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setContenido(publicacionDTO.getContenido());

        Publicacion publicacionActualizada = publicacionRepository.save(publicacion);
        return mapearDTO(publicacionActualizada);
    }

    @Override
    public void eliminarPublicacion(long id) {
        Publicacion publicacion = publicacionRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "ID", id));

        publicacionRepository.delete(publicacion);
    }

    //Convierte entidad a DTO
    private PublicacionDTO mapearDTO(Publicacion publicacion){

        PublicacionDTO publicacionDTO = new PublicacionDTO();

        publicacionDTO.setId(publicacion.getId());
        publicacionDTO.setTitulo(publicacion.getTitulo());
        publicacionDTO.setDescripcion(publicacion.getDescripcion());
        publicacionDTO.setContenido(publicacion.getContenido());

        return publicacionDTO;

    }



    //Convierte DTO a entidad
    private Publicacion mapearEntidad(PublicacionDTO publicacionDTO){

        Publicacion publicacion = new Publicacion();

        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setContenido(publicacionDTO.getContenido());

        return publicacion;

    }
}
