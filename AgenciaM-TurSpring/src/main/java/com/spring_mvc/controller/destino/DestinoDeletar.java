package com.spring_mvc.controller.destino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Destino;
import com.spring_mvc.repository.DestinoRepository;

@Controller
@RequestMapping("/")
public class DestinoDeletar {

	@Autowired
	private DestinoRepository destinoRepository;

	@GetMapping("/destino-deletar/{id}")
	public ModelAndView deletar(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("redirect:/destino");

		Destino destino = destinoRepository.findById(id).orElse(null);
		if(destino != null){
			destinoRepository.delete(destino);
		}
		

		return model;
	}
}
