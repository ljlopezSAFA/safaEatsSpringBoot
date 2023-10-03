package com.example.safaeats.repository;

import com.example.safaeats.model.Producto;
import com.example.safaeats.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {

    @Query("select r from Restaurante r join Producto p on p.restaurante = r  where p = :producto ")
    List<Restaurante> obtenerRestaurantesQueContenganProducto(Producto producto);
}
