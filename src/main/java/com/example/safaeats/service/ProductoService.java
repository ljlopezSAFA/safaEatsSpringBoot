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

    private ProductoMapper productoMapper;


    /**
     * Lista todos los productos
     *
     * @return
     */
    public List<ProductoDTO> listarProductos() {

        List<Producto> listaProductos = productoRepository.findAll();
        return listaProductos.stream().map(p-> productoMapper.toDTO(p)).collect(Collectors.toList());
    }


    public Producto crearProducto(CrearProductoDTO productoDTO){
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(productoDTO.getNombre());
        nuevoProducto.setDescripcion(productoDTO.getDescripcion());
        nuevoProducto.setPrecio(productoDTO.getPrecio());

        Restaurante restaurante = restauranteRepository.findById(productoDTO.getId_restaurante()).orElse(null);

        if(restaurante == null){
            return null;

        }else{
            nuevoProducto.setRestaurante(restaurante);
            Producto productoCreado = productoRepository.save(nuevoProducto);
            return productoCreado;
        }
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
