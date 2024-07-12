package com.example.forohub.api.service;

import com.example.forohub.api.model.Usuario;
import com.example.forohub.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreoElectronico(correoElectronico);

        if (usuarioOptional.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado con correo: " + correoElectronico);
        }

        return usuarioOptional.get();
    }
}
