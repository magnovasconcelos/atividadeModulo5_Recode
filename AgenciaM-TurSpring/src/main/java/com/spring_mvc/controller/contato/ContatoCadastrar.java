package com.spring_mvc.controller.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Cliente;
import com.spring_mvc.model.Contato;
import com.spring_mvc.repository.ClienteRepository;
import com.spring_mvc.repository.ContatoRepository;

@Controller
@RequestMapping("/contato-cadastrar")
public class ContatoCadastrar {

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ModelAndView cadastrar() {
		ModelAndView model = new ModelAndView("views/contato/cadastrar.html");
		model.addObject("contatos", new Contato());
		return model;

	}

	@PostMapping("/salvar")
	public ModelAndView cadastrar(@ModelAttribute("contatos") Contato contato, @RequestParam("cpf") String cpfCliente) {
		ModelAndView model = new ModelAndView("redirect:/contato");
		if (cpfCliente != null && !cpfCliente.isEmpty()) {
			Cliente cliente = clienteRepository.getReferenceById(cpfCliente);
			if (cliente != null) {
				contato.setCliente(cliente);
			} else {
				System.out.println("Cliente não encontrado para o CPF: " + cpfCliente);
			}
		}
		contatoRepository.save(contato);
		return model;
	}
}
