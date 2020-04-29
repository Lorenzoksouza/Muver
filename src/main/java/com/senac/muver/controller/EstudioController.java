package com.senac.muver.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.senac.muver.model.Estudio;
import com.senac.muver.model.Musico;
import com.senac.muver.services.EstudioService;

@Controller
public class EstudioController {

	@Autowired
	private EstudioService service;
	
	@RequestMapping("listaestudios")
	public String listaEstudios(Model model) {
		Iterable<Estudio> estudios = service.listaTodosEstudios();
		model.addAttribute("estudios",estudios);
		
		return "listaestudios";
		
	}
	
	@RequestMapping("listaestudioid")
	public String estudioPorID(@RequestParam("id") Integer id, Model model) {
		Optional<Estudio> estudioAlterar = service.estudioPorID(id);
		
		return "index";
		
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("senha") String senha, @RequestParam("telefone") int telefone, @RequestParam("instrumentos") String[] instrumentos, @RequestParam("localização") String localização, 
			@RequestParam("disponibilidade") Date[] disponibilidade, Model model) {
		
		//insere no estudio os dados vindo do formulário
		Estudio novoEstudio =  new Estudio();
		//chama a nossa camada de serviços que foi injetada acima, acionando o método salvar
		service.salvar(novoEstudio);
		
		return "index";
		
	}
	
	@RequestMapping(value = "excluir")
	public String excluir(@RequestParam("estudio") Estudio estudio, Model model) {
		
		service.excluir(estudio);
		
		return "index";
		
	}
	
	@RequestMapping(value = "alterar")
	public String alterar(@RequestParam("estudio") Estudio estudio, Model model) {
		
		service.salvar(estudio);
		
		return "index";
		
	}
	
}
