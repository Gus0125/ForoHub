package com.example.forohub.api.service;

import com.example.forohub.api.model.Respuesta;
import com.example.forohub.api.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    public Respuesta saveRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public List<Respuesta> findAllRespuestas() {
        return respuestaRepository.findAll();
    }

    public Optional<Respuesta> findRespuestaById(Long id) {
        return respuestaRepository.findById(id);
    }

    public void deleteRespuesta(Long id) {
        respuestaRepository.deleteById(id);
    }
}
