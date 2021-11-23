package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	
	@RequestMapping(method = {RequestMethod.POST}) //P-R-G
	public String inserirEstudante(Estudante estudante, Model model) {
		if ()
		model.addAllAttributes("estudante", estudanteService.)
	}
	

}
