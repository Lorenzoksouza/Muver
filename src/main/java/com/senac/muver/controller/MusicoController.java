package com.senac.muver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senac.muver.model.Estudio;
import com.senac.muver.model.Musico;
import com.senac.muver.services.MusicoService;

@Controller
public class MusicoController {

	@Autowired
	private MusicoService service;
	
	@RequestMapping("listamusicos")
	public String listaMusicos(Model model) {
		Iterable<Musico> musicos = service.listaTodosMusicos();
		model.addAttribute("musicos",musicos);
		
		return "listamusicos";
		
	}
	
}
