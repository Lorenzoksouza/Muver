package com.senac.muver.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.senac.muver.util.ConvertMasterTela;
import com.senac.muver.model.Estudio;
import com.senac.muver.model.Luthier;
import com.senac.muver.model.Master;
import com.senac.muver.model.MasterTela;
import com.senac.muver.model.Musico;
import com.senac.muver.services.MasterService;

@Controller
public class MasterController {
	
	@Autowired
	private MasterService service;
	private ConvertMasterTela convert = new ConvertMasterTela();
	
	@RequestMapping("/principal")
	public ModelAndView listaUsuariosLogin() {
		
		ModelAndView mv = new ModelAndView("/principal"); 
		ArrayList<Master> listaUsuarios = service.listaUsuariosSemMusico();
		ArrayList<MasterTela> listaMt = new ArrayList<MasterTela>();
		for (Master l : listaUsuarios) {
			MasterTela mt = convert.converteMasterEmMasterTela(l);
			listaMt.add(mt);
		}
		mv.addObject("usuarios", listaMt);
		
		return mv;
	}
	
	@PostMapping("/principal")
	public ModelAndView listaUsuarios() {
		
		ModelAndView mv = new ModelAndView("/principal"); 
		ArrayList<Master> listaUsuarios = service.listaUsuariosSemMusico();
		ArrayList<MasterTela> listaMt = new ArrayList<MasterTela>();
		for (Master l : listaUsuarios) {
			MasterTela mt = convert.converteMasterEmMasterTela(l);
			listaMt.add(mt);
		}
		mv.addObject("usuarios", listaMt);
		
		return mv;
	}
	
	
	@PostMapping("/Estudios")
	public ModelAndView listaEstudios() {
		
		ModelAndView mv = new ModelAndView("/principal"); 
		ArrayList<Master> listaUsuarios = service.listaUsuariosEstudios();
		ArrayList<MasterTela> listaMt = new ArrayList<MasterTela>();
		for (Master l : listaUsuarios) {
			MasterTela mt = convert.converteMasterEmMasterTela(l);
			listaMt.add(mt);
		}
		mv.addObject("usuarios", listaMt);
		
		return mv;
	}
	
	@PostMapping("/Luthiers")
	public ModelAndView listaLuthiers() {
		
		ModelAndView mv = new ModelAndView("/principal"); 
		ArrayList<Master> listaUsuarios = service.listaUsuariosLuthiers();
		ArrayList<MasterTela> listaMt = new ArrayList<MasterTela>();
		for (Master l : listaUsuarios) {
			MasterTela mt = convert.converteMasterEmMasterTela(l);
			listaMt.add(mt);
		}
		mv.addObject("usuarios", listaMt);
		
		return mv;
	}
	
	@RequestMapping("/pesquisa")
	public ModelAndView perfilNome( @RequestParam(required = false) String pesquisa, @RequestParam(required = false) String tipo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/principal");
		
		if (tipo == "tipoEstudio") {
			ArrayList<Master> usuarios = service.pesquisaTipoEstudio(pesquisa);
			ArrayList<MasterTela> listaMt = new ArrayList<MasterTela>();
			for (Master l : usuarios) {
				MasterTela mt = convert.converteMasterEmMasterTela(l);
				listaMt.add(mt);
			}
			mv.addObject("usuarios", listaMt);
			
		} else {
			ArrayList<Master> usuarios = service.pesquisaNome(pesquisa);
			ArrayList<MasterTela> listaMt = new ArrayList<MasterTela>();
			for (Master l : usuarios) {
				MasterTela mt = convert.converteMasterEmMasterTela(l);
				listaMt.add(mt);
			}
			mv.addObject("usuarios", listaMt);
		}
		
		return mv;
	 }
	
}
