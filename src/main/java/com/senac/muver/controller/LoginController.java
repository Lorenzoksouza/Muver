package com.senac.muver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.senac.muver.model.Master;
import com.senac.muver.services.MasterService;

@Controller
public class LoginController {
	
	@Autowired
	private MasterService service;
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public String cadastro(){
		return "/cadastrar";
	}
	
	@RequestMapping(value="/cMusico", method=RequestMethod.GET)
	public String cMusico(){
		return "/cMusico";
	}
	
	
	/*
	@RequestMapping(value="/cLuthier", method=RequestMethod.GET)
	public String cLuthier(){
		return "/cLuthier";
	}
	*/
	@RequestMapping(value="/cEstudio", method=RequestMethod.GET)
	public String cEstudio(){
		return "/cEstudio";
	}
	
	@RequestMapping("/login")
	public String loginForm() {
		return "/login";
	}
	
	@RequestMapping("/principal")
	public String principal() {
		return "/principal";
	}
	
	@RequestMapping(value = "/logar", method = RequestMethod.POST)
	public String logar(@RequestParam("email") String email, @RequestParam("senha") String senha, HttpSession session, Model model) {
		/*
		Master master = service.existeUsuario(email,senha);
		if(master.equals(null)) {
			//TODO tem q retornar para tela de login indicando erro
			return "/";
		}else {
			System.out.println(master);
			return "/principal";
		}
		*/
		System.out.println("logar pra principal");
		return "redirect:principal";
	}
	
	
}
