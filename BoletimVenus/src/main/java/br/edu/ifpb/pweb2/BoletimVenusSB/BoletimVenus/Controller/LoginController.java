package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Usuario;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.UsuarioService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping
	public String getFromLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "/login/form-login";
	}
	
	@RequestMapping(method= {RequestMethod.POST})
	public String validaLogin(Usuario usuario, Model model) {
		String proxPagina = null;
		if(this.usuarioService.verificaUsuarioLogado(usuario.getLogin(), usuario.getSenha())) {
			model.addAttribute("usuario", usuario.getLogin());
			proxPagina = "/index";
		}else {
			model.addAttribute("mensagem", "Login e/ou Senha inválidos");
			model.addAttribute("usuario", usuario);
			proxPagina = "/login/from-login";
		}
		
		return proxPagina;
		
	}
	

	@RequestMapping("out")
	public String logout() {
		System.out.println("Fez logout...");
		return "index";
	}
	
	
}
