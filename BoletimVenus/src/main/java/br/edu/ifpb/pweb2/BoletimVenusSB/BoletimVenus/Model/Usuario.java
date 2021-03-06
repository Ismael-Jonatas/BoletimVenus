package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;

@Entity
@Table(name="tb_usuario",
		uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//permitir apenas string
	@Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$", message = "Apenas letras são permitidas no campo nome!")
	@NotBlank(message = "Campo nome é obrigatório!")
	private String nome;
	private boolean adminStatus;
	@Email(message = "O email não é valido!")
	@NotBlank(message = "Campo email é obrigatório")
	private String email;
	@NotBlank(message = "Campo senha é obrigatório")
	@Size(min=3, message = "Senha deve ter no mínimo 3 caracteres")
	private String senha;
	
	
	
	public Usuario() {
		
	}

	public Usuario(String nome, String email, String senha, boolean adminStatus) {
		
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



	public boolean isAdminStatus() {
		return adminStatus;
	}



	public void setAdminStatus(boolean adminStatus) {
		this.adminStatus = adminStatus;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
