package com.spring_mvc.controller.contato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Contato;
import com.spring_mvc.repository.ContatoRepository;

@Controller
@RequestMapping("/contato")
public class ContatoListar {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@GetMapping
	public ModelAndView contato() {
		ModelAndView model = new ModelAndView("views/contato/index.html");
		List<Contato> contatos = contatoRepository.findAll();		
		model.addObject("contatos", contatos);
		return model;
	}
}
