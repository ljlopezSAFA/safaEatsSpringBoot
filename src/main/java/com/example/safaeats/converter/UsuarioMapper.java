package com.example.safaeats.converter;

import com.example.safaeats.dto.UsuarioDTO;
import com.example.safaeats.model.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toDTO(Usuario entity);

    Usuario toEntity(UsuarioDTO dto);

    List<UsuarioDTO> toDTO(List<Usuario> listEntity);

    List<Usuario> toEntity(List<UsuarioDTO> listDTOs);
}
