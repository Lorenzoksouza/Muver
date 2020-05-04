package com.senac.muver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

//declarando que esta é uma entidade de banco
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Master implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	//injetando os getters e setters via lombok
	@Getter @Setter
	private Integer id;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String senha;
	@Getter @Setter
	private String linkFb;
	@Getter @Setter
	private String linkIg;
	@Getter @Setter
	private String descricao;
	@Getter @Setter
	private byte[] fotoPerfil;
	
	public Master() {
		// TODO Auto-generated constructor stub
	}

	public Master(String nome, String email, String senha, String linkFb, String linkIg, String descricao,
			byte[] fotoPerfil) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.linkFb = linkFb;
		this.linkIg = linkIg;
		this.descricao = descricao;
		this.fotoPerfil = fotoPerfil;
	}

}