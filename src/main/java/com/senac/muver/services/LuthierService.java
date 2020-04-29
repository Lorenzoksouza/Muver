package com.senac.muver.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.muver.model.Luthier;
import com.senac.muver.repository.LuthierRepository;

@Service
public class LuthierService {

	//Injeção do repositório
			@Autowired
			private LuthierRepository repositorio;
			
			//Serviço para listar todos os convidados da base
			public Iterable<Luthier> listaTodosLuthier(){
				
				//chamada ao repositório que fará a consulta com a nossa base via jpa;
				return repositorio.findAll();
			}
			
			public Optional<Luthier> luthierPorID(Integer id) {
				
				return repositorio.findById(id);
			}
			
			//serviço para salvar o convidado
			public void salvar (Luthier luthier) {
				
				//chamada ao repositório
				repositorio.save(luthier);
			}
			
			public void excluir(Luthier luthier) {
				
				repositorio.delete(luthier);
			}

			public void alterar(Luthier luthier) {

				repositorio.save(luthier);
			}
}
