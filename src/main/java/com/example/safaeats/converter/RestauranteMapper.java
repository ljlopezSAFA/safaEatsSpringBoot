package com.example.safaeats.converter;

import com.example.safaeats.dto.RestauranteDTO;
import com.example.safaeats.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RestauranteMapper {

    @Mapping(target = "max_comensales" , source = "maxComensales")
    RestauranteDTO restauranteToRestauranteDTO(Restaurante restaurante);








}
