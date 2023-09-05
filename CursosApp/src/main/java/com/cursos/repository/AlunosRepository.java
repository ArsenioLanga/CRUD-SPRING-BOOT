package com.cursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.model.Aluno;
import com.cursos.model.Curso;


public interface AlunosRepository extends JpaRepository<Aluno, Integer> {
	Iterable<Aluno> findByCurso(Curso curso);
//	Aluno findbyNuit(Integer nuit);
	List<Aluno> findByNuit(Integer nuit);
}
