package com.senac.muver.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.senac.muver.model.Master;
import com.senac.muver.model.Musico;
import com.senac.muver.services.MasterService;

@Controller
public class MasterController {
	
	@Autowired
	private MasterService service;
	
	@GetMapping("/principal")
	public ModelAndView listaUsuarios() {
		System.out.println("veio aqui");
		ModelAndView mv = new ModelAndView("/principal"); 
		mv.addObject("usuarios", service.listaUsuariosSemMusico());
		return mv;
	}
	
	
}
