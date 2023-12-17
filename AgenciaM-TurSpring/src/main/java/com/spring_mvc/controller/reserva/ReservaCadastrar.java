package com.spring_mvc.controller.reserva;

import java.time.LocalDate;

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
import com.spring_mvc.model.Destino;
import com.spring_mvc.model.Reserva;
import com.spring_mvc.repository.ClienteRepository;
import com.spring_mvc.repository.DestinoRepository;
import com.spring_mvc.repository.ReservaRepository;

@Controller
@RequestMapping("/reserva-cadastrar")
public class ReservaCadastrar {

	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private DestinoRepository destinoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/{id}")
	public ModelAndView cadastrar(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("views/reserva/cadastrar.html");
		model.addObject("reservas", new Reserva());
		model.addObject("destinos", destinoRepository.getReferenceById(id));
		return model;

	}

	@PostMapping("/salvar")
	public ModelAndView cadastrar(@ModelAttribute("reservas") Reserva reserva, @RequestParam("cpf") String cpfCliente,
			@RequestParam("id") Long idDestino, @RequestParam("formaPagamento") String formaPagamento,
			@RequestParam("data") LocalDate dataReserva) {
		ModelAndView model = new ModelAndView("redirect:/reserva");
		if (cpfCliente != null && !cpfCliente.isEmpty()) {
			Cliente cliente = clienteRepository.getReferenceById(cpfCliente);
			if (cliente != null) {
				reserva.setCliente(cliente);
			} else {
				System.out.println("Cliente não encontrado para o CPF: " + cpfCliente);
			}
		}
		if (idDestino != null) {
			Destino destino = destinoRepository.getReferenceById(idDestino);
			if (destino != null) {
				reserva.setDestino(destino);
			} else {
				System.out.println("Destino não encontrado para o ID: " + idDestino);
			}
		}
		if (formaPagamento != null && !formaPagamento.isEmpty()) {
			reserva.setFormaPagamento(formaPagamento);
		} else {
			System.out.println("Forma de pagamento não encontrada: " + formaPagamento);
		}
		if (dataReserva != null) {
			reserva.setDataReserva(dataReserva);
		} else {
			System.out.println("Data de reserva não encontrada: " + dataReserva);
		}
		System.out.println(reserva.getValorReserva());
		reservaRepository.save(reserva);

		return model;
	}
}
