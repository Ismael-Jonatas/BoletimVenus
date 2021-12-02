package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.EstudanteService;

@Controller
@RequestMapping("/notas")


public class NotasController {

	@Autowired
	private EstudanteService estudanteservice;
	
	
	@RequestMapping
	public String getFromNotas(Model model) {
		model.addAttribute("estudante", new Estudante());
		return "/notas/form-notas";
	}
	
	
	
	
}
