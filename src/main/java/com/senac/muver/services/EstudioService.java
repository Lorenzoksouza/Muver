package com.senac.muver.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.muver.model.Estudio;
import com.senac.muver.repository.EstudioRepository;

@Service
public class EstudioService {
	
	//Injeção do repositório
		@Autowired
		private EstudioRepository repositorio;
		
		//Serviço para listar todos os convidados da base
		public Iterable<Estudio> listaTodosEstudios(){
			
			//chamada ao repositório que fará a consulta com a nossa base via jpa;
			return repositorio.findAll();
		}
		
		public Optional<Estudio> estudioPorID(Integer id) {
			
			return repositorio.findById(id);
		}
		
		//serviço para salvar o convidado
		public void salvar (Estudio estudio) {
			
			//chamada ao repositório
			repositorio.save(estudio);
		}
		
		public void excluir(Estudio estudio) {
			
			repositorio.delete(estudio);
		}

		public void alterar(Estudio estudio) {

			repositorio.save(estudio);
		}
}
