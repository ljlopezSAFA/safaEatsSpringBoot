package com.example.safaeats.service;


import com.example.safaeats.dto.CrearProductoDTO;
import com.example.safaeats.dto.ProductoDTO;
import com.example.safaeats.dto.RestauranteDTO;
import com.example.safaeats.model.Producto;
import com.example.safaeats.model.Restaurante;
import com.example.safaeats.repository.ProductoRepository;
import com.example.safaeats.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;


    /**
     * Lista todos los productos
     *
     * @return
     */
    public List<ProductoDTO> listarProductos() {

        List<Producto> listaProductos = productoRepository.findAll();
        List<ProductoDTO> productoDTOS = new ArrayList<>();

        for( Producto p : listaProductos){
            ProductoDTO dto = new ProductoDTO();
            dto.setId(p.getId());
            dto.setNombre(p.getNombre());
            dto.setDescripcion(p.getDescripcion());
            dto.setPrecio(p.getPrecio());

            RestauranteDTO resDTO = new RestauranteDTO();
            resDTO.setId(p.getRestaurante().getId());
            resDTO.setNombre(p.getRestaurante().getNombre());
            resDTO.setMax_comensales(p.getRestaurante().getMaxComensales());
            resDTO.setDireccion(p.getRestaurante().getDireccion());

            dto.setRestauranteDTO(resDTO);
            productoDTOS.add(dto);
        }


        return productoDTOS;
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
