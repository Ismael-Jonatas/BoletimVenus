package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Usuario;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.EstudanteService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import javax.validation.Valid;

@Controller
public class EditarController {

	@Autowired
	private EstudanteService estudanteservice;

	@GetMapping("/editar")
	public ModelAndView getListAlunosNotas() {
		ModelAndView editView = new ModelAndView("/editar/form-editar");
		List<Estudante> estudantes = this.estudanteservice.getEstudantes();
		editView.addObject("estudante", new Estudante());
		editView.addObject("estudantes", estudantes);
		return editView;
	}

	@PostMapping("/editar")
	public ModelAndView postFromEditar(ModelAndView modelAndView, @Valid Estudante estudante, Errors errors, RedirectAttributes redirectAttts) {
		if (estudante.getId() != null) {
			Estudante estudanteEdidato = this.estudanteservice.getEstudanteId(estudante.getId());
			
			setAtributesEstudantes(estudante, estudanteEdidato);
			if (null != errors && errors.getErrorCount() > 0) {
				redirectAttts.addFlashAttribute("mensagem", errors.getAllErrors().get(0).getDefaultMessage());
				modelAndView.setViewName("redirect:/editar");
			}else {
				this.estudanteservice.inserirOuAtualizar(estudante);
				modelAndView.setViewName("redirect:/relatorio");
			}
			
			return modelAndView;
		}else {
			redirectAttts.addFlashAttribute("mensagem", "Selecione um Aluno!");
		}


		return modelAndView;
}

	public void setAtributesEstudantes(Estudante estudante, Estudante estudanteEdidato) {
		estudante.setFaltas(estudanteEdidato.getFaltas());
		estudante.setSituacao(estudanteEdidato.getSituacao());
		estudante.setNota1(estudanteEdidato.getNota1());
		estudante.setNota2(estudanteEdidato.getNota2());
		estudante.setNota3(estudanteEdidato.getNota3());
		estudante.setNotaFinal(estudanteEdidato.getNotaFinal());
	}
}

