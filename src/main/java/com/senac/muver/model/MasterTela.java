package com.senac.muver.model;

import java.io.File;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
public class MasterTela implements Serializable{
	
	@Getter @Setter
	public Integer idmaster;
	@Getter @Setter
	public String nome;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String senha;
	@Getter @Setter
	public String linkFb;
	@Getter @Setter
	public String linkIg;
	@Getter @Setter
	public String descricao;
	@Getter @Setter
	public File fotoPerfil;
	@Getter @Setter
	private String tipoUsuario;
	@Getter @Setter
	private Instrumento[] instrumentos;
	@Getter @Setter
	private EstiloMusical[] estiloMusical;
	
	public MasterTela() {
		// TODO Auto-generated constructor stub
	}

	public MasterTela(String nome, String email, String senha, String linkFb, String linkIg, String descricao,
			File fotoPerfil, String tipoUsuario, Instrumento[] instrumentos, EstiloMusical[] estiloMusical) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.linkFb = linkFb;
		this.linkIg = linkIg;
		this.descricao = descricao;
		this.fotoPerfil = fotoPerfil;
		this.tipoUsuario = tipoUsuario;
		this.instrumentos = instrumentos;
		this.estiloMusical = estiloMusical;
	}	
}