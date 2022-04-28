package com.sistema.blog.service;


import com.sistema.blog.dto.PublicacionDTO;
import com.sistema.blog.dto.PublicacionResponse;
import com.sistema.blog.exceptions.ResourceNotFoundException;
import com.sistema.blog.models.Publicacion;
import com.sistema.blog.repository.PublicacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    private ModelMapper modelMapper;

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
    public PublicacionResponse obtenerPublicaciones(int numeroPagina, int tamañoPagina, String ordenarPor, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroPagina, tamañoPagina, sort);
        Page<Publicacion> publicaciones = publicacionRepository.findAll(pageable);

        List<Publicacion> listaPublicaciones = publicaciones.getContent();
        List<PublicacionDTO> contenido = listaPublicaciones.stream().map(publicacion -> mapearDTO(publicacion)).collect(Collectors.toList());

        PublicacionResponse publicacionResponse = new PublicacionResponse();
        publicacionResponse.setContenido(contenido);
        publicacionResponse.setNumeroPagina(publicaciones.getNumber());
        publicacionResponse.setMedidaPagina(publicaciones.getSize());
        publicacionResponse.setTotalElementos(publicaciones.getTotalElements());
        publicacionResponse.setTotalPaginas(publicaciones.getTotalPages());
        publicacionResponse.setUltima(publicaciones.isLast());

        return publicacionResponse;
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

        PublicacionDTO  publicacionDTO = modelMapper.map(publicacion, PublicacionDTO.class);

        return publicacionDTO;

    }



    //Convierte DTO a entidad
    private Publicacion mapearEntidad(PublicacionDTO publicacionDTO){

        Publicacion publicacion = modelMapper.map(publicacionDTO, Publicacion.class);
        return publicacion;


    }
}
