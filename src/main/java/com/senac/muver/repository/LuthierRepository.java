package com.senac.muver.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senac.muver.model.Luthier;

public interface LuthierRepository extends CrudRepository<Luthier, Integer> {

	@Query(value = "SELECT * FROM Master m INNER JOIN Luthier l WHERE m.idmaster = l.idluthier AND m.nome = :nome and tipo_usuario = 'luthier'", nativeQuery = true)
	Luthier perfilPorNomeLuthier(String nome);
	
	@Query(value = "SELECT * FROM Master m INNER JOIN Luthier l WHERE m.idmaster = l.idluthier", nativeQuery = true)
	ArrayList<Luthier> listaLuthiers();

	@Transactional
	@Modifying
	@Query(value = "UPDATE Master m SET m.nome= :nome, m.email= :email, "
			+ "m.foto_Perfil= :fotoPerfilByte, m.link_fb= :linkFb, m.link_ig= :linkIg, m.descricao= :descricao WHERE m.nome = :nome ", nativeQuery = true)
	void alterar(String nome, String email, byte[] fotoPerfilByte, String linkFb, String linkIg, String descricao);

	@Transactional
	@Modifying
	@Query("UPDATE luthier l SET l.localizacao= :localizacao, l.disponibilidade= :disponibilidade, l.instrumento= :instrumentos where l.idluthier = :id")
	void alterarLuthier(String localizacao,String disponibilidade, String instrumentos, int id);

	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM Master m WHERE m.nome = :nome")
	void excluir(String nome);

}
