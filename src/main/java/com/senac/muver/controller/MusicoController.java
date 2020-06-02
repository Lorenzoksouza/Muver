package com.senac.muver.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.senac.muver.model.Musico;
import com.senac.muver.services.MusicoService;

@Controller
public class MusicoController {

	@Autowired
	private MusicoService service;
	
	
	//teste de metodo para realizar a listagem dem musicos
	/*@RequestMapping("/listaMusicosPrincipal")
	public ModelAndView listaUsuarios() {
		ModelAndView mv = new ModelAndView("principal");
		Iterable<Musico> usuarios = service.listaTodosMusicos();
		mv.addObject("usuarios",usuarios);
		
		return mv;
	} */
	
	
	//metodo pra talvez pegar o perfil o usuario TESTE
	@RequestMapping(value = "/perfilMusico", method = RequestMethod.GET)
	public ModelAndView perfilUsuarios() {
		ModelAndView mv = new ModelAndView("perfil");
		Iterable<Musico> usuarios = service.listaTodosMusicos();
		mv.addObject("usuarios",usuarios);
		
		return mv;
	}

	
	@RequestMapping("/listamusicos")
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
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("senha") String senha, @RequestParam("estilo") String estiloMusical, 
		@RequestParam("instrumentos") String instrumentos, @RequestParam("linkFb") String linkFb, @RequestParam("linkIg") String linkIg,
		@RequestParam("descricao") String descricao, HttpServletRequest request, Model model
	) {
		
		/*MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("fotoPerfil");
		*/
		byte[] fotoPerfilByte = null;
		/*
		try {
			fotoPerfilByte = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		//insere no musico os dados vindo do formulário
		Musico novoMusico =  new Musico(nome,email,senha,estiloMusical,instrumentos,fotoPerfilByte,linkFb,linkIg,descricao,"musico");
		//chama a nossa camada de serviços que foi injetada acima, acionando o método salvar
		service.salvar(novoMusico);
		
		return "/cSucesso";
		
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
