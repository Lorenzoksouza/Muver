package com.senac.ads.experts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.senac.ads.experts.model.Convidados;
import com.senac.ads.experts.services.ConvidadoService;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService service;
	
	@RequestMapping(method=RequestMethod.GET , value = "/")
	public String index() {
				
		return "index";
		
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidados> convidados = service.listaTodosConvidados();
		model.addAttribute("convidados",convidados);
		
		return "listaconvidados";
		
	}
	
	/**
	 * end-point responsável por receber a chamada 'salvar' da url e, aciona um método post
	 * ou seja, espera-se que sejam enviados parâmetros @requestparam.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {
		
		//insere no convidado os dados vindo do formulário
		Convidados novoConvidado =  new Convidados(nome, email, telefone);
		//chama a nossa camada de serviços que foi injetada acima, acionando o método salvar
		service.salvar(novoConvidado);
		
		//cria uma lista de convidados que será armazenada com os dados do nosso serviço que consultará 
		//todos os convidados na base.
		Iterable<Convidados> convidados = service.listaTodosConvidados();
		//insere no nosso model (formulário, os dados do convidado que vieram da consulta da lista)
		model.addAttribute("convidados",convidados);
		
		//chama a url lista convidados, para mostrar os convidados inseridos acima em tela;
		return "listaconvidados";
		
	}
		
}














