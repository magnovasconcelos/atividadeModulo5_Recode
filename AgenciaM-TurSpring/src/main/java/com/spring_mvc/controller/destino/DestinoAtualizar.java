package com.spring_mvc.controller.destino;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.model.Destino;
import com.spring_mvc.repository.DestinoRepository;

@Controller
@RequestMapping("/destino-editar")
public class DestinoAtualizar {

	@Autowired
	private DestinoRepository destinoRepository;

	@GetMapping("/{id}")
	public ModelAndView destinoById(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("views/destino/atualizar.html");
		model.addObject("destinos", destinoRepository.getReferenceById(id));
		return model;
	}

	@PostMapping("/destino-atualizar")
	public ModelAndView atualizar(@ModelAttribute("destinos") Destino destino,
			@RequestParam("img") MultipartFile imagemFile, @RequestParam("id") Long idDestino) throws IOException {

		ModelAndView model = new ModelAndView("redirect:/destino");
		destino.setId(idDestino);

		if (!imagemFile.isEmpty()) {
			byte[] bytesDaImagem = imagemFile.getBytes();
			destino.setImagem(bytesDaImagem);
		} else {
			System.out.println("Imagem não localizada");
		}

		if (destino.getId() != null) {
			if (destinoRepository.existsById(destino.getId())) {
				destinoRepository.save(destino);
				System.out.println("Destino atualizado com sucesso. ID: " + destino.getId());

			} else {
				System.out.println("Tentativa de atualização de um destino que não existe no banco de dados. ID: "
						+ destino.getId());
			}
		} else {
			System.out.println("Tentativa de atualização de um destino com ID nulo.");
		}

		return model;
	}
}
