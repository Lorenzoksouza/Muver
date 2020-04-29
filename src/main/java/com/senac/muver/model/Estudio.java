package com.senac.muver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="estudio")
public class Estudio extends Master implements Serializable {

	//injetando os getters e setters via lombok
	@Getter @Setter
	private String[] instrumentos;
	@Getter @Setter
	private String localizacao;
	@Getter @Setter
	private Date[] disponibilidade;
	
	public Estudio(String[] instrumentos, String localizacao, Date[] disponibilidade) {
		super();
		this.instrumentos = instrumentos;
		this.localizacao = localizacao;
		this.disponibilidade = disponibilidade;
	}
	public Estudio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Estudio(Integer id, String nome, String email, String senha, int telefone) {
		super(id, nome, email, senha, telefone);
		// TODO Auto-generated constructor stub
	}
	
	
	
}