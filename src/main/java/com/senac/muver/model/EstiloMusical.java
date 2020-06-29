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
/*
@SuppressWarnings("serial")
@Entity(name="estilo_musical")
public class EstiloMusical implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idestilomusical")
	@Getter @Setter
	public Integer idestiloMusical;
	@Getter @Setter
	public String nome;
	@ManyToMany(cascade = CascadeType.ALL)
	@Getter @Setter
	@OrderColumn
	public Musico[] musico;
	
	
	
	public EstiloMusical() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EstiloMusical(Integer idestiloMusical, String nome) {
		super();
		this.idestiloMusical = idestiloMusical;
		this.nome = nome;
	}
}
*/