package com.example.safaeats.security.service;

import com.example.safaeats.model.Usuario;

public interface IJwtService {
    String extractUserName(String token);

    String generateToken(Usuario usuario);

    boolean isTokenValid(String token, Usuario usuario);
}
