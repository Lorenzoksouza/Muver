package com.senac.muver.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.senac.muver.model.Instrumento;
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
	public String salvar(@RequestParam("email") String email, @RequestParam("senha") String senha, @RequestParam("instrumentos") Instrumento[] instrumentos,
		@RequestParam("nome") String nome, @RequestParam("localizacao") String localizacao, @RequestParam("linkFb") String linkFb, 
		@RequestParam("linkIg") String linkIg, @RequestParam("descricao") String descricao, HttpServletRequest request, Model model){
		
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("fotoPerfil");
		
		byte[] fotoPerfilByte = null;
		
		try {
			fotoPerfilByte = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Luthier novoLuthier =  new Luthier(nome, email, senha, instrumentos, localizacao, fotoPerfilByte, linkFb, linkIg, descricao,"luthier");
		service.salvar(novoLuthier);
		
		return "/cSucesso";
		
	}
	
	@RequestMapping(value = "excluirLuthier")
	public String excluir(@RequestParam("luthier") Luthier luthier, Model model) {
		
		service.excluir(luthier);
		
		return "index";
		
	}
	
	@RequestMapping(value = "alterarLuthier")
	public String alterar(@RequestParam("luthier") Luthier luthier, Model model) {
		
		service.alterar(luthier);
		
		return "index";
		
	}
}
