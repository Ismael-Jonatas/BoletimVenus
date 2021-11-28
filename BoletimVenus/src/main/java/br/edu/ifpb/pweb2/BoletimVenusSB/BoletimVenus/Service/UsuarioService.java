package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Usuario;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario UsuarioId(Integer id) {
		return this.usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario inserirOuAtualizar(Usuario usuario) {
		Usuario usuarioInserido = this.usuarioRepository.save(usuario);
		return usuarioInserido;
	}
	
	
	public void apagarUsuario(Integer id) {
		this.usuarioRepository.deleteById(id);
	}
	
	
	public Boolean verificaUsuarioLogado(String login, String senha) {
		return this.usuarioRepository.existsByLoginAndSenha(login, senha);
	}
	
}
