package com.senac.muver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

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
	private String instrumentos;
	@Getter @Setter
	private byte[] fotoPerfil;
	@Getter @Setter
	private String linkFb;
	@Getter @Setter
	private String linkIg;
	@Getter @Setter
	private String descricao;
	
	public Musico(String nome, String email, String senha,String estiloMusical, String instrumentos, byte[] fotoPerfil, String linkFb, String linkIg,
			String descricao) {
		super(nome, email, senha);
		this.estiloMusical = estiloMusical;
		this.instrumentos = instrumentos;
		this.fotoPerfil = fotoPerfil;
		this.linkFb = linkFb;
		this.linkIg = linkIg;
		this.descricao = descricao;
	}
	public Musico() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Musico(Integer id, String nome, String email, String senha) {
		super(id, nome, email, senha);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
