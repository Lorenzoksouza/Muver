package com.senac.muver.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.senac.muver.model.Luthier;
import com.senac.muver.model.MasterTela;
import com.senac.muver.services.LuthierService;

@Controller
public class LuthierController {

	@Autowired
	private LuthierService service;
	
	private ConvertMasterTela convert = new ConvertMasterTela();
	
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
	
	@GetMapping("/principalLuthier")
	public ModelAndView listaLuthiers() {
		ModelAndView mv = new ModelAndView("/principalLuthier"); 
		ArrayList<Luthier> listaUsuarios = service.listaLuthiers();
		ArrayList<MasterTela> listaMt = new ArrayList<MasterTela>();
		for (Luthier l : listaUsuarios) {
			MasterTela mt = convert.converteLuthierEmMasterTela(l);
			listaMt.add(mt);
		}
		mv.addObject("usuarios", listaMt);
		return mv;
	}
	
	@RequestMapping(value = "cadastrarLuthier", method = RequestMethod.POST)
	public String salvar(@RequestParam("email") String email, @RequestParam("senha") String senha, /*@RequestParam("instrumentos") String[] instrumentos,*/
		@RequestParam(value="instrumentos", required = false) String[] instrumento,
		@RequestParam("nome") String nome, @RequestParam(value="localizacao", required = false) String localizacao,@RequestParam(value="disponibilidade", required = false) String disponibilidade, @RequestParam(value="linkFb", required = false) String linkFb, 
		@RequestParam(value="linkIg", required = false) String linkIg, @RequestParam(value="descricao", required = false) String descricao, HttpServletRequest request, Model model){
		
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("fotoPerfil");
		byte[] fotoPerfilByte = null;
		try {
			fotoPerfilByte = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		String instrumentos = Arrays.toString(instrumento)
				.replace(",", "")
				.replace("[", "")
				.replace("]", "")
				;
		
		/*
		Instrumento[] instrumentosArray = new Instrumento[instrumentos.length];
		for(int i = 0; i < instrumentos.length; i++) {
			Instrumento instrumento = new Instrumento();
			instrumento.setNome(instrumentos[i]);
			instrumentosArray[i] = instrumento;
		}
		*/
		String senhaCriptografada = new BCryptPasswordEncoder().encode(senha);
		
		String gmaps = localizacao.replace("<iframe ", "").replace("src=\"", "").replace("></iframe>", "");
		
		//String gmaps = localizacao.substring(13).replace("></iframe>", "");
		
		String calendar = disponibilidade.replace("<iframe ", "").replace("src=\"", "").replace("></iframe>", "");

		
		Luthier novoLuthier =  new Luthier(nome, email, senhaCriptografada,/* instrumentosArray,*/instrumentos, gmaps, fotoPerfilByte, linkFb, linkIg, descricao,"luthier", calendar, 0, 0, 0);
		service.salvar(novoLuthier);
		
		return "/cSucesso";
		
	}
	
	@GetMapping("cLuthier")
	public String arrayController (Model model) {
		String[] instrumentos = {
			
			"Baixo", "Banjo", "Bateria", "Cavaquinho", "Clarinete", "Flauta", "Guitarra", "Piano", "Sanfona", "Saxofone", "Trombone", "Violão", "Violino", "Outros"
		};
		
		model.addAttribute("instrumentos", instrumentos);
		return "cLuthier";
	}
	
	
	@RequestMapping(value = "/excluirLuthier", method = RequestMethod.POST)
	 public String excluirPerfil(@RequestParam("nome") String nome, HttpServletRequest request, Model model) {
		
		service.excluir(nome);
		 
		return "cSucesso";
	 }
	
	/*
	 * @RequestMapping(value = "excluirLuthier") public String
	 * excluir(@RequestParam("luthier") Luthier luthier, Model model) {
	 * 
	 * service.excluir(luthier);
	 * 
	 * return "index";
	 * 
	 * }
	 */
	
	
	@RequestMapping(value = "alterarLuthier")
	public String alterar(@RequestParam("nome") String nome,@RequestParam("idmaster") int id, @RequestParam("email") String email,  @RequestParam("senha") String senha,
			@RequestParam(value="localizacao", required = false) String localizacao,@RequestParam(value="disponibilidade", required = false) String disponibilidade, @RequestParam(value="linkFb", required = false) String linkFb, @RequestParam(value="linkIg", required = false) String linkIg, 
			@RequestParam(value="descricao", required = false) String descricao, @RequestParam(value="instrumentos", required = false) String[] instrumento, HttpServletRequest request, Model model) {
		
		
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("fotoPerfil");
		
		byte[] fotoPerfilByte = null;
		
		try {
			fotoPerfilByte = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String instrumentos = Arrays.toString(instrumento)
				.replace(",", "")
				.replace("[", "")
				.replace("]", "")
				;
		
		
		 String gmaps = localizacao.replace("<iframe ", "").replace("src=\"",
				  "").replace("></iframe>", "");
				  
		  String calendar = disponibilidade.replace("<iframe ", "").replace("src=\"",
		  "").replace("></iframe>", "");
		
		  String senhaCriptografada = new BCryptPasswordEncoder().encode(senha);
		  
		service.alterar(nome, email, senhaCriptografada, fotoPerfilByte, linkFb, linkIg, descricao);
		service.alterarLuthier(gmaps,calendar, instrumentos, id);
		return "redirect:/principal";
		
	}
}
