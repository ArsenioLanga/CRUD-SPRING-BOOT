package com.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.model.Curso;

public interface CursosRepository extends JpaRepository<Curso, Long> {

	Curso findByCodigo(long codigo);
}
