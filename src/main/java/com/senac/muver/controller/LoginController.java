package com.senac.muver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.senac.muver.model.Master;
import com.senac.muver.services.MasterService;

@Controller
public class LoginController {
	
	@Autowired
	private MasterService service;

	@RequestMapping("loginForm")
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "logar", method = RequestMethod.POST)
	public String logar(@RequestParam("email") String email, @RequestParam("senha") String senha, HttpSession session) {
		
		Master master = service.existeUsuario(email,senha);
		System.out.println(master);
		return null;
	}
}
