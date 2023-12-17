package com.spring_mvc.controller.promocao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Cliente;
import com.spring_mvc.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteListar {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ModelAndView cliente() {
		ModelAndView model = new ModelAndView("views/cliente/index.html");
		List<Cliente> clientes = clienteRepository.findAll();		
		model.addObject("clientes", clientes);
		return model;
	}
}
