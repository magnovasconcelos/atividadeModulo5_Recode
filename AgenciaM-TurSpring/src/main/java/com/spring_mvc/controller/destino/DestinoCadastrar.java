package com.spring_mvc.controller.destino;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Destino;
import com.spring_mvc.repository.DestinoRepository;

@Controller
@RequestMapping("/destino-cadastrar")
public class DestinoCadastrar {

	@Autowired
	private DestinoRepository destinoRepository;

	@GetMapping
	public ModelAndView cadastrar() {
		ModelAndView model = new ModelAndView("views/destino/cadastrar.html");

		model.addObject("destinos", new Destino());

		return model;
	}

	@PostMapping("/salvar")
	public ModelAndView cadastrar(@ModelAttribute ("destinos") Destino destino, @RequestParam("img") MultipartFile imagemFile) throws IOException {

		try {
			if (!imagemFile.isEmpty()) {
                byte[] bytesDaImagem = imagemFile.getBytes();
                destino.setImagem(bytesDaImagem);
            }
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView model = new ModelAndView("redirect:/destino");

		destinoRepository.save(destino);

		return model;
	}

}
