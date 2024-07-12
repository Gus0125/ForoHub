package com.example.forohub.api.service;

import com.example.forohub.api.model.Curso;
import com.example.forohub.api.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> findAllCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findCursoById(Long id) {
        return cursoRepository.findById(id);
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
