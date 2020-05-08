package com.senac.muver.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping("/pesquisaUserLogin")
	public ModelAndView pesquisaUserLogin(@RequestParam("nome") String nome,@RequestParam("descricao") String descricao, HttpSession session) {
		ModelAndView mv = new ModelAndView("principal");
		Master usuarios = service.listarUsuario(nome, descricao);
		mv.addObject("usuarios",usuarios);
		return mv;
	}
	
	
}
