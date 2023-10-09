package com.example.safaeats.converter;

import com.example.safaeats.dto.ProductoDTO;
import com.example.safaeats.model.Producto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {


    Producto toEntity(ProductoDTO dto);

    ProductoDTO toDTO(Producto entity);

    List<Producto> toEntity(List<ProductoDTO> dto);

    List<ProductoDTO> toDTO(List<Producto> entity);


}
