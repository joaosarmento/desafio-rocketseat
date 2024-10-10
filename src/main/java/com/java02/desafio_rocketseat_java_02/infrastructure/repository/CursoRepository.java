package com.java02.desafio_rocketseat_java_02.infrastructure.repository;

import com.java02.desafio_rocketseat_java_02.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
