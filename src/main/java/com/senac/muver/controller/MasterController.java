package com.senac.muver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.muver.model.Master;
import com.senac.muver.model.Musico;
import com.senac.muver.services.MasterService;

@Controller
public class MasterController {
	
	@Autowired
	private MasterService service;
	
	@RequestMapping("/listaUsuarios")
	public ModelAndView listaUsuarios() {
		ModelAndView mv = new ModelAndView("principal");
		Iterable<Master> usuarios = service.listaTodosUsuarios();
		mv.addObject("usuarios",usuarios);
		
		return mv;
	}
	
	
}
