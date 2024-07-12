package com.example.forohub.api.service;

import com.example.forohub.api.model.Perfil;
import com.example.forohub.api.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil savePerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public List<Perfil> findAllPerfiles() {
        return perfilRepository.findAll();
    }

    public Optional<Perfil> findPerfilById(Long id) {
        return perfilRepository.findById(id);
    }

    public void deletePerfil(Long id) {
        perfilRepository.deleteById(id);
    }
}
