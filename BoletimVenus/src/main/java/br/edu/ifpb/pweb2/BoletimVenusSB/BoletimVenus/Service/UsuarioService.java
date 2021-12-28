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
		usuario.setSenha(PasswordUtil.hashPassword(usuario.getSenha()));
		Usuario usuarioInserido = this.usuarioRepository.save(usuario);
		return usuarioInserido;
	}
	
	
	public void apagarUsuario(Integer id) {
		this.usuarioRepository.deleteById(id);
	}
	
	
	public Usuario verificaUsuarioLogado(Usuario usuario) {
		Usuario usuarioBD = this.usuarioRepository.findByEmail(usuario.getEmail());
		boolean valido = false;
		if (usuarioBD != null) {
			if (PasswordUtil.checkPass(usuario.getSenha(), usuarioBD.getSenha())) {
				valido = true;
			}
		}
		return valido ? usuarioBD : null;
	}

	public boolean verificaEmailCadastrado(Usuario usuario) {
		Usuario usuarioBD = this.usuarioRepository.findByEmail(usuario.getEmail());
		boolean emailCadastrado = false;
		if (usuarioBD != null) {
			emailCadastrado = true;
		}
		
		return emailCadastrado;
	}
	
	//coloca um adm conhecido no banco pela web
	public void populabanco() {
		Usuario usuario = new Usuario("admin","admin@administradores.com",PasswordUtil.hashPassword("123456"),true);
		this.usuarioRepository.save(usuario);
	}

	
}
