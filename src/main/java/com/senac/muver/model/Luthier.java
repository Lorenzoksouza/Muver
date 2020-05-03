package com.senac.muver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="luthier")
public class Luthier extends Master implements Serializable {

	//injetando os getters e setters via lombok
	@Getter @Setter
	private String instrumentos;
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
	
	public Luthier(String nome, String email, String senha, String instrumentos, String localizacao, byte[] fotoPerfil, String linkFb, String linkIg,
			String descricao) {
		super(nome, email, senha);
		this.instrumentos = instrumentos;
		this.localizacao = localizacao;
		this.fotoPerfil = fotoPerfil;
		this.linkFb = linkFb;
		this.linkIg = linkIg;
		this.descricao = descricao;
	}
	public Luthier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Luthier(Integer id, String nome, String email, String senha) {
		super(id, nome, email, senha);
		// TODO Auto-generated constructor stub
	}
	public Luthier(String nome, String email, String senha) {
		super(nome, email, senha);
		// TODO Auto-generated constructor stub
	}
	
	

	
}
