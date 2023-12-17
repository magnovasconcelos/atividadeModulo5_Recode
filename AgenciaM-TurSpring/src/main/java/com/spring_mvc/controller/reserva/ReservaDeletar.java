package com.spring_mvc.controller.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Cliente;
import com.spring_mvc.model.Destino;
import com.spring_mvc.model.Reserva;
import com.spring_mvc.repository.ReservaRepository;

@Controller
@RequestMapping("/")
public class ReservaDeletar {

	@Autowired
	private ReservaRepository reservaRepository;

	@GetMapping("/reserva-deletar/{numeroReserva}")
	public ModelAndView deletar(@PathVariable Long numeroReserva) {
		ModelAndView model = new ModelAndView("redirect:/reserva");

		Reserva reserva = reservaRepository.findById(numeroReserva).orElse(null);
		if(reserva != null){
			Cliente cliente = new Cliente();
			cliente.removerReserva(reserva);
			reserva.setCliente(cliente);
			Destino destino = new Destino();
			destino.removerReserva(reserva);
			reserva.setDestino(destino);
			reservaRepository.delete(reserva);
		}
		

		return model;
	}
}
