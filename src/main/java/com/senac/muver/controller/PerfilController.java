package com.senac.muver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.senac.muver.util.ConvertMasterTela;
import com.senac.muver.model.Estudio;
import com.senac.muver.model.Luthier;
import com.senac.muver.model.Musico;
import com.senac.muver.services.EstudioService;
import com.senac.muver.services.LuthierService;
import com.senac.muver.services.MusicoService;

@Controller
public class PerfilController {

	@Autowired
	private MusicoService serviceMusico;
	@Autowired
	private EstudioService serviceEstudio;
	@Autowired
	private LuthierService serviceLuthier;
	
	private ConvertMasterTela convert = new ConvertMasterTela();
	
	@GetMapping("/perfil/{tipoUsuario}/{nome}")
	public ModelAndView perfilNome(@PathVariable String tipoUsuario, @PathVariable String nome, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/perfil");
		switch (tipoUsuario) {
			case "musico":{
				Musico m = serviceMusico.perfilPorNomeMusico(nome);
				mv.addObject("usuarios", convert.converteMusicoEmMasterTela(m));
				break;
			}
			case "estudio":{
				Estudio e = serviceEstudio.perfilPorNomeEstudio(nome);
				mv.addObject("usuarios", convert.converteEstudioEmMasterTela(e));
				break;
			}
			case "luthier":{
				Luthier l = serviceLuthier.perfilPorNomeLuthier(nome);
				mv.addObject("usuarios", convert.converteLuthierEmMasterTela(l));
				break;
			}
		}
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
