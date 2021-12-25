package br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Model.Usuario;
import br.edu.ifpb.pweb2.BoletimVenusSB.BoletimVenus.Service.UsuarioService;


@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getFromLogin(ModelAndView modelAndView) {
		//this.usuarioService.populabanco();
		modelAndView.setViewName("/login/form-login");
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView validaLogin(Usuario usuario, ModelAndView modelAndView, HttpSession session, RedirectAttributes redirectAttts) {
		
		if((usuario = this.usuarioService.verificaUsuarioLogado(usuario)) != null) {
			session.setAttribute("usuario", usuario);
			modelAndView.setViewName("redirect:/home");
		}else {
			redirectAttts.addFlashAttribute("mensagem", "Login e/ou senha inválidos!");
			modelAndView.setViewName("redirect:/login");
		}
		
		return modelAndView;
		
	}
	
	
	@RequestMapping("/out")
	public ModelAndView logout(ModelAndView mav, HttpSession session) {
		session.invalidate();
		mav.setViewName("redirect:/home");
		return mav;
	}


	
}
