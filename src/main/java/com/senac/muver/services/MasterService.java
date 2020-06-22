package com.senac.muver.services;

import java.io.File;
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


	public Object listaEstudios() {
		return repositorio.listaEstudios();
	}


	public Object listaLuthiers() {
		return repositorio.listaLuthiers();
	}


	public Object perfilNome(String nome) {
		return repositorio.PerfilNome(nome);
	}
	
}