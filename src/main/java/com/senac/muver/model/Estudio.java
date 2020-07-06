package com.senac.muver.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
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
	private String disponibilidade;
	
	/*
	 * @Getter @Setter
	 * 
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "estudio_nota", joinColumns = @JoinColumn(name =
	 * "idestudio"), inverseJoinColumns = @JoinColumn(name = "idnota"))
	 * 
	 * @OrderColumn private Nota[] nota;
	 */
	public Estudio(String nome, String email, String senha, String localizacao, byte[] fotoPerfil, String linkFb, String linkIg,
			String descricao, String tipoUsuario, String disponibilidade, double nota) {
		super(nome, email, senha, linkFb, linkIg, descricao, fotoPerfil, tipoUsuario, nota);
		this.localizacao = localizacao;
		this.disponibilidade = disponibilidade;
	}
	
	public Estudio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}