package com.senac.muver.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senac.muver.model.Musico;

public interface MusicoRepository extends CrudRepository<Musico, Integer> {

	@Query(value = "SELECT * FROM Master m INNER JOIN Musico mu WHERE m.idmaster = mu.idmusico AND m.nome = :nome and tipo_usuario = 'musico'", nativeQuery = true)
	Musico perfilPorNomeMusico(String nome);

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Master m SET m.nome= :nome, m.email= :email, m.senha= :senhaCriptografada, "
			+ "m.foto_Perfil= :fotoPerfilByte, m.link_fb= :linkFb, m.link_ig= :linkIg, m.descricao= :descricao WHERE m.nome = :nome ", nativeQuery = true)
	void alterar(String nome, String email, String senhaCriptografada, byte[] fotoPerfilByte, String linkFb,
			String linkIg, String descricao);

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE musico m SET m.instrumento= :instrumentos, m.estilo_musical= :estilosMusicais where l.nome = :nome", nativeQuery = true)
	void alterarMusico(String instrumentos, String estilosMusicais, String nome);
	
	
	
}
