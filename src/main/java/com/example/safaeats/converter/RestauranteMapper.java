package com.example.safaeats.converter;

import com.example.safaeats.dto.RestauranteDTO;
import com.example.safaeats.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {

    Restaurante toEntity(RestauranteDTO dto);

    @Mapping(target = "max_comensales" , source = "maxComensales")
    RestauranteDTO toDTO(Restaurante entity);

    List<Restaurante> toEntity(List<RestauranteDTO> dto);

    List<RestauranteDTO> toDTO(List<Restaurante> entity);








}
