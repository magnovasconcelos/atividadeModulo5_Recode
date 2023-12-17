package com.spring_mvc.controller.promocao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Cliente;
import com.spring_mvc.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente-cadastrar")
public class ClienteCadastrar {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ModelAndView cadastrar() {
		ModelAndView model = new ModelAndView("views/cliente/cadastrar.html");
		model.addObject("clientes", new Cliente());
		return model;
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView cadastrar(@ModelAttribute ("clientes") Cliente cliente) {
		ModelAndView model = new ModelAndView("redirect:/cliente");
		clienteRepository.save(cliente);
		return model;
	}
}
