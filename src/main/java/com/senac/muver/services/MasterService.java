package com.senac.muver.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public ArrayList<Master> listaUsuariosEstudios() {
		return repositorio.listaUsuariosEstudios();
	}
	
	public ArrayList<Master> listaUsuariosLuthiers() {
		return repositorio.listaUsuariosLuthiers();
	}

	public ArrayList<Master> pesquisaNome(String nome) {
		return repositorio.pesquisaNome(nome);
	}
	
	public ArrayList<Master> pesquisaTipoEstudio(String nome) {
		return repositorio.pesquisaTipoEstudio(nome);
	}
	
	Master findByLogin(String nome) {
		return repositorio.findByLogin(nome);
	}

	public void alterarNota(double nota,int numeroAvaliacoes, double nSoma, String email) {
		repositorio.alterarNota(nota, numeroAvaliacoes,nSoma,email);
	}

	public Master procurarNota(String email) {
		return repositorio.procurarNota(email);
	}


	//public ArrayList<Master> listaPesquisa(String pesquisa) {
	//	return repositorio.listaPesquisa(pesquisa);
	//}
	
}