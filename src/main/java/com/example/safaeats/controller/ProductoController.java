package com.example.safaeats.controller;

import com.example.safaeats.dto.ProductoDTO;
import com.example.safaeats.model.Producto;
import com.example.safaeats.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


@GetMapping(value = "/listar")
public List<Producto> listarProductos(){
    return productoService.listarProductos();
}


@PostMapping(value = "/crear")
public Producto crearProducto(@RequestBody ProductoDTO productoDTO){
    return productoService.crearProducto(productoDTO);
}

@PutMapping(value = "/modificar")
public Producto modificarProducto(@RequestBody ProductoDTO productoDTO){
    return productoService.modificarProducto(productoDTO);
}

@DeleteMapping(value = "/eliminar")
public String eliminarProducto(@RequestBody ProductoDTO productoDTO){
    return productoService.eliminarProducto(productoDTO);
}


}