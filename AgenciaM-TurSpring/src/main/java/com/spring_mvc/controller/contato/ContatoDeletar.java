package com.spring_mvc.controller.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Cliente;
import com.spring_mvc.model.Contato;
import com.spring_mvc.repository.ContatoRepository;

@Controller
@RequestMapping("/")
public class ContatoDeletar {

	@Autowired
	private ContatoRepository contatoRepository;

	@GetMapping("/contato-deletar/{id}")
	public ModelAndView deletar(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("redirect:/contato");

		Contato contato = contatoRepository.findById(id).orElse(null);
		if(contato != null){
			Cliente cliente = new Cliente();
			cliente.removerContato(contato);
			contatoRepository.delete(contato);
		}
		

		return model;
	}
}
