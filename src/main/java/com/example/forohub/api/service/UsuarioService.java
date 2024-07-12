package com.example.forohub.api.service;

import com.example.forohub.api.model.Usuario;
import com.example.forohub.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioByCorreoElectronico(String correoElectronico) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByCorreoElectronico(correoElectronico);
        return optionalUsuario.orElseThrow(() -> new RuntimeException("Usuario no encontrado con correo: " + correoElectronico));
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }
}
