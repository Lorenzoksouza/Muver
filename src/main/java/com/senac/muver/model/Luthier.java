package com.senac.muver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="musico")
public class Luthier extends Master implements Serializable {

	//injetando os getters e setters via lombok
	@Getter @Setter
	private String[] instrumentos;
	@Getter @Setter
	private String localizacao;
	@Getter @Setter
	private Date[] disponibilidade;
	
	public Luthier(String[] instrumentos, String localizacao, Date[] disponibilidade) {
		super();
		this.instrumentos = instrumentos;
		this.localizacao = localizacao;
		this.disponibilidade = disponibilidade;
	}

	public Luthier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Luthier(Integer id, String nome, String email, String senha, String contato, String click) {
		super(id, nome, email, senha, contato, click);
		// TODO Auto-generated constructor stub
	}
	
}
