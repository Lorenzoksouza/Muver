package com.senac.muver.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.MTOM;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.senac.muver.model.Master;
import com.senac.muver.model.MasterTela;
import com.senac.muver.model.Musico;
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
		ArrayList<MasterTela> usuariosTela = new ArrayList<MasterTela>();
		for (Master m : listaUsuarios) {
			MasterTela mt = new MasterTela();
			try { 
				InputStream initialStream =new ByteArrayInputStream(m.getFotoPerfil());
					    File targetFile = new File("src/main/resources/static/images/fotoPerfil" + m.getIdmaster() + ".jpg");
					    OutputStream outStream = new FileOutputStream(targetFile);
					 
					    byte[] buffer = new byte[8 * 1024];
					    int bytesRead;
					    while ((bytesRead = initialStream.read(buffer)) != -1) {
					        outStream.write(buffer, 0, bytesRead);
					    }
					    System.out.println("passei aqui");
					    mt.setFotoPerfil(new File("images/fotoPerfil" + m.getIdmaster() + ".jpg"));
					    IOUtils.closeQuietly(initialStream);
					    IOUtils.closeQuietly(outStream);
		        } catch (Exception e) { 
		           e.printStackTrace(); 
		        }
			mt.setNome(m.getNome());
			usuariosTela.add(mt);
		}
		mv.addObject("usuarios", usuariosTela);
		return mv;
	}
	
	@GetMapping("/principalEstudio")
	public ModelAndView listaEstudios() {
		ModelAndView mv = new ModelAndView("/principalEstudio"); 
		mv.addObject("usuarios", service.listaEstudios());
		return mv;
	}
	
	@GetMapping("/principalLuthier")
	public ModelAndView listaLuthiers() {
		ModelAndView mv = new ModelAndView("/principalLuthier"); 
		mv.addObject("usuarios", service.listaLuthiers());
		return mv;
	}
	
}
