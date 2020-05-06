package com.senac.muver.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.muver.model.Master;
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
	
	//serviço para salvar o musico
	public void salvar (Musico musico) {
		
		//chamada ao repositório
		repositorio.save(musico);
	}
	
	public void excluir(Musico musico) {
		
		repositorio.delete(musico);
	}

	
}
