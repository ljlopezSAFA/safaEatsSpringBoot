package com.example.safaeats.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class ProductoDTO {

    private Integer id;

    private String nombre;

    private String descripcion;

    private Double precio;

    private Integer idRestaurante;

}
