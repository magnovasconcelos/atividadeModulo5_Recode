package com.spring_mvc.controller.destino;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Destino;
import com.spring_mvc.repository.DestinoRepository;

@Controller
@RequestMapping("/destino")
public class DestinoListar {

	@Autowired
	private DestinoRepository destinoRepository;

	@GetMapping
	public ModelAndView contato() {
		ModelAndView model = new ModelAndView("views/destino/index.html");
		List<Destino> destinos = destinoRepository.findAll();
		model.addObject("destinos", destinos);
		return model;
	}

	@GetMapping("/imagem/{id}")
	@ResponseBody
	public ResponseEntity<byte[]> exibirImagen(@PathVariable("id") Long id) {
		Destino destino = destinoRepository.getReferenceById(id);
		if(destino != null && destino.getImagem() != null) {
			HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_PNG);
	        return new ResponseEntity<>(destino.getImagem(), headers, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
