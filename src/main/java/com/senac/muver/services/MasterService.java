package com.senac.muver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.muver.model.Master;
import com.senac.muver.repository.MasterRepository;

//declaração explícita que esta é uma de nossas classes de serviço
@Service
public class MasterService {
	
	//Injeção do repositório
	@Autowired
	private MasterRepository repositorio;
	
	//Serviço para listar todos os usuarios da base
	public Iterable<Master> listaTodos(){
		
		//chamada ao repositório que fará a consulta com a nossa base via jpa;
		return repositorio.findAll();
	}
	
	//serviço para salvar o usuario
	public void salvar (Master master) {
		
		//chamada ao repositório
		repositorio.save(master);
		
	}
	
	public void excluir(Master master) {
		
		repositorio.delete(master);
		
	}
	
	

}
