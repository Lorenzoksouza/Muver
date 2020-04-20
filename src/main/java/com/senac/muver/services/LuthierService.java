package com.senac.muver.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.senac.muver.model.Luthier;
import com.senac.muver.repository.LuthierRepository;

public class LuthierService {

	//Injeção do repositório
			@Autowired
			private LuthierRepository repositorio;
			
			//Serviço para listar todos os convidados da base
			public Iterable<Luthier> listaTodosLuthier(){
				
				//chamada ao repositório que fará a consulta com a nossa base via jpa;
				return repositorio.findAll();
			}
			
			//serviço para salvar o convidado
			public void salvar (Luthier luthier) {
				
				//chamada ao repositório
				repositorio.save(luthier);
			}
}
