package com.spring_mvc.controller.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Cliente;
import com.spring_mvc.model.Contato;
import com.spring_mvc.repository.ClienteRepository;
import com.spring_mvc.repository.ContatoRepository;

@Controller
@RequestMapping("/contato-editar")
public class ContatoAtualizar {

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/{id}")
	public ModelAndView contatoById(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("views/contato/atualizar.html");
		Contato contato = contatoRepository.findById(id).orElse(null);
		model.addObject("contatos", contato);
		return model;
	}

	@PostMapping("/contato-atualizar")
	public ModelAndView cadastrar(@ModelAttribute("contatos") Contato contato, @RequestParam("cpf") String cpfCliente, @RequestParam("id") Long idContato) {
		ModelAndView model = new ModelAndView("redirect:/contato");
		contato.setIdContato(idContato);
		if (cpfCliente != null && !cpfCliente.isEmpty()) {
			Cliente cliente = clienteRepository.getReferenceById(cpfCliente);
			if (cliente != null) {
				contato.setCliente(cliente);
			} else {
				System.out.println("Cliente não encontrado para o CPF: " + cpfCliente);
			}
		}
		if (contato.getIdContato() != null) {
			if (contatoRepository.existsById(contato.getIdContato())) {
				contatoRepository.save(contato);
				System.out.println("Contato atualizado com sucesso. ID: " + contato.getIdContato());
			} else {
				System.out.println("Tentativa de atualização de um contato que não existe no banco de dados. ID: "
						+ contato.getIdContato());
			}
		} else {
			System.out.println("Tentativa de atualização de um contato com ID nulo.");
		}

		return model;
	}
}
