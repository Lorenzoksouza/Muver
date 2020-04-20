package com.senac.muver.model;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="musico")
public class Musico extends Master implements Serializable {

	//injetando os getters e setters via lombok
	@Getter @Setter
	private String estiloMusical;
	@Getter @Setter
	private int idade;
	@Getter @Setter
	private String generoMusical;
	
	public Musico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Musico(String estiloMusical, int idade, String generoMusical) {
		super();
		this.estiloMusical = estiloMusical;
		this.idade = idade;
		this.generoMusical = generoMusical;
	}

	public Musico(Integer id, String nome, String email, String senha, String contato, String click) {
		super(id, nome, email, senha, contato, click);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
