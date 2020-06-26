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
	@Getter @Setter
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "musico_instrumento", joinColumns = @JoinColumn(name = "idmusico"), inverseJoinColumns = @JoinColumn(name = "instrumentoid"))
	@OrderColumn
	public Instrumento[] instrumentos;
	@Getter @Setter
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "musico_instrumento", joinColumns = @JoinColumn(name = "idmusico"), inverseJoinColumns = @JoinColumn(name = "instrumentoid"))
	@OrderColumn
	private EstiloMusical[] estiloMusical;
	
	
	public Musico(String nome, String email, String senha, EstiloMusical[] estiloMusical, Instrumento[] instrumentos, byte[] fotoPerfil, String linkFb, String linkIg,
			String descricao, String tipoUsuario) {
		super(nome, email, senha, linkFb, linkIg, descricao, fotoPerfil, tipoUsuario);
		this.estiloMusical = estiloMusical;
		this.instrumentos = instrumentos;
	}
	
	public Musico() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
