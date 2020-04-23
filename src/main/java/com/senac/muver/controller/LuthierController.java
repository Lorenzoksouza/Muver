package com.senac.muver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senac.muver.model.Luthier;
import com.senac.muver.services.LuthierService;

@Controller
public class LuthierController {

	@Autowired
	private LuthierService service;
	
	@RequestMapping("listaluthier")
	public String listaLuthier(Model model) {
		Iterable<Luthier> luthier = service.listaTodosLuthier();
		model.addAttribute("luthier",luthier);
		
		return "listaluthier";
		
	}
	
}
