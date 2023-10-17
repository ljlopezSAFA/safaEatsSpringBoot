package com.example.safaeats.service;


import com.example.safaeats.converter.UsuarioMapper;
import com.example.safaeats.dto.UsuarioDTO;
import com.example.safaeats.model.Usuario;
import com.example.safaeats.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findTopByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));
    }

    public UsuarioDTO getByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findTopByUsername(username).orElse(null);

        if (usuario!=null){
            return usuarioMapper.toDTO(usuario);
        }else{
            throw  new UsernameNotFoundException("Usuario no encontrado");
        }

    }

    public UsuarioDTO save(UsuarioDTO usuarioDTO){
        return usuarioMapper.toDTO(usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO)));
    }
}
