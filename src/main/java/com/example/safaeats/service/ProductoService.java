package com.example.safaeats.service;


import com.example.safaeats.converter.ProductoMapper;
import com.example.safaeats.dto.CrearProductoDTO;
import com.example.safaeats.dto.ProductoDTO;
import com.example.safaeats.model.Producto;
import com.example.safaeats.model.Restaurante;
import com.example.safaeats.repository.ProductoRepository;
import com.example.safaeats.repository.RestauranteRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private ProductoMapper productoMapper;


    /**
     * Lista todos los productos
     *
     * @return
     */
    public List<ProductoDTO> listarProductos() {
        return productoMapper.toDTO(productoRepository.findAll());
    }


    public ProductoDTO crearProducto(ProductoDTO productoDTO){
        return productoMapper.toDTO(productoRepository.save(productoMapper.toEntity(productoDTO)));
    }

    public Producto modificarProducto(ProductoDTO productoDTO){
        Producto producto = productoRepository.findById(productoDTO.getId()).orElse(null);

        if(producto == null){
            return null;
        }else{
            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());

            Restaurante restaurante = restauranteRepository.findById(productoDTO.getRestauranteDTO().getId()).orElse(null);

            if(restaurante == null){
                return null;

            }else{
                producto.setRestaurante(restaurante);
                Producto productoModificado = productoRepository.save(producto);
                return productoModificado;
            }
        }

    }



    public String eliminarProducto(ProductoDTO productoDTO){
        Producto productoEliminar = productoRepository.findById(productoDTO.getId()).orElse(null);
        if(productoEliminar != null){
            productoRepository.delete(productoEliminar);
            return "Datos eliminados correctamente";
        }else{
          return "No se ha podido eliminar su producto";
        }
    }






}
