package com.spring_mvc.controller.promocao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Cliente;
import com.spring_mvc.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente-editar")
public class ClienteAtualizar {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/{cpf}")
	public ModelAndView clienteByCpf(@PathVariable String cpf) {
		ModelAndView model = new ModelAndView("views/cliente/atualizar.html");
		model.addObject("clientes", clienteRepository.getReferenceById(cpf));
		return model;
	}

	@PostMapping("/cliente-atualizar")
	public ModelAndView atualizar(@ModelAttribute ("clientes") Cliente cliente) {
		ModelAndView model = new ModelAndView("redirect:/cliente");
		model.addObject("clientes", clienteRepository.save(cliente));
		return model;
		
	}
}
