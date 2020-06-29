package com.senac.muver.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.senac.muver.util.ConvertMasterTela;
import com.senac.muver.model.Estudio;
import com.senac.muver.model.Luthier;
import com.senac.muver.model.MasterTela;
import com.senac.muver.services.EstudioService;

@Controller
public class EstudioController {

	@Autowired
	private EstudioService service;
	
	private ConvertMasterTela convert = new ConvertMasterTela();
	
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
	
	@GetMapping("/principalEstudio")
	public ModelAndView listaEstudios() {
		ModelAndView mv = new ModelAndView("/principalEstudio"); 
		ArrayList<Estudio> listaUsuarios = service.listaEstudios();
		ArrayList<MasterTela> listaMt = new ArrayList<MasterTela>();
		for (Estudio es : listaUsuarios) {
			MasterTela mt = convert.converteEstudioEmMasterTela(es);
			listaMt.add(mt);
		}
		mv.addObject("usuarios", listaMt);
		return mv;
	}
	
	@RequestMapping(value = "cadastrarEstudio", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("senha") String senha,
			@RequestParam("localizacao") String localizacao, @RequestParam("linkFb") String linkFb, @RequestParam("linkIg") String linkIg, 
			@RequestParam("descricao") String descricao, HttpServletRequest request, Model model){
		
		//REQUISITAR A IMG E VERIFICAR SE ESTA NULL, SE ESTIVER PASSAR A IMAGEM PADRAO
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("fotoPerfil");
		
		byte[] fotoPerfilByte = null;
		
		try {
			fotoPerfilByte = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String senhaCriptografada = new BCryptPasswordEncoder().encode(senha);
		
		//insere no estudio os dados vindo do formulário
		Estudio novoEstudio =  new Estudio(nome, email, senhaCriptografada, localizacao, fotoPerfilByte, linkFb, linkIg, descricao,"estudio");
		//chama a nossa camada de serviços que foi injetada acima, acionando o método salvar
		service.salvar(novoEstudio);
		
		return "/cSucesso";
		
	}
	
	
	@RequestMapping(value = "/excluirEstudio", method = RequestMethod.POST)
	 public String excluirPerfil(@RequestParam("nome") String nome, @RequestParam("id") Integer id, HttpServletRequest request, Model model) {
		
		String nome1 = "Estudio3";
		Integer id1 = 25;
		service.excluir(nome1, id1);
		 
		return "editar";
	 }
	
	/*
	 * @RequestMapping(value = "excluirEstudio") public String
	 * excluir(@RequestParam("estudio") Estudio estudio, Model model) {
	 * 
	 * service.excluir(estudio);
	 * 
	 * return "index";
	 * 
	 * }
	 */
	
	@RequestMapping(value = "alterarEstudio")
	public String alterar(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("senha") String senha,
			@RequestParam("localizacao") String localizacao, @RequestParam("linkFb") String linkFb, @RequestParam("linkIg") String linkIg, 
			@RequestParam("descricao") String descricao, HttpServletRequest request, Model model) {
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("fotoPerfil");
		
		byte[] fotoPerfilByte = null;
		
		try {
			fotoPerfilByte = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String senhaCriptografada = new BCryptPasswordEncoder().encode(senha);
		
		service.alterar(nome, email, senhaCriptografada, fotoPerfilByte, linkFb, linkIg, descricao);
		service.alterarEstudio(localizacao, nome);
		return "editar";
		
	}
	

	
	/*
	 * @RequestMapping(value = "alterarEstudio") public String
	 * alterar(@RequestParam("estudio") Estudio estudio, Model model) {
	 * 
	 * service.salvar(estudio);
	 * 
	 * return "index";
	 * 
	 * }
	 */
}
