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
	private UsuarioService usuarioService ;
	
	@GetMapping("/cadastro-usuarios")
	public String getFromCadastro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "/cadastro/form-cadastroUsuario";
	}
	
	@PostMapping("/cadastro-usuarios/cadastrar")
	public ModelAndView adicionarNotas(ModelAndView modelAndView, @Valid Usuario usuario, Errors errors, RedirectAttributes redirectAttts) {
		if (null != errors && errors.getErrorCount() > 0) {
			redirectAttts.addFlashAttribute("mensagem", "Campo Invalidos!");
			modelAndView.setViewName("redirect:/cadastro-usuarios");
		}else {
			this.usuarioService.inserirOuAtualizar(usuario);
			modelAndView.setViewName("redirect:/login");
		}
		return modelAndView;
	}
	
}