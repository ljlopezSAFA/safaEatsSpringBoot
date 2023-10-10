package com.example.safaeats.converter;

import com.example.safaeats.dto.ProductoDTO;
import com.example.safaeats.dto.RestauranteDTO;
import com.example.safaeats.model.Producto;
import com.example.safaeats.model.Restaurante;
import com.example.safaeats.service.RestauranteService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductoMapper {

    @Autowired
    protected RestauranteService restauranteService;

    RestauranteMapper restauranteMapper = Mappers.getMapper(RestauranteMapper.class);

    @Mapping(source = "restauranteDTO", target = "restaurante", qualifiedByName = "conversorRestauranteEntity")
    public abstract Producto toEntity(ProductoDTO dto);

    @Mapping(source = "restaurante", target = "restauranteDTO", qualifiedByName = "conversorRestauranteDTO")
    public abstract ProductoDTO toDTO(Producto entity);

    public abstract List<Producto> toEntity(List<ProductoDTO> dto);

    public  abstract List<ProductoDTO> toDTO(List<Producto> entity);

    @Named(value = "conversorRestauranteEntity")
    Restaurante conversor(RestauranteDTO dto){
       return restauranteService.getById(dto.getId());
    }

    @Named(value = "conversorRestauranteDTO")
    RestauranteDTO conversor(Restaurante entity){
        return restauranteMapper.toDTO(entity);
    }


}
