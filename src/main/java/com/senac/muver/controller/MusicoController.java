package com.senac.muver.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("senha") String senha, 
			/*@RequestParam("estilo") String[] estilosMusicais, @RequestParam("instrumentos") String[] instrumentos, */
			@RequestParam(value="estilo", required = false) String[] estiloMusical, @RequestParam(value="instrumentos", required = false) String[] instrumento,
			HttpServletRequest request, Model model) {
		//@RequestParam("linkFb") String linkFb, @RequestParam("linkIg") String linkIg, @RequestParam("descricao") String descricao, 
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
		
		String estilosMusicais = Arrays.toString(estiloMusical)
				.replace(",", "")
				.replace("[", "")
				.replace("]", "")
				;
		
		/*EstiloMusical[] estiloMusicalArray = new EstiloMusical[estilosMusicais.length];
		for(int i = 0; i < estilosMusicais.length; i++) {
			EstiloMusical estiloMusical = new EstiloMusical();
			estiloMusical.setNome(instrumentos[i]);
			estiloMusicalArray[i] = estiloMusical;
		}*/
		
		String senhaCriptografada = new BCryptPasswordEncoder().encode(senha);
		String descricao = "";
		String linkFb = "";
		String linkIg = "";
		
		//insere no musico os dados vindo do formulário
		Musico novoMusico =  new Musico(nome,email,senhaCriptografada,/*estiloMusicalArray,instrumentosArray,*/estilosMusicais, instrumentos, fotoPerfilByte,linkFb,linkIg,descricao,"musico", 0, 0, 0);
		//chama a nossa camada de serviços que foi injetada acima, acionando o método salvar
		service.salvar(novoMusico);
		
		return "/cSucesso";
		
	}
	

	

	@GetMapping("cMusico")
	public String arrayController (Model model) {
		String[] instrumentos = {
				"Baixo", "Banjo", "Bateria", "Cavaquinho", "Clarinete", "Flauta", "Guitarra", "Piano", "Sanfona", "Saxofone", "Trombone", "Violão", "Violino", "Outros"
		};
		
		model.addAttribute("instrumentos", instrumentos);
		
		String[] estilo = {
			"Blues", "Bossa nova", "Forró", "Funk", "Hip-Hop", "Jazz", "Metal", "Pop", "Rock", "Outros"	
		};
		
		model.addAttribute("estilo", estilo);
		return "cMusico";
	}
	


	@RequestMapping(value = "/excluirMusico", method = RequestMethod.POST)
	 public String excluirPerfil(@RequestParam("nome") String nome, HttpServletRequest request, Model model) {
		
		service.excluir(nome);
		 
		return "redirect:/login";
	 }
	
	/*
	 * @RequestMapping(value = "excluir") public String
	 * excluir(@RequestParam("musico") Musico musico, Model model) {
	 * 
	 * service.excluir(musico);
	 * 
	 * return "index";
	 * 
	 * }
	 */

	@RequestMapping(value = "alterarMusico")
	public String alterar(@RequestParam("nome") String nome,@RequestParam("idmaster") String id, @RequestParam("email") String email,
			 @RequestParam(value = "instrumentos", required = false) String[] instrumento,
			@RequestParam(value ="estilo", required = false) String[] estiloMusical, HttpServletRequest request, Model model) {
		//@RequestParam("linkFb") String linkFb, @RequestParam("linkIg") String linkIg, @RequestParam("descricao") String descricao,
		
		
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
		
		String estilosMusicais = Arrays.toString(estiloMusical)
				.replace(",", "")
				.replace("[", "")
				.replace("]", "")
				;
		
		
		String descricao = "";
		String linkFb = "";
		String linkIg = "";
		
		service.alterarM(nome, email, fotoPerfilByte, linkFb, linkIg, descricao);
		service.alterarMusico(instrumentos,estilosMusicais, id);
		return "redirect:/principal";
		
	}
	
}
