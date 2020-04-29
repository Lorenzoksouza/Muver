package com.senac.muver.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.senac.muver.model.Luthier;
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
	
	@RequestMapping("listaluthierid")
	public String luthierPorID(@RequestParam("id") Integer id, Model model) {
		Optional<Luthier> luthierAlterar = service.luthierPorID(id);
		
		return "index";
		
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
	
	@RequestMapping(value = "excluir")
	public String excluir(@RequestParam("luthier") Luthier luthier, Model model) {
		
		service.excluir(luthier);
		
		return "index";
		
	}
	
	@RequestMapping(value = "alterar")
	public String alterar(@RequestParam("luthier") Luthier luthier, Model model) {
		
		service.alterar(luthier);
		
		return "index";
		
	}
}
