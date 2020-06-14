package com.senac.muver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.muver.services.MasterService;

@Controller
public class PerfilController {
	

	@Autowired
	private MasterService service;
	
	@GetMapping("/perfil")
	public ModelAndView perfilNome(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/perfil");
		String id = request.getParameter("id");
		mv.addObject("usuario", service.perfilNome(id));
		return mv;
	}
	

}
