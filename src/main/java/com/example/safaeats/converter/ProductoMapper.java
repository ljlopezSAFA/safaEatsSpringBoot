package com.example.safaeats.converter;

import com.example.safaeats.dto.ProductoDTO;
import com.example.safaeats.dto.RestauranteDTO;
import com.example.safaeats.model.Producto;
import com.example.safaeats.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    RestauranteMapper restauranteMapper = Mappers.getMapper(RestauranteMapper.class);

    @Mapping(source = "restaurante", target = "restauranteDTO", qualifiedByName = "conversorRestauranteDTO")
    ProductoDTO toDTO(Producto producto);


    @Named("conversorRestauranteDTO")
    private RestauranteDTO conversorRestauranteDTO(Restaurante restaurante){
        return restauranteMapper.restauranteToRestauranteDTO(restaurante);
    }


}
