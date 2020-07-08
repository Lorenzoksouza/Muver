package com.senac.muver.controller;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.senac.muver.util.ConvertMasterTela;
import com.senac.muver.model.Estudio;
import com.senac.muver.model.Luthier;
import com.senac.muver.model.Master;
import com.senac.muver.model.Musico;
import com.senac.muver.services.EstudioService;
import com.senac.muver.services.LuthierService;
import com.senac.muver.services.MasterService;
import com.senac.muver.services.MusicoService;

@Controller
public class PerfilController {
	
	@Autowired
	private MasterService serviceMaster;
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
	
	
	 @PostMapping("/editar/{tipoUsuario}/{nome}")
	 public ModelAndView editarPerfil(@PathVariable String tipoUsuario, @PathVariable String nome, HttpServletRequest request, Model model) {
			ModelAndView mv = new ModelAndView("/editar");
			switch (tipoUsuario) {
				case "musico":{
					Musico m = serviceMusico.perfilPorNomeMusico(nome);
					mv.addObject("usuarios", convert.converteMusicoEmMasterTela(m));
					String[] instrumentos = {
							"Baixo", "Banjo", "Bateria", "Cavaquinho", "Clarinete", "Flauta", "Guitarra", "Piano", "Sanfona", "Saxofone", "Trombone", "Violão", "Violino", "Outros"
						};
						
						model.addAttribute("instrumentos", instrumentos);
						
						String[] estilo = {
								"Blues", "Bossa nova", "Forró", "Funk", "Hip-Hop", "Jazz", "Metal", "Pop", "Rock", "Outros" 	
							};
							
							model.addAttribute("estilo", estilo);
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
					String[] instrumentos = {
							"Baixo", "Banjo", "Bateria", "Cavaquinho", "Clarinete", "Flauta", "Guitarra", "Piano", "Sanfona", "Saxofone", "Trombone", "Violão", "Violino", "Outros"
						};
						
						model.addAttribute("instrumentos", instrumentos);
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

    
   @GetMapping(value = "/avaliar")
   public String alterarNota(@RequestParam("notaAtual") double notaAtual, @RequestParam("nota") String nota, 
		   @RequestParam("email") String email, @RequestParam("numeroAvaliacoes") int numeroAvaliacoes, 
		   @RequestParam("notaSoma") double notaSoma, HttpServletRequest request, Model model){  
	   
	   Master m = serviceMaster.procurarNota(email);
	   
	   int nAvaliacoes = m.getNumeroAvaliacoes() + 1;
	   
	   double notaDouble = Double.parseDouble(nota);
	   
	   double nSoma = m.getNotaSoma() + notaDouble;
	   
	   DecimalFormat df = new DecimalFormat("#.#");
	   
	   double calculoNota = nSoma / nAvaliacoes;
	   
	   double calcNota = Double.parseDouble(df.format(calculoNota).replace(",", "."));
	   
	   serviceMaster.alterarNota(calcNota, nAvaliacoes, nSoma, email);
	   return "redirect: /principal";
   } 
	


}
