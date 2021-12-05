package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.EstudanteService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Controller
public class RelatorioController {

	@Autowired
	private EstudanteService estudanteservice;

	@GetMapping("/relatorio")
	public String getFromRelatorio(Model model) {
		List<Estudante> estudantes = estudanteservice.getEstudantes();
		model.addAttribute("estudantes", estudantes);
		return "/relatorio/form-relatorio";
	}
}