package com.senac.muver.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.senac.muver.model.Master;
import com.senac.muver.model.MasterTela;
import com.senac.muver.services.MasterService;

@Controller
public class PerfilController {
	

	@Autowired
	private MasterService service;

	
	@GetMapping("/perfil/{nome}")
	public ModelAndView perfilNome(@PathVariable String nome, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/perfil");
		Master usuario = service.perfilNome(nome);
		mv.addObject("usuarios", converteMasterEmMasterTela(usuario));
		return mv;
	 }
	
    
    @RequestMapping("/facebook.com/{linkFb}")
    public RedirectView faceRedirect(@PathVariable String linkFb) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://facebook.com.br/" + linkFb);
        return redirectView;
    }
    
    @RequestMapping("/instagram.com/{linkIg}")
    public RedirectView instaRedirect(@PathVariable String linkIg) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://instagram.com.br/" + linkIg);
        return redirectView;
    }

    private MasterTela converteMasterEmMasterTela(Master usuario) {
		
			MasterTela mt = new MasterTela();
//			try { 
//				InputStream initialStream =new ByteArrayInputStream(usuario.getFotoPerfil());
//					    File targetFile = new File("src/main/resources/static/images/fotoPerfil" + usuario.getIdmaster() + ".tmp");
//					    OutputStream outStream = new FileOutputStream(targetFile);
//					 
//					    byte[] buffer = new byte[8 * 1024];
//					    int bytesRead;
//					    while ((bytesRead = initialStream.read(buffer)) != -1) {
//					        outStream.write(buffer, 0, bytesRead);
//					    }
//					    IOUtils.closeQuietly(initialStream);
//					    IOUtils.closeQuietly(outStream);
//		        } catch (Exception e) { 
//		           e.printStackTrace(); 
//		        }
			mt.setFotoPerfil(new File("../images/fotoPerfil" + usuario.getIdmaster() + ".tmp"));
			mt.setNome(usuario.getNome());
			mt.setDescricao(usuario.getDescricao());
			mt.setLinkFb(usuario.getLinkFb());
			mt.setLinkIg(usuario.getLinkIg());
			mt.setTipoUsuario(usuario.getTipoUsuario());
			mt.setEmail(usuario.getEmail());
			
		return  mt;
	}
    
}
