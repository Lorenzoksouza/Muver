package com.senac.muver.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.PrimaryKeyJoinColumn;


import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="musico")
@PrimaryKeyJoinColumn(name="idmusico")
public class Musico extends Master implements Serializable {

	@Column(name = "idmusico", insertable = false, updatable = false)
	@Getter @Setter
	public Integer idmusico;
	/*
	@Getter @Setter
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "musico_instrumento", joinColumns = @JoinColumn(name = "id_musico"), inverseJoinColumns = @JoinColumn(name = "idinstrumento"))
	@OrderColumn
	public Instrumento[] instrumentos;
	*/
	@Getter @Setter
	public String instrumento;
	/*
	@Getter @Setter
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "musico_instrumento", joinColumns = @JoinColumn(name = "idmusico"), inverseJoinColumns = @JoinColumn(name = "instrumentoid"))
	@OrderColumn
	private EstiloMusical[] estiloMusical;
	*/
	@Getter @Setter
	public String estiloMusical;
	
	
	public Musico(String nome, String email, String senha, /*EstiloMusical[] estiloMusical , Instrumento[] instrumentos,*/String estiloMusical, String instrumento, byte[] fotoPerfil, String linkFb, String linkIg,
			String descricao, String tipoUsuario, double nota) {
		super(nome, email, senha, linkFb, linkIg, descricao, fotoPerfil, tipoUsuario, nota);
		this.estiloMusical = estiloMusical;
		this.instrumento = instrumento;
	}
	
	public Musico() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
