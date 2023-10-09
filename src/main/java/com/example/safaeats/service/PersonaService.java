package com.example.safaeats.service;

import com.example.safaeats.converter.PersonaMapper;
import com.example.safaeats.dto.PersonaDTO;
import com.example.safaeats.model.Persona;
import com.example.safaeats.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;


    //Listar
    public List<PersonaDTO> listar(){
        return personaMapper.toDTO(personaRepository.findAll());
    }


    //Crear
    public PersonaDTO crear(PersonaDTO personaDTO){
       Persona personaGuardar = personaMapper.toEntity(personaDTO);
       Persona personaGuardada = personaRepository.save(personaGuardar);
       PersonaDTO personaGuardadaDTO = personaMapper.toDTO(personaGuardada);
       return personaGuardadaDTO;
    }


    //Editar

    //Borrar






}
