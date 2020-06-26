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
@Entity(name="luthier")
@PrimaryKeyJoinColumn(name="idluthier")
public class Luthier extends Master implements Serializable {
	
	@Column(name = "idluthier", insertable = false, updatable = false)
	@Getter @Setter
	public Integer idluthier;
	@Getter @Setter
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "luthier_instrumento", joinColumns = @JoinColumn(name = "idluthier"), inverseJoinColumns = @JoinColumn(name = "idinstrumento"))
	@OrderColumn
	private Instrumento[] instrumentos;
	@Getter @Setter
	private String localizacao;
	
	public Luthier(String nome, String email, String senha, Instrumento[] instrumentos, String localizacao, byte[] fotoPerfil, String linkFb, String linkIg,
			String descricao, String tipoUsuario) {
		super(nome, email, senha, linkFb, linkIg, descricao, fotoPerfil, tipoUsuario);
		this.instrumentos = instrumentos;
		this.localizacao = localizacao;
	}

	public Luthier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
