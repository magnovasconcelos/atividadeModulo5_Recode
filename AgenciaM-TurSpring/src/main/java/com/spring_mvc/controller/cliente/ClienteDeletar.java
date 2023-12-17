package com.spring_mvc.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.repository.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteDeletar {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/cliente-deletar/{cpf}")
	public ModelAndView deletar(@PathVariable String cpf) {
		ModelAndView model = new ModelAndView("redirect:/cliente");

		clienteRepository.deleteById(cpf);

		return model;
	}
}
