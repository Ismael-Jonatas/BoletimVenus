package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Usuario;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.UsuarioService;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class CadastrarUsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/cadastro-usuarios")
	public String getFromCadastro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "/cadastro/form-cadastroUsuario";
	}
	
	@PostMapping("/cadastro-usuarios/cadastrar")
	public ModelAndView adicionarUsuario(ModelAndView modelAndView, @Valid Usuario usuario, Errors errors, RedirectAttributes redirectAttts) {
		
		if(this.usuarioService.verificaEmailCadastrado(usuario) != true) {
			if (null != errors && errors.getErrorCount() > 0) {
				redirectAttts.addFlashAttribute("mensagem", errors.getAllErrors().get(0).getDefaultMessage());
				modelAndView.setViewName("redirect:/cadastro-usuarios");
			}else {
				this.usuarioService.inserirOuAtualizar(usuario);
				redirectAttts.addFlashAttribute("mensagem", "Usuario Cadastrado");
				modelAndView.setViewName("redirect:/login");
			}
		}else {
			redirectAttts.addFlashAttribute("mensagem", "Ops! - Email já Cadastrado!");
			modelAndView.setViewName("redirect:/cadastro-usuarios");
		}
		
		return modelAndView;
	}
	
	
}