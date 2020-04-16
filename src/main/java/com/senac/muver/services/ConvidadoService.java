package com.senac.ads.experts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.ads.experts.model.Convidados;
import com.senac.ads.experts.repository.ConvidadosRepository;

//declaração explícita que esta é uma de nossas classes de serviço
@Service
public class ConvidadoService {
	
	//Injeção do repositório
	@Autowired
	private ConvidadosRepository repositorio;
	
	//Serviço para listar todos os convidados da base
	public Iterable<Convidados> listaTodosConvidados(){
		
		//chamada ao repositório que fará a consulta com a nossa base via jpa;
		return repositorio.findAll();
	}
	
	//serviço para salvar o convidado
	public void salvar (Convidados conv) {
		
		//chamada ao repositório
		repositorio.save(conv);
	}

}
