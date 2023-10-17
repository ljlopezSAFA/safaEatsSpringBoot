package com.example.safaeats.security.service;

import com.example.safaeats.converter.UsuarioMapper;
import com.example.safaeats.dto.LoginDTO;
import com.example.safaeats.dto.UsuarioDTO;
import com.example.safaeats.security.auth.AuthenticationResponseDTO;
import com.example.safaeats.security.service.JwtService;
import com.example.safaeats.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UsuarioService usuarioService;

    private final UsuarioMapper usuarioMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthenticationResponseDTO register(UsuarioDTO usuarioDTO){
        usuarioDTO.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
        UsuarioDTO dto = usuarioService.save(usuarioDTO);
        String token = jwtService.generateToken(usuarioMapper.toEntity(dto));
        return AuthenticationResponseDTO
                .builder()
                .token(token)
                .build();
    }

    public AuthenticationResponseDTO login(LoginDTO loginDTO){
        UsuarioDTO user = usuarioService.getByUsername(loginDTO.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword(),
                        List.of(new SimpleGrantedAuthority(user.getRol().name()))
                )
        );
        String token = jwtService.generateToken(usuarioMapper.toEntity(user));
        return  AuthenticationResponseDTO
                .builder()
                .token(token)
                .build();
    }
}
