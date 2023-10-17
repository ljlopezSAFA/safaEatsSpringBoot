package com.example.safaeats.dto;

import com.example.safaeats.model.enums.Rol;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer id;

    private String username;

    private String password;

    private Rol rol;

//    private PersonaDTO personaDTO;
}
