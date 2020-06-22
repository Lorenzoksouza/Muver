package com.senac.muver.model;

import java.io.FileInputStream;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="estudio")
@PrimaryKeyJoinColumn(name="idestudio")
public class Estudio extends Master implements Serializable {

	//injetando os getters e setters via lombok
	@Getter @Setter
	private String localizacao;
	
	public Estudio(String nome, String email, String senha, String localizacao, byte[] fotoPerfil, String linkFb, String linkIg,
			String descricao, String tipoUsuario) {
		super(nome, email, senha, linkFb, linkIg, descricao, fotoPerfil, tipoUsuario);
		this.localizacao = localizacao;
	}
	
	public Estudio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}