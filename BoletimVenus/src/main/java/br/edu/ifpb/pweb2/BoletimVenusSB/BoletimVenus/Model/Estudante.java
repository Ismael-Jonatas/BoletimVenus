package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estudante {

	String nome; 
	Date datanascimento = new Date();
	Integer Faltas;
	Situacao situacao;
	BigDecimal Nota1;
	BigDecimal Nota2;
	BigDecimal Nota3;
	BigDecimal Final;
	
	public Estudante (String nome, Date datanascimento) {
		
		this.nome = nome;
		this.datanascimento = datanascimento;
		
	}
	

	public void Calculando_media (BigDecimal Nota1, BigDecimal Nota2, BigDecimal Nota3, BigDecimal Final, Integer Faltas) {
		
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
		}		
		else if ((Media.compareTo(new BigDecimal("7.0")) >= 0 ) && Faltas < 25) {
			Situacao AP = situacao.AP;
		}
		else if ((Media.compareTo(new BigDecimal("7.0")) == -1 ) && (Media.compareTo(new BigDecimal("4.0")) >= 0 )  && Faltas < 25) {
			Situacao FN = situacao.FN;
		}
		
		else if (Faltas >= 25) {
			Situacao RF = situacao.RF;
		}
		
		else if (FinalAux.compareTo(new BigDecimal("5.0") )  >= 0 )  {
			Situacao AP = situacao.AP;
			
		}
		
		else {
			
			Situacao RP = situacao.RP;
			
		}
		
	}
	
}
