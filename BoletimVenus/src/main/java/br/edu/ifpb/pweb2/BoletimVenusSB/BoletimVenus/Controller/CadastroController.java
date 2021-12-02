package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.EstudanteService;

@Controller
@RequestMapping("/cadastro")

public class CadastroController {

	@Autowired
	private EstudanteService estudanteservice;
	
	
	@RequestMapping
	public String getFromCadastro(Model model) {
		model.addAttribute("estudante", new Estudante());
		return "/cadastro/form-cadastro";
	}
	
	
	
}
