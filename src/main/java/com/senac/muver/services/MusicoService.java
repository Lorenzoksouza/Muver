package com.senac.muver.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.senac.muver.model.Musico;
import com.senac.muver.repository.MusicoRepository;

public class MusicoService {

	//Injeção do repositório
	@Autowired
	private MusicoRepository repositorio;
	
	//Serviço para listar todos os convidados da base
	public Iterable<Musico> listaTodosMusicos(){
		
		//chamada ao repositório que fará a consulta com a nossa base via jpa;
		return repositorio.findAll();
	}
	
	//serviço para salvar o convidado
	public void salvar (Musico musico) {
		
		//chamada ao repositório
		repositorio.save(musico);
	}
}
