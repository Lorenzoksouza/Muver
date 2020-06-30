package com.senac.muver.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="nota")
public class Nota implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idinstrumento")
	@Getter @Setter
	public Integer idNota;
	@Getter @Setter
	public String descricao;
	@Getter @Setter
	public Double valor;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Getter @Setter
	@OrderColumn
	public Luthier[] luthier;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Getter @Setter
	@OrderColumn
	public Musico[] musico;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Getter @Setter
	@OrderColumn
	public Estudio[] estudio;

	public Nota(Integer idNota, String descricao, Double valor) {
		super();
		this.idNota = idNota;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Nota() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
