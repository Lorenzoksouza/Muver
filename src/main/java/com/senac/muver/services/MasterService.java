package com.senac.muver.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.senac.muver.model.Master;
import com.senac.muver.repository.MasterRepository;

public class MasterService {
	
	@Autowired
	private MasterRepository repositorio;

	public Iterable<Master> listaTodosUsuarios(){
		return repositorio.findAll();
	}

	
	
}