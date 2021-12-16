package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.EstudanteService;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class RelatorioController {

	@Autowired
	private EstudanteService estudanteservice;

	@GetMapping("/relatorio")
	public String getFromRelatorio(Model model) {
		List<Estudante> estudantes = estudanteservice.getEstudantes();
		model.addAttribute("estudantes", estudantes);
		model.addAttribute("format", new SimpleDateFormat("dd/MM/yyyy"));
		return "/relatorio/form-relatorio";
	}
}