package com.senac.muver.services;

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

	public Master listarUsuario(byte[] fotoPerfil, String nome, String descricao) {
		return repositorio.listarUsuario(fotoPerfil,nome,descricao);
	}
	
}