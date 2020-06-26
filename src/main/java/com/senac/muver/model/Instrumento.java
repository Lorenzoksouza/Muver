package com.senac.muver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(name="instrumento")
public class Instrumento implements Serializable{

	@ManyToOne
    @JoinColumn(name="idluthier", nullable=false, insertable = false, updatable = false)
    private Luthier luthier;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	public Integer idinstrumento;
	@Getter @Setter
	public String nome;
	//@Getter @Setter
	//public String intrumento_order;
	
	public Instrumento() {
	
	}
	
	public Instrumento(Integer idinstrumento, String nome) {
		super();
		this.idinstrumento = idinstrumento;
		this.nome = nome;
	}
}
