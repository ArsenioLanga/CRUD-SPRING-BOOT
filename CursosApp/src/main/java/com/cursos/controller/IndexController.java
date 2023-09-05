package com.cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cursos.model.Curso;
import com.cursos.repository.CursosRepository;


@Controller
public class IndexController {
	
	@Autowired
	private CursosRepository cursosRepository;
	
//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}
	
	@GetMapping("/")
	public ModelAndView listar4() {
		ModelAndView modelAndView = new ModelAndView("index");
//		modelAndView.addObject("cursos", cursosRepository.findAll());
		Iterable<Curso> c = cursosRepository.findAll();
		modelAndView.addObject("cursos", c);
//		modelAndView.addObject(new Curso());
		return modelAndView;
	}
	
}
