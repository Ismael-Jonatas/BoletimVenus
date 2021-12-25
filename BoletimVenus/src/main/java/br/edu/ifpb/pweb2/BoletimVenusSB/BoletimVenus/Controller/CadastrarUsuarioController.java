package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Usuario;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.UsuarioService;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class CadastrarUsuarioController {

	@Autowired
	private UsuarioService usuarioService ;
	
	@GetMapping("/cadastro-usuarios")
	public String getFromCadastro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "/cadastro/form-cadastroUsuario";
	}
	
	@PostMapping("/cadastro-usuarios/cadastrar")
	public String adicionarNotas(Model model, Usuario usuario) {
		this.usuarioService.inserirOuAtualizar(usuario);
		return "redirect:/home";
	}
	
	
	
	
}