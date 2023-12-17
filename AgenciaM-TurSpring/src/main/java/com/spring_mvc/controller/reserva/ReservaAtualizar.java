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
@RequestMapping("/reserva-editar")
public class ReservaAtualizar {

	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private DestinoRepository destinoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/numeroReserva={numeroReserva}/idDestino={id}")
	public ModelAndView reservaByNumeroReserva(@PathVariable Long numeroReserva, @PathVariable Long id) {
		ModelAndView model = new ModelAndView("views/reserva/atualizar.html");
		Reserva reserva = reservaRepository.getReferenceById(numeroReserva);
		model.addObject("reservas", reserva);
		Destino destino = destinoRepository.getReferenceById(id);
		model.addObject("destinos", destino);
		return model;
	}

	@PostMapping("/atualizar")
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

		if (reserva.getNumeroReserva() != null) {
			if (reservaRepository.findById(reserva.getNumeroReserva()) != null) {
				reservaRepository.save(reserva);
				System.out.println("Reserva atualizado com sucesso. Numero dda Reserva: " + reserva.getNumeroReserva());

			} else {
				System.out.println(
						"Tentativa de atualização de uma reserva que não existe no banco de dados. Numero dda Reserva: "
								+ reserva.getNumeroReserva());
			}
		} else {
			System.out.println("Tentativa de atualização de uma reserva com Numero da Reserva nula.");
		}

		return model;
	}

}
