package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Repository.EstudanteRepository;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;

@Service
public class EstudanteService {
	
	@Autowired
	private EstudanteRepository estudanteRepository;

	public List<Estudante> getEstudantes(){
		return this.estudanteRepository.findAll();
	}

	public Estudante getEstudanteId(Integer idEstudante) {
		return this.estudanteRepository.findById(idEstudante).orElse(null);
	}
	
	public Estudante inserirOuAtualizar(Estudante estudante) {
		Estudante estudanteInserido = estudanteRepository.save(estudante);
		return estudanteInserido;
	}
	
	public void apagarEstudante(Integer idEstudante) {
		this.estudanteRepository.deleteById(idEstudante);
	}
}
