package com.senac.muver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.muver.services.MasterService;

@Controller
public class PerfilController {
	

	@Autowired
	private MasterService service;
	
	@GetMapping("/perfil")
	public ModelAndView perfilNome() {
		ModelAndView mv = new ModelAndView("/perfil"); 
		mv.addObject("usuario", service.perfilNome());
		return mv;
	}
	

}
