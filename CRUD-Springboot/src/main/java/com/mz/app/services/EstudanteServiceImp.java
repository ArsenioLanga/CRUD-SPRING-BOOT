package com.mz.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.app.model.Estudante;
import com.mz.app.repository.EstudanteRepository;

@Service
public class EstudanteServiceImp implements EstudanteService {
	
	@Autowired
	EstudanteRepository estudanteRepository;
	
	@Override
	public List<Estudante> listaTodosEstudantes() {
		
		return estudanteRepository.findAll();
		
	}

	@Override
	public Estudante salvarEsudante(Estudante estudante) {
		return estudanteRepository.save(estudante);
	}

	@Override
	public Estudante findEstudanteById(Long id) {
		return estudanteRepository.findById(id).get();
	}

	@Override
	public Estudante actualizarEstudante(Estudante estudante) {
		
		
		
		return estudanteRepository.save(estudante);
	}

	@Override
	public void eliminarEstudante(Long id) {
		estudanteRepository.deleteById(id);	
	}

	

}
