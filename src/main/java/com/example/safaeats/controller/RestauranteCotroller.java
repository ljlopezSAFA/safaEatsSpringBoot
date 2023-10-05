package com.example.safaeats.controller;

import com.example.safaeats.dto.RestauranteDTO;
import com.example.safaeats.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestauranteCotroller {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping(value = "/listar")
    public List<RestauranteDTO> listarRestaurantes(){
        return restauranteService.listarRestaurantes();
    }

}
