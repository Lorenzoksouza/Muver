package com.senac.muver.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.senac.muver.model.Master;
import com.senac.muver.model.MasterTela;
import com.senac.muver.services.MasterService;

@Controller
public class MasterController {
	
	@Autowired
	private MasterService service;
	
	static String FILEPATH = ""; 
    static File file = new File(FILEPATH); 
	
	@GetMapping("/principal")
	public ModelAndView listaUsuarios() {
		
		ModelAndView mv = new ModelAndView("/principal"); 
		ArrayList<Master> listaUsuarios = service.listaUsuariosSemMusico();
		mv.addObject("usuarios", converteMasterEmMasterTela(listaUsuarios));
		
		return mv;
	}
	
	@GetMapping("/principalEstudio")
	public ModelAndView listaEstudios() {
		ModelAndView mv = new ModelAndView("/principalEstudio"); 
		ArrayList<Master> listaUsuarios = service.listaEstudios();
		mv.addObject("usuarios", converteMasterEmMasterTela(listaUsuarios));
		
		return mv;
	}
	
	@GetMapping("/principalLuthier")
	public ModelAndView listaLuthiers() {
		ModelAndView mv = new ModelAndView("/principalLuthier"); 
		ArrayList<Master> listaUsuarios = service.listaLuthiers();
		mv.addObject("usuarios", converteMasterEmMasterTela(listaUsuarios));
		
		return mv;
	}
	
	
	@RequestMapping("/pesquisa")
	public ModelAndView perfilNome( @RequestParam(required = false) String pesquisa, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/principal");
		ArrayList<Master> usuario = service.pesquisaNome(pesquisa);
		mv.addObject("usuarios", converteMasterEmMasterTela(usuario));
		return mv;
	 }
	
	
	/*@RequestMapping("/principal/{pesquisa}")
	public ModelAndView pesquisa(@PathVariable String pesquisa, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/principal");
		ArrayList<Master> listaPesquisa = service.listaPesquisa(pesquisa);
		mv.addObject("usuarios", converteMasterEmMasterTela(listaPesquisa));
		return mv;
	 }
	*/
	
	private ArrayList<MasterTela> converteMasterEmMasterTela(ArrayList<Master> listaUsuarios) {
		
		ArrayList<MasterTela> usuariosTela = new ArrayList<MasterTela>();
		for (Master m : listaUsuarios) {
			MasterTela mt = new MasterTela();
			try { 
				InputStream initialStream =new ByteArrayInputStream(m.getFotoPerfil());
					    File targetFile = new File("src/main/resources/static/images/fotoPerfil" + m.getIdmaster() + ".tmp");
					    OutputStream outStream = new FileOutputStream(targetFile);
					 
					    byte[] buffer = new byte[8 * 1024];
					    int bytesRead;
					    while ((bytesRead = initialStream.read(buffer)) != -1) {
					        outStream.write(buffer, 0, bytesRead);
					    }
					    mt.setFotoPerfil(new File("images/fotoPerfil" + m.getIdmaster() + ".tmp"));
					    IOUtils.closeQuietly(initialStream);
					    IOUtils.closeQuietly(outStream);
		        } catch (Exception e) { 
		           e.printStackTrace(); 
		        }
			mt.setNome(m.getNome());
			mt.setDescricao(m.getDescricao());
			usuariosTela.add(mt);
		}
		return  usuariosTela;
	}
	
}
