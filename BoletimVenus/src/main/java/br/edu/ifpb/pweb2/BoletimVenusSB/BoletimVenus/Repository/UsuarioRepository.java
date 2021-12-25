package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByEmail(String email);
	
}
