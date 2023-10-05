package com.example.safaeats.service;

import com.example.safaeats.dto.RestauranteDTO;
import com.example.safaeats.model.Restaurante;
import com.example.safaeats.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;


    public List<RestauranteDTO> listarRestaurantes(){

        List<RestauranteDTO> listRestaurantes = new ArrayList<>();
        restauranteRepository.findAll().forEach(r-> listRestaurantes.add(convertir(r)));

        return listRestaurantes ;
    }



    private RestauranteDTO convertir(Restaurante restaurante){
        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(restaurante.getId());
        restauranteDTO.setNombre(restaurante.getNombre());
        restauranteDTO.setMax_comensales(restaurante.getMaxComensales());
        restauranteDTO.setDireccion(restaurante.getDireccion());
        restauranteDTO.setTipoRestaurante(restaurante.getTipo());
        return  restauranteDTO;
    }





}
