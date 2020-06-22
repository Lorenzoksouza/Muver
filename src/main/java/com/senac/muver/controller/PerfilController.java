package com.senac.muver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.senac.muver.model.Master;
import com.senac.muver.model.Musico;
import com.senac.muver.services.MasterService;

@Controller
public class PerfilController {
	

	@Autowired
	private MasterService service;

	
	@GetMapping("/perfil/{nome}")
	public ModelAndView perfilNome(@PathVariable String nome, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/perfil");
		mv.addObject("usuarios", service.perfilNome(nome));
		return mv;
	 }
	
    
    @RequestMapping("/facebook.com/{linkFb}")
    public RedirectView faceRedirect(@PathVariable String linkFb) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://facebook.com.br/" + linkFb);
        return redirectView;
    }
    
    @RequestMapping("/instagram.com/{linkIg}")
    public RedirectView instaRedirect(@PathVariable String linkIg) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://instagram.com.br/" + linkIg);
        return redirectView;
    }
	
}
