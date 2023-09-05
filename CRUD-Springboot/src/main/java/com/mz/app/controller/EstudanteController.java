package com.mz.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mz.app.model.Estudante;
import com.mz.app.services.EstudanteService;

@Controller
public class EstudanteController {

	@Autowired
	private EstudanteService estudanteService;
	
	//@GetMapping("/estudantes")
	@GetMapping({"/estudantes","/"})
	public ModelAndView listarEstudantes() {
		ModelAndView modelAndView = new ModelAndView("ListarEstudantes");
		Iterable<Estudante> estudante = estudanteService.listaTodosEstudantes();
		modelAndView.addObject("estudantes", estudante);
		return modelAndView;
	}
	
	/*@GetMapping({"/estudante/add"})
	public String FormEstudantes() {
		return "FormEstudantes";
	}*/
	
	@GetMapping("/estudantes/add")
	public ModelAndView FormEstudantes(Model model) {
		Estudante estudante = new Estudante();
		ModelAndView modelAndView = new ModelAndView("FormEstudantes");
		modelAndView.addObject("estudantes", estudante);
		return modelAndView;
	}
	
	@PostMapping("/estundantes")
	public String saveEstudantes(@ModelAttribute("estudante") Estudante estudante) {
		estudanteService.salvarEsudante(estudante);
		return "redirect:/";
	}
	
	@GetMapping("/estudantes/edit/{id}")
	public ModelAndView FormEstudantesEdit(@PathVariable Long id, Model modelo) {
		ModelAndView modelAndView = new ModelAndView("FormEstudantesEdit");
		Estudante estudante = new Estudante();
		estudante = estudanteService.findEstudanteById(id);
		modelAndView.addObject("estudantes", estudante);
		return modelAndView;
	}
	
	@GetMapping("/estundantes/eliminar/{id}")
	public String eleiminarEstudantes(@PathVariable Long id, Model modelo) {
		System.out.print("Teste");
		estudanteService.eliminarEstudante(id);
		return "redirect:/";
	}
	
	@PostMapping("/estundantes/{id}")
	public String actualizarEstudante(@PathVariable Long id, @ModelAttribute("estudante") Estudante estudante, Model modelo){
		Estudante estudanteExistemnte =  estudanteService.findEstudanteById(id);
		estudanteExistemnte.setId(id);
		estudanteExistemnte.setNome(estudante.getNome());
		estudanteExistemnte.setApelido(estudante.getApelido());
		estudanteExistemnte.setEmail(estudante.getEmail());
		estudanteService.actualizarEstudante(estudanteExistemnte);
		return "redirect:/";
	}
	
	
}
