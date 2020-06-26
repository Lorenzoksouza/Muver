package com.senac.muver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	//@OneToMany(mappedBy="luthier")
	@OneToMany
	@OrderColumn(name="list_index")
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
