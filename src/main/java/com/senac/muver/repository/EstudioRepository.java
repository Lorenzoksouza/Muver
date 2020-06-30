package com.senac.muver.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senac.muver.model.Estudio;
import com.senac.muver.model.Master;

public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

	@Query(value = "SELECT * FROM Master m INNER JOIN Estudio e WHERE m.idmaster = e.idestudio AND m.nome = ?1", nativeQuery = true)
	Estudio perfilPorNomeEstudio(String nome);
	
	@Query(value = "SELECT * FROM Master m INNER JOIN Estudio e WHERE m.idmaster = e.idestudio AND m.tipo_usuario = 'estudio'", nativeQuery = true)
	ArrayList<Estudio> listaEstudios();

	@Transactional
	@Modifying
	@Query(value = "UPDATE Master m SET m.nome= :nome, m.email= :email, m.senha= :senhaCriptografada, "
			+ "m.foto_Perfil= :fotoPerfilByte, m.link_fb= :linkFb, m.link_ig= :linkIg, m.descricao= :descricao WHERE m.nome = :nome ", nativeQuery = true)
	void alterar(String nome, String email, String senhaCriptografada, byte[] fotoPerfilByte, String linkFb, String linkIg, String descricao);

	@Transactional
	@Modifying
	@Query("UPDATE estudio e SET e.localizacao= :localizacao where e.nome = :nome")
	void alterarEstudio(String localizacao, String nome);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM Master m WHERE m.nome = :nome")
	void excluir(String nome);
	
	
}
