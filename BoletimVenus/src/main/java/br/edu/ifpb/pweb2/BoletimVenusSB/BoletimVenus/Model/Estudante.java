package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Enum.Situacao;
import lombok.EqualsAndHashCode;


@Entity
@Table(name="tb-estudante")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estudante {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome; 
	private Date datanascimento;
	private Integer Faltas;
	private Situacao situacao;
	private BigDecimal Nota1;
	private BigDecimal Nota2;
	private BigDecimal Nota3;
	private BigDecimal Final;
	
	public Estudante() {
		
	}
	

	public Estudante (String nome, Date datanascimento) {
		this.nome = nome;
		this.datanascimento = datanascimento;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Integer getFaltas() {
		return Faltas;
	}

	public void setFaltas(Integer faltas) {
		Faltas = faltas;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getNota1() {
		return Nota1;
	}

	public void setNota1(BigDecimal nota1) {
		Nota1 = nota1;
	}

	public BigDecimal getNota2() {
		return Nota2;
	}

	public void setNota2(BigDecimal nota2) {
		Nota2 = nota2;
	}

	public BigDecimal getNota3() {
		return Nota3;
	}

	public void setNota3(BigDecimal nota3) {
		Nota3 = nota3;
	}

	public BigDecimal getFinal() {
		return Final;
	}

	public void setFinal(BigDecimal final1) {
		Final = final1;
	}

	
}
