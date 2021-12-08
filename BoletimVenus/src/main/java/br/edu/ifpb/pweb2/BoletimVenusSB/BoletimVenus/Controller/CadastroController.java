package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.EstudanteService;

@Controller

public class CadastroController {

	@Autowired
	private EstudanteService estudanteservice;
	
	// correto
	@GetMapping("/cadastro")
	public String getFromCadastro(Model model) {
		model.addAttribute("estudante", new Estudante());
		return "/cadastro/form-cadastro";
	}
	
	@PostMapping("/cadastro/adicionar")
	public String adicionarNotas(@ModelAttribute Estudante estudante) {
		CadastroEstudante(estudante);
		this.estudanteservice.inserirOuAtualizar(estudante);
		return "redirect:/cadastro";
	}
	
	public void CadastroEstudante(Estudante estudante) {
		Date dataNascimento = new Date(estudante.getDataNascimento().getTime());
		String nome = estudante.getNome();
	}
}
