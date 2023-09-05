package com.mz.app.services;

import java.util.List;

import com.mz.app.model.Estudante;

public interface EstudanteService {

	public List<Estudante> listaTodosEstudantes();
	
	public Estudante salvarEsudante(Estudante estudante);
	
	public Estudante findEstudanteById(Long id);
	
	public Estudante actualizarEstudante(Estudante estudante);
	
	public void eliminarEstudante(Long id);
}
