package com.example.safaeats.dto;

import lombok.Data;

@Data
public class CrearProductoDTO {

    private Integer id;

    private String nombre;

    private String descripcion;

    private Double precio;

    private Integer id_restaurante;

}
