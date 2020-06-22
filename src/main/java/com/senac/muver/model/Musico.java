package com.senac.muver.model;

import java.io.FileInputStream;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="musico")
@PrimaryKeyJoinColumn(name="idmusico")
public class Musico extends Master implements Serializable {

	//injetando os getters e setters via lombok
	@Getter @Setter
	private String estiloMusical;
	@Getter @Setter
	//mudei pra public pra conseguir aparecer na tela, investigar isso
	public String instrumentos;
	
	public Musico(String nome, String email, String senha,String estiloMusical, String instrumentos, byte[] fotoPerfil, String linkFb, String linkIg,
			String descricao, String tipoUsuario) {
		super(nome, email, senha, linkFb, linkIg, descricao, fotoPerfil, tipoUsuario);
		this.estiloMusical = estiloMusical;
		this.instrumentos = instrumentos;
	}
	
	public Musico() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
