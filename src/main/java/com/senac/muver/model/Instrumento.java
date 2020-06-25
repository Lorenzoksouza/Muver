package com.senac.muver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="instrumento")
@PrimaryKeyJoinColumn(name="idinstrumento")
public class Instrumento implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idinstrumento")
	@Getter @Setter
	public Integer idInstrumento;
	@Getter @Setter
	public String nome;
	
	public Instrumento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Instrumento(Integer idInstrumento, String nome) {
		super();
		this.idInstrumento = idInstrumento;
		this.nome = nome;
	}
}
