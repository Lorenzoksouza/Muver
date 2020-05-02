package com.senac.muver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senac.muver.model.Master;

@Controller
public class LoginController {

	@RequestMapping("loginForm")
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping("logar")
	public String logar(Master master, HttpSession session) {
		return null;
	}
}
