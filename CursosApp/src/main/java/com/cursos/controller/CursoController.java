package com.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cursos.model.Aluno;
import com.cursos.model.Curso;
import com.cursos.repository.AlunosRepository;
import com.cursos.repository.CursosRepository;

import jakarta.validation.Valid;

@Controller
public class CursoController {

	@Autowired
	private CursosRepository cursosRepository;
	
	@Autowired
	private AlunosRepository alunosRepository;
	
	
	@GetMapping("/cadastrarCursos")
	public String form() {
		return "Curso/formCurso";
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView cursoDetalhes(@PathVariable("codigo") long codigo) {
		ModelAndView modelAndView = new ModelAndView("Curso/detalhesCurso");
		Curso cursos = cursosRepository.findByCodigo(codigo);
		Iterable<Aluno> alunos = alunosRepository.findByCurso(cursos); 
		modelAndView.addObject("detalhes", cursos);
		modelAndView.addObject("alunos", alunos);
		return modelAndView;
	}
	
	@RequestMapping("/deletar")
	public String deletarCurso(Long codigo) {
		System.out.print("Teste");
		Curso curso = cursosRepository.findByCodigo(codigo);
		cursosRepository.delete(curso);
		return "redirect:/";
	}
	
	@PostMapping("/{codigo}")
	public String gravarAluno(@PathVariable("codigo") long codigo, @Valid Aluno aluno, BindingResult result, RedirectAttributes attribute) {
		//		Validar formulario
		if(result.hasErrors()) {
			attribute.addFlashAttribute("mensagem", "Preencha todos os campos!");
			return "redirect:/{codigo}";
		}
		Curso curso = cursosRepository.findByCodigo(codigo);
		aluno.setCurso(curso); //Relacionamento
		alunosRepository.save(aluno);
		attribute.addFlashAttribute("mensagem", "Aluno inscrito com sucesso!");
		return "redirect:/{codigo}";
	}
	
	@PostMapping("/cadastrar")
	public String gravar( @Valid Curso curso, BindingResult result1, RedirectAttributes attributeCurso) {
//		Validar formulario
		if(result1.hasErrors()) {
			attributeCurso.addFlashAttribute("mensagemCursos", "Preencha todos os campos!");
			return "redirect:/cadastrarCursos";
		}
		cursosRepository.save(curso);
		attributeCurso.addFlashAttribute("mensagemCursos", "Gravado com sucesso!");
		return "redirect:/cadastrarCursos";
	}
	
	@RequestMapping("/deletarAluno")
	public String deletarAluno(Integer nuit) {
		
		List<Aluno> aluno = alunosRepository.findByNuit(nuit);

		Aluno alunoP = new Aluno();
		
		for (Aluno aluno2 : aluno) {
			alunoP.setNuit( aluno2.getNuit());
			alunoP.setIdade( aluno2.getIdade());
			alunoP.setNome( aluno2.getNome());
			alunoP.setCurso( aluno2.getCurso());
		}
		
		alunosRepository.delete(alunoP);
		
		Curso curso = alunoP.getCurso();
		Long codigoString = curso.getCodigo();
		String codigo = codigoString.toString();
		return "redirect:/"+codigo;
	}
	
	
}

