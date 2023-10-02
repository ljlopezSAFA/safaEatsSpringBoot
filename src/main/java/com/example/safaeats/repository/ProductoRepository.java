package com.example.safaeats.repository;

import com.example.safaeats.model.Producto;
import com.example.safaeats.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    //USANDO JPA INTERFACE
    List<Producto> findAllByRestauranteEqualsOrderByPrecio(Restaurante restaurante);


    //NATIVE QUERIES
    @Query(value = "select p from producto p where id_restaurante = :id_restaurante order by precio asc", nativeQuery = true)
    List<Producto> obtenerProductos(int id_restaurante);

    //JPQL
    @Query("select p from Producto p where p.restaurante = :restaurante order by  p.precio desc")
    List<Producto> obtenerProductosRestaurantes(Restaurante restaurante);




}
