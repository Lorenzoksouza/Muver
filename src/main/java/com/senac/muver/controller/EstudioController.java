package com.senac.muver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senac.muver.model.Estudio;
import com.senac.muver.services.EstudioService;

@Controller
public class EstudioController {

	@Autowired
	private EstudioService service;
	
	@RequestMapping("listaestudios")
	public String listaEstudios(Model model) {
		Iterable<Estudio> estudios = service.listaTodosEstudios();
		model.addAttribute("estudios",estudios);
		
		return "listaestudios";
		
	}
}
