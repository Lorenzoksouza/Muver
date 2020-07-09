package com.senac.muver.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.muver.model.Musico;
import com.senac.muver.repository.MusicoRepository;

@Service
public class MusicoService {

	//Injeção do repositório
	@Autowired
	private MusicoRepository repositorio;
	
	//Serviço para listar todos os musicos da base
	public Iterable<Musico> listaTodosMusicos(){ 
		
		//chamada ao repositório que fará a consulta com a nossa base via jpa;
		return repositorio.findAll();
	}
	
	public Optional<Musico> musicoPorID(Integer id) {
		
		return repositorio.findById(id);
	}

	public Musico perfilPorNomeMusico(String nome) {
		return repositorio.perfilPorNomeMusico(nome);
	}
	
	//serviço para salvar o musico
	public void salvar (Musico musico) {
		
		//chamada ao repositório
		repositorio.save(musico);
	}
	
	public void excluir(String nome) {
		
		repositorio.excluir(nome);
	}

	public void alterarM(String nome, String email,  byte[] fotoPerfilByte,
			String linkFb, String linkIg, String descricao) {
		repositorio.alterarM(nome, email, fotoPerfilByte, linkFb, linkIg, descricao);
		
	}

	public void alterarMusico(String instrumentos, String estilosMusicais, String id) {
		repositorio.alterarMusico(instrumentos, estilosMusicais, id);
		
	}

	
}
