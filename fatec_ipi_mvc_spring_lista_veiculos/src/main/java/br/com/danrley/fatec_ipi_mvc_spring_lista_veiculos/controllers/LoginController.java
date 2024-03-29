package br.com.danrley.fatec_ipi_mvc_spring_lista_veiculos.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.danrley.fatec_ipi_mvc_spring_lista_veiculos.model.beans.Usuario;
import br.com.danrley.fatec_ipi_mvc_spring_lista_veiculos.services.LoginService;

@Controller

public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping (value = {"/login", "/"})
	public ModelAndView login () {
		ModelAndView mv = new ModelAndView ("login");
		mv.addObject(new Usuario());
		return mv;
	}
	
	@PostMapping ("/fazerLogin")
	public String fazerLogin (HttpServletRequest request,
	Usuario usuario) {
	if (loginService.logar(usuario)) {

		request.getSession().setAttribute("usuarioLogado",
				usuario);
		return "redirect:veiculos";
	 }
	 else{
			
		 return "login";
	 }
}
}
