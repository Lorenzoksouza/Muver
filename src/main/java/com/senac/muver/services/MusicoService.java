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
	
	public void excluir(Musico musico) {
		
		repositorio.delete(musico);
	}

	public void alterar(String nome, String email, String senhaCriptografada, byte[] fotoPerfilByte,
			String linkFb, String linkIg, String descricao) {
		repositorio.alterar(nome, email, senhaCriptografada, fotoPerfilByte, linkFb, linkIg, descricao);
		
	}

	public void alterarMusico(String instrumentos, String estilosMusicais, String nome) {
		repositorio.alterarMusico(instrumentos, estilosMusicais, nome);
		
	}

	
}
