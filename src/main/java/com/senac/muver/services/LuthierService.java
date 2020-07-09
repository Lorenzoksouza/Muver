package com.senac.muver.services;

import java.util.ArrayList;
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
			
			public ArrayList<Luthier> listaLuthiers() {
				return repositorio.listaLuthiers();
			}
			
			public Luthier perfilPorNomeLuthier(String nome) {
				return repositorio.perfilPorNomeLuthier(nome);
			}
			
			//serviço para salvar o convidado
			public void salvar (Luthier luthier) {
				repositorio.save(luthier);
			}
			
			public void excluir(String nome) {
				
				repositorio.excluir(nome);
			}


			public void alterar(String nome, String email, byte[] fotoPerfilByte,
					String linkFb, String linkIg, String descricao) {
				repositorio.alterar(nome, email, fotoPerfilByte, linkFb, linkIg, descricao);
				
			}

			public void alterarLuthier(String localizacao,String disponibilidade, String instrumentos, int id) {
				repositorio.alterarLuthier(localizacao,disponibilidade, instrumentos, id);
				
			}
}
