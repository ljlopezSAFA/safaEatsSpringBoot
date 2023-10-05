package com.example.safaeats.dto;

import com.example.safaeats.model.enums.TipoRestaurante;
import lombok.Data;

@Data
public class RestauranteDTO {

    private Integer id;
    private String nombre;
    private String direccion;
    private Integer max_comensales;
    private TipoRestaurante tipoRestaurante;


}
