package com.senac.muver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="estudio")
@PrimaryKeyJoinColumn(name="idestudio")
public class Estudio extends Master implements Serializable {

	//injetando os getters e setters via lombok
	@Getter @Setter
	private String localizacao;
	@Getter @Setter
	private byte[] fotoPerfil;
	@Getter @Setter
	private String linkFb;
	@Getter @Setter
	private String linkIg;
	@Getter @Setter
	private String descricao;
	
	public Estudio(String nome, String email, String senha, String localizacao, byte[] fotoPerfil, String linkFb, String linkIg,
			String descricao) {
		super(nome, email, senha);
		this.localizacao = localizacao;
		this.fotoPerfil = fotoPerfil;
		this.linkFb = linkFb;
		this.linkIg = linkIg;
		this.descricao = descricao;
	}
	public Estudio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Estudio(Integer id, String nome, String email, String senha) {
		super(id, nome, email, senha);
		// TODO Auto-generated constructor stub
	}
	public Estudio(String nome, String email, String senha) {
		super(nome, email, senha);
		// TODO Auto-generated constructor stub
	}
	
	
}