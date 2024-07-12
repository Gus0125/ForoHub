package com.example.forohub.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.forohub.api.model.Usuario;
import com.example.forohub.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> registerUsuario(@RequestBody Usuario usuario) {
        Usuario newUser = usuarioService.registerUsuario(usuario);
        return ResponseEntity.ok(newUser);
    }
}
