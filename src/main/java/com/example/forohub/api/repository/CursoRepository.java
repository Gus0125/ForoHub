package com.example.forohub.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.forohub.api.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
