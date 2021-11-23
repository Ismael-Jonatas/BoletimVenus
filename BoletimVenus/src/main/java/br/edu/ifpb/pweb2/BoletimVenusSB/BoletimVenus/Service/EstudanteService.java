package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Enum.Situacao;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Repository.EstudanteRepository;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Estudante;

@Service
public class EstudanteService {
	
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	
	public List<Estudante> getEstudantes(){
		return this.estudanteRepository.findAll();
	}
	
	
	public Estudante getEstudanteId(Long idEstudante) {
		return this.estudanteRepository.findById(idEstudante).orElse(null);
	}
	
	public Estudante inserirOuAtualizar(Estudante estudante) {
		Estudante estudanteInserido = estudanteRepository.save(estudante);
		return estudanteInserido;
	}
	
	public void apagarEstudante(Long idEstudante) {
		this.estudanteRepository.deleteById(idEstudante);
	}
	

	
	public void Calculando_media (Long id) {
		
		Estudante estudante = getEstudanteId(id);
		
		BigDecimal Nota1 = estudante.getNota1();
		BigDecimal Nota2 = estudante.getNota2();
		BigDecimal Nota3 = estudante.getNota3();
		BigDecimal Final = estudante.getNota3();
		Integer Faltas = estudante.getFaltas();
		Situacao situacao = null;
		
		BigDecimal Media;
		BigDecimal FinalAux;
		BigDecimal FinalAux1;
		BigDecimal FinalAux2;
		
		Media = (Nota1.add(Nota2).add(Nota3)).divide(new BigDecimal("3.0"), 2, RoundingMode.HALF_UP);
	
		FinalAux1 = (Media.multiply(new BigDecimal("6.0")));
		FinalAux2 = (Final.multiply(new BigDecimal("4.0")));
		FinalAux = (FinalAux1.add(FinalAux2).divide(new BigDecimal("10.0")));
		
		if(Nota1 == null || Nota2 == null || Nota3 == null || Faltas == null) {
			Situacao MT = situacao.MT;
			estudante.setSituacao(MT);
			this.inserirOuAtualizar(estudante);
		}		
		else if ((Media.compareTo(new BigDecimal("7.0")) >= 0 ) && Faltas < 25) {
			Situacao AP = situacao.AP;
			estudante.setSituacao(AP);
			this.inserirOuAtualizar(estudante);
		}
		else if ((Media.compareTo(new BigDecimal("7.0")) == -1 ) && (Media.compareTo(new BigDecimal("4.0")) >= 0 )  && Faltas < 25) {
			Situacao FN = situacao.FN;
			estudante.setSituacao(FN);
			this.inserirOuAtualizar(estudante);
		}
		
		else if (Faltas >= 25) {
			Situacao RF = situacao.RF;
			estudante.setSituacao(RF);
			this.inserirOuAtualizar(estudante);
		}
		
		else if (FinalAux.compareTo(new BigDecimal("5.0") )  >= 0 )  {
			Situacao AP = situacao.AP;
			estudante.setSituacao(AP);
			this.inserirOuAtualizar(estudante);
			
		}
		
		else {
			
			Situacao RP = situacao.RP;
			estudante.setSituacao(RP);
			this.inserirOuAtualizar(estudante);
			
		}
		
	}
}
