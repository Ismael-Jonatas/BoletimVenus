package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.EstudanteService;

@Controller

public class CadastrarEstudanteController {

	@Autowired
	private EstudanteService estudanteservice;
	
	// correto
	@GetMapping("/cadastro")
	public String getFromCadastro(Model model) {
		model.addAttribute("estudante", new Estudante());
		return "/cadastro/form-cadastroEstudante";
	}

	/*
	@PostMapping("/cadastro/adicionar")
	public String adicionarNotas(@ModelAttribute Estudante estudante) {
		CadastroEstudante(estudante);
		this.estudanteservice.inserirOuAtualizar(estudante);
		return "redirect:/cadastro";
	}
	*/
	
	@PostMapping("/cadastro/adicionar")
	public ModelAndView adicionarEstudante(ModelAndView modelAndView, @Valid Estudante estudante, Errors errors, RedirectAttributes redirectAttts) {
		
		if (null != errors && errors.getErrorCount() > 0) {
			redirectAttts.addFlashAttribute("mensagem", errors.getAllErrors().get(0).getDefaultMessage());
			modelAndView.setViewName("redirect:/cadastro");
		}else {
			//CadastroEstudante(estudante);
			this.estudanteservice.inserirOuAtualizar(estudante);
			redirectAttts.addFlashAttribute("mensagem", "Aluno Cadastrado");
			modelAndView.setViewName("redirect:/cadastro");
			
		}
		return modelAndView;
	}
	
	public void CadastroEstudante(Estudante estudante) {
		Date dataNascimento = new Date(estudante.getDataNascimento().getTime());
		String nome = estudante.getNome();
	}
}
