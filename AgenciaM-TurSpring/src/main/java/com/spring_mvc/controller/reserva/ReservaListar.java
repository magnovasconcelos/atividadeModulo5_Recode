package com.spring_mvc.controller.reserva;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Reserva;
import com.spring_mvc.repository.ReservaRepository;

@Controller
@RequestMapping("/reserva")
public class ReservaListar {

	@Autowired
	private ReservaRepository reservaRepository;

	@GetMapping
	public ModelAndView reserva() {
		ModelAndView model = new ModelAndView("views/reserva/index.html");
		List<Reserva> reservas = reservaRepository.findAll();
		model.addObject("reservas", reservas);
		return model;
	}
}
