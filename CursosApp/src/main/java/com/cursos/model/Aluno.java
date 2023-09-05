package com.cursos.model;




import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Aluno {

	@Id
	@NotNull
	private Integer nuit;
	@NotEmpty
	private  String nome;
	@NotNull
	private Integer idade;
	@ManyToOne
	private Curso curso;
	
	public Integer getNuit() {
		return nuit;
	}
	public void setNuit(Integer nuit) {
		this.nuit = nuit;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
}
