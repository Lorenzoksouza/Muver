package com.senac.muver.services;

import java.util.ArrayList;
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
		
		public ArrayList<Estudio> listaEstudios() {
			return repositorio.listaEstudios();
		}
		
		public Estudio perfilPorNomeEstudio(String nome) {
			return repositorio.perfilPorNomeEstudio(nome);
		}
		
		//serviço para salvar o convidado
		public void salvar (Estudio estudio) {
			
			//chamada ao repositório
			repositorio.save(estudio);
		}
		
		public void excluir(String nome) {
			
			repositorio.excluir(nome);
		}

		/*
		 * public void alterar(Estudio estudio) {
		 * 
		 * repositorio.alterar(estudio); }
		 * 
		 */
		
		public void alterar(String nome, String email, String senhaCriptografada, byte[] fotoPerfilByte, String linkFb,
				String linkIg, String descricao) {
			repositorio.alterar(nome, email, senhaCriptografada, fotoPerfilByte, linkFb, linkIg, descricao);
			
		}

		public void alterarEstudio(String localizacao, String nome) {
			// TODO Auto-generated method stub
			repositorio.alterarEstudio(localizacao, nome);
		}
}
