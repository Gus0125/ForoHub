package com.example.forohub.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.forohub.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreoElectronico(String correoElectronico);
}
