package com.senac.muver.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.senac.muver.model.Estudio;
import com.senac.muver.model.Musico;
import com.senac.muver.services.MusicoService;

@Controller
public class MusicoController {

	@Autowired
	private MusicoService service;
	
	@RequestMapping("listamusicos")
	public String listaMusicos(Model model) {
		Iterable<Musico> musicos = service.listaTodosMusicos();
		model.addAttribute("musicos",musicos);
		
		return "listamusicos";
		
	}
	
	@RequestMapping("listamusicoid")
	public String musicoPorID(@RequestParam("id") Integer id, Model model) {
		Optional<Musico> musicoAlterar = service.musicoPorID(id);
		
		return "index";
		
	}
	
	@RequestMapping(value = "cadastrarMusico", method = RequestMethod.POST)
	public String salvar(
			@RequestParam("nome") String nome, 
			@RequestParam("email") String email,
			@RequestParam("senha") String senha, 
			@RequestParam("estilo") String estiloMusical, 
			@RequestParam("instrumentos") String instrumentos, 
			@RequestParam("fotoPerfil") byte[] fotoPerfil, 
			@RequestParam("linkFb") String linkFb, 
			@RequestParam("linkIg") String linkIg,
			@RequestParam("descricao") String descricao, Model model) {
		
		//insere no musico os dados vindo do formulário
		Musico novoMusico =  new Musico(nome,email,senha,estiloMusical,instrumentos,fotoPerfil,linkFb,linkIg,descricao);
		//chama a nossa camada de serviços que foi injetada acima, acionando o método salvar
		service.salvar(novoMusico);
		
		return "login";
		
	}
	
	@RequestMapping(value = "excluir")
	public String excluir(@RequestParam("musico") Musico musico, Model model) {
		
		service.excluir(musico);
		
		return "index";
		
	}
	
	@RequestMapping(value = "alterar")
	public String alterar(@RequestParam("musico") Musico musico, Model model) {
		
		service.salvar(musico);		
		
		//alterar pagina de returno para pagina com os dados para alteração(pagina de cadastro? ou outra pagina para alteração)
		return "index";
		
	}
	
}
