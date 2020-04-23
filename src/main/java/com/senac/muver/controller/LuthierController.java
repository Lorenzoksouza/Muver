package com.senac.muver.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.senac.muver.model.Luthier;
import com.senac.muver.model.Musico;
import com.senac.muver.services.LuthierService;

@Controller
public class LuthierController {

	@Autowired
	private LuthierService service;
	
	@RequestMapping("listaluthier")
	public String listaLuthier(Model model) {
		Iterable<Luthier> luthier = service.listaTodosLuthier();
		model.addAttribute("luthier",luthier);
		
		return "listaluthier";
		
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("senha") String senha, @RequestParam("contato") String contato, @RequestParam("click") 
			String click, @RequestParam("instrumentos") String[] instrumentos, @RequestParam("localização") String localização, 
			@RequestParam("disponibilidade") Date[] disponibilidade, Model model) {
		
		//insere no Luthier os dados vindo do formulário
		Luthier novoLuthier =  new Luthier();
		//chama a nossa camada de serviços que foi injetada acima, acionando o método salvar
		service.salvar(novoLuthier);
		
		return "index";
		
	}
	
}
