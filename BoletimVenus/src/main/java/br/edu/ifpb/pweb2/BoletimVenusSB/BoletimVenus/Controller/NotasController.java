package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Enum.Situacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.EstudanteService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

@Controller
public class NotasController {

	@Autowired
	private EstudanteService estudanteservice;

	@GetMapping("/notas")
	public String getFromNotas(Model model) {
		List<Estudante> estudantes = estudanteservice.getEstudantes();
		model.addAttribute("estudantes", estudantes);
		return "/notas/list-notas";
	}

	@GetMapping("/notas/adicionar")
	public String getListAlunosNotas(Model model) {
		model.addAttribute("estudante", new Estudante());
		return "/notas/list-notas";
	}

	@GetMapping("/notas/editar/{id}")
	public ModelAndView getListAlunosNotas(@PathVariable("id") Integer id) {
		ModelAndView editView = new ModelAndView("/notas/form-notas");
		Estudante estudante = this.estudanteservice.getEstudanteId(id);
		editView.addObject("estudante", estudante);
		return editView;
	}

	@GetMapping("/notas/deletar/{id}")
	public String deleteAlunoNota (@PathVariable("id") Integer id) {
		this.estudanteservice.apagarEstudante(id);
		return "redirect:/notas";
	}

	
	@PostMapping("/notas/adicionar")
	public String adicionarNotas(@ModelAttribute Estudante estudante) {

		calculaSituacao(estudante);

		this.estudanteservice.inserirOuAtualizar(estudante);
		return "redirect:/notas";
	}
	
	
	public void calculaSituacao(Estudante estudante) {
		final int FALTAS = 25;
		final int APROVACAO = 70;
		final int REPROVACAO = 40;

		BigDecimal nota1 = estudante.getNota1();
		BigDecimal nota2 = estudante.getNota2();
		BigDecimal nota3 = estudante.getNota3();
		BigDecimal media = estudante.getMedia();
		BigDecimal ntFinal = estudante.getNotaFinal();
		Integer faltas = estudante.getFaltas();

		if (nota1 == null || nota2 == null || nota3 == null || faltas == null) {
			estudante.setSituacao(Situacao.MT);
		}
		else if (nota1 != null && nota2 != null && nota3 != null && faltas != null) {
			if (faltas >= FALTAS) {
				estudante.setSituacao(Situacao.RF);
			}
			else if (media.compareTo(new BigDecimal(APROVACAO)) >= 0) {
				estudante.setSituacao(Situacao.AP);
			}
			else if (media.compareTo(new BigDecimal(REPROVACAO)) >= 0) {
				estudante.setSituacao(Situacao.FN);
			}
			else {
				estudante.setSituacao(Situacao.RP);
			}
		}
		else if (nota1 != null && nota2 != null && nota3 != null && faltas != null && ntFinal != null){
			BigDecimal finalAux1 = (media.multiply(new BigDecimal("60")));
			BigDecimal finalAux2 = (ntFinal.multiply(new BigDecimal("40")));
			BigDecimal finalAux = (finalAux1.add(finalAux2).divide(new BigDecimal("100")));

			if (finalAux.compareTo(new BigDecimal("5.0") )  >= 0 ){
				estudante.setSituacao(Situacao.AP);
			}
			else {
				estudante.setSituacao(Situacao.RP);
			}
		}
	}
}
