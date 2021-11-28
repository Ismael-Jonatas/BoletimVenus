package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.EstudanteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/estudante")
public class EstudanteController {
	
	@Autowired
	private EstudanteService estudanteService;

	@RequestMapping("/form")
	public String getFormEstudante(Model model) {
		model.addAttribute("estudante", new Estudante());
		return "/estudantes/form-estudante";
	}

	
	@RequestMapping(method = {RequestMethod.GET})
	public String getEstudantes(Model model) {
		model.addAttribute("estudantes", estudanteService.getEstudantes());
		return "/estudantes/list-estudantes";

	}


	@RequestMapping(value = "/{id}", method = {RequestMethod.GET})
	public String getEstudanteId(@PathVariable("id") Integer id, Model model) {
		Estudante estudante = estudanteService.getEstudanteId(id);
		model.addAttribute("estudante", estudante);
		return "/estudantes/form-estudante";
	}
	
	
	@RequestMapping(method = {RequestMethod.POST}) //P-R-G
	public String inserirEstudante(Estudante estudante, Model model) {
		
		if (estudanteService.getEstudanteId(estudante.getId()) == null) {
			estudanteService.inserirOuAtualizar(estudante);
		} else {
			estudanteService.inserirOuAtualizar(estudante);
		}
		
		model.addAttribute("estudantes", estudanteService.getEstudantes());
		return "redirect:/estudantes";
	}
	

}
