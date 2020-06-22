package com.senac.muver.model;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

//declarando que esta é uma entidade de banco
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MasterTela implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmaster")
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
	
	public MasterTela() {
		// TODO Auto-generated constructor stub
	}

	public MasterTela(String nome, String email, String senha, String linkFb, String linkIg, String descricao,
			File fotoPerfil, String tipoUsuario) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.linkFb = linkFb;
		this.linkIg = linkIg;
		this.descricao = descricao;
		this.fotoPerfil = fotoPerfil;
		this.tipoUsuario = tipoUsuario;
	}
	
		
}