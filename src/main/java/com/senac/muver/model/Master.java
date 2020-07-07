package com.senac.muver.model;

import java.io.Serializable;
import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome","email"})})
public /*abstract*/ class Master implements Serializable, UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmaster")
	@Getter @Setter
	public Integer idmaster;
	@Getter @Setter
	//mudei pra public pra conseguir aparecer na tela, investigar isso
	@Size(min=2, max=30)
	@Column(name = "nome", unique = true)
	public String nome;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String senha;

	@Getter @Setter
	public String linkFb;
	@Getter @Setter
	public String linkIg;
	@Getter @Setter
	//mudei pra public pra conseguir aparecer na tela, investigar isso
	public String descricao;
	
	@Getter @Setter
	//mudei pra public pra conseguir aparecer na tela, investigar isso
	
	public byte[] fotoPerfil;
	
	//public byte[] fotoPerfil;
	@Getter @Setter
	private String tipoUsuario;
	
	@Getter @Setter
	public double nota;
	
	@Getter @Setter
	public int numeroAvaliacoes;
	
	@Getter @Setter
	public double notaSoma;
	
	public Master() {
		// TODO Auto-generated constructor stub
	}

	public Master(String nome, String email, String senha, String linkFb, String linkIg, String descricao,
			byte[] fotoPerfil, String tipoUsuario, double nota, int numeroAvaliacoes, double notaSoma) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.linkFb = linkFb;
		this.linkIg = linkIg;
		this.descricao = descricao;
		this.fotoPerfil = fotoPerfil;
		this.tipoUsuario = tipoUsuario;
		this.nota = nota;
		this.numeroAvaliacoes = numeroAvaliacoes;
		this.notaSoma = notaSoma;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
		
}