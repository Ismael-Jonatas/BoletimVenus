package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.EstudanteService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
	public String postFromEditar(@ModelAttribute Estudante estudante) {
		Estudante estudanteEdidato = this.estudanteservice.getEstudanteId(estudante.getId());
		setAtributesEstudantes(estudante, estudanteEdidato);
		this.estudanteservice.inserirOuAtualizar(estudante);
		return "redirect:/relatorio";
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
