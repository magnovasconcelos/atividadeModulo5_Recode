package com.spring_mvc.controller.cliente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/promocoes")
public class PromocoesListar {
	
	@GetMapping
	public ModelAndView promocoes() {
		ModelAndView model = new ModelAndView("views/promocoes/index.html");		
		return model;
	}
}
