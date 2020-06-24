package com.senac.muver.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.muver.model.Master;
import com.senac.muver.repository.MasterRepository;

@Service
public class MasterService {
	
	@Autowired
	private MasterRepository repositorio;

	public Iterable<Master> listaTodosUsuarios(){
		return repositorio.findAll();
	}
	

	public Master existeUsuario(String email, String senha) {
		return repositorio.existeUsuario(email,senha);
	}

	public Master listarUsuario() {
		return repositorio.listarUsuario();
	}


	public ArrayList<Master> listaUsuariosSemMusico() {
		return repositorio.listaUsuariosSemMusico();
	}


	public ArrayList<Master> listaEstudios() {
		return repositorio.listaEstudios();
	}


	public ArrayList<Master> listaLuthiers() {
		return repositorio.listaLuthiers();
	}


	public Master perfilNome(String nome) {
		return repositorio.PerfilNome(nome);
	}
	
	public ArrayList<Master> pesquisaNome(String nome) {
		return repositorio.pesquisaNome(nome);
	}
	
	//public ArrayList<Master> listaPesquisa(String pesquisa) {
	//	return repositorio.listaPesquisa(pesquisa);
	//}
	
}