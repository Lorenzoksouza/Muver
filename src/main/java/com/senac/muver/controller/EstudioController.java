package com.senac.muver.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.senac.muver.util.ConvertMasterTela;
import com.senac.muver.model.Estudio;
import com.senac.muver.model.Luthier;
import com.senac.muver.model.Master;
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
	
	
	@RequestMapping(value = "/cEstudio", method = RequestMethod.GET)
	public String cEstudio(Estudio estudio) { 
	
		return "cEstudio"; 
	}
	
	  @RequestMapping(value = "cadastrarEstudio", method = RequestMethod.GET)
	  public String teste() { return "cEstudio"; }
	 
		
	  @RequestMapping(value = "cadastrarEstudio", method = RequestMethod.POST)
	  public String salvar(@RequestParam("nome") String nome,  @RequestParam("email") String email, @RequestParam("senha") String senha,
	  @RequestParam(value="localizacao", required = false) String localizacao,@RequestParam(value="disponibilidade", required = false) String disponibilidade, @RequestParam(value="linkFb", required = false) String
	  linkFb, @RequestParam(value="linkIg", required = false) String linkIg, @RequestParam(value="descricao", required = false) String descricao, HttpServletRequest request, Model model){
	  
	  MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
	  MultipartFile multipartFile = multipartRequest.getFile("fotoPerfil");
	  
	  byte[] fotoPerfilByte = null;
	  
	  try { fotoPerfilByte = multipartFile.getBytes(); } catch (IOException e) {
	  e.printStackTrace(); }
	  
	  String gmaps = localizacao.replace("<iframe ", "").replace("src=\"",
	  "").replace("></iframe>", "");
	  
	  String calendar = disponibilidade.replace("<iframe ", "").replace("src=\"",
	  "").replace("></iframe>", "");
	  
	  String senhaCriptografada = new BCryptPasswordEncoder().encode(senha);
	  
	  
	  //insere no estudio os dados vindo do formulário 
	  Estudio
	  novoEstudio = new
	  Estudio(nome, email, senhaCriptografada, gmaps, fotoPerfilByte, linkFb,
	  linkIg, descricao,"estudio", calendar, 0, 0, 0); 
	  //chama a nossa camada de serviços que foi injetada acima, acionando o método salvar
	  service.salvar(novoEstudio); System.out.println(linkFb); return "/cSucesso";
	  
	  }
	 
	
	
	@RequestMapping(value = "/excluirEstudio", method = RequestMethod.POST)
	 public String excluirPerfil(@RequestParam("nome") String nome, HttpServletRequest request, Model model) {
		service.excluir(nome);
		 
		return "redirect:/login";
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
	public String alterar(@RequestParam("nome") String nome,@RequestParam("idmaster") int id, @RequestParam("email") String email,
			@RequestParam(value="localizacao", required = false) String localizacao,@RequestParam(value="disponibilidade", required = false) String disponibilidade, @RequestParam(value="linkFb", required = false) String linkFb, @RequestParam(value="linkIg", required = false) String linkIg, 
			@RequestParam(value="descricao", required = false) String descricao, HttpServletRequest request, Model model) {
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("fotoPerfil");
		
		byte[] fotoPerfilByte = null;
		
		try {
			fotoPerfilByte = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		  String gmaps = localizacao.replace("<iframe ", "").replace("src=\"",
				  "").replace("></iframe>", "");
				  
		  String calendar = disponibilidade.replace("<iframe ", "").replace("src=\"",
		  "").replace("></iframe>", "");
		
		service.alterar(nome, email, fotoPerfilByte, linkFb, linkIg, descricao);
		service.alterarEstudio(gmaps,calendar, id);
		return "redirect:/principal";
		
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
