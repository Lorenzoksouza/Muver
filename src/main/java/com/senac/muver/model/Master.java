package com.senac.muver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

//declarando que esta é uma entidade de banco
@SuppressWarnings("serial")
@Entity(name="master")
public class Master implements Serializable{
	
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
	private String contato;
	@Getter @Setter
	private String click;
	
	public Master() {
		// TODO Auto-generated constructor stub
	}

	public Master(Integer id, String nome, String email, String senha, String contato, String click) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.contato = contato;
		this.click = click;
	}
	
	
	
}