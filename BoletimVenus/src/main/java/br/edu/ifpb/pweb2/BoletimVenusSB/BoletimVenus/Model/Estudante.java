package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Enum.Situacao;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="tb_estudante")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estudante {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message="O campo nome é obrigatório!")
	private String nome;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@PastOrPresent(message="A data não pode ser futura!")
	private Date dataNascimento;
	private Integer faltas;
	private Situacao situacao;
	private BigDecimal nota1;
	private BigDecimal nota2;
	private BigDecimal nota3;
	private BigDecimal ntFinal;
	
	public Estudante() {
		
	}

	public Estudante (String nome, Date dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getNota1() {
		return nota1;
	}

	public void setNota1(BigDecimal nota1) {
		this.nota1 = nota1;
	}

	public BigDecimal getNota2() {
		return nota2;
	}

	public void setNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	public BigDecimal getNota3() {
		return nota3;
	}

	public void setNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}

	public BigDecimal getNotaFinal() {
		return ntFinal;
	}

	public void setNotaFinal(BigDecimal ntFinal) {
		this.ntFinal = ntFinal;
	}

	public BigDecimal getMedia() {
		BigDecimal nota1 = this.nota1;
		BigDecimal nota2 = this.nota2;
		BigDecimal nota3 = this.nota3;
		BigDecimal media;

		if (nota1 == null || nota2 == null || nota3 == null) return null;

		media = (nota1.add(nota2).add(nota3)).divide(new BigDecimal("3.0"), 2, RoundingMode.HALF_UP);

		return media;
	}

}
