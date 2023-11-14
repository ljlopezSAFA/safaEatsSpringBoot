package com.example.safaeats.controller;

import com.example.safaeats.dto.PersonaDTO;
import com.example.safaeats.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/listar")
    public List<PersonaDTO> listar() {
        return personaService.listar();
    }


    @PostMapping("/crear")
    public PersonaDTO crear(@RequestBody PersonaDTO personaDTO) {
        return personaService.crear(personaDTO);
    }
}
