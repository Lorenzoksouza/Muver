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
@Entity(name="instrumento")
public class Instrumento implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idinstrumento")
	@Getter @Setter
	public Integer idinstrumento;
	@Getter @Setter
	public String nome;
	@ManyToMany(cascade = CascadeType.ALL)
	@Getter @Setter
	@OrderColumn
	public Luthier[] luthier;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@Getter @Setter
	@OrderColumn
	public Musico[] musico;
	
	
	public Instrumento() {
	
	}
	
	public Instrumento(Integer idinstrumento, String nome) {
		super();
		this.idinstrumento = idinstrumento;
		this.nome = nome;
	}
}
*/