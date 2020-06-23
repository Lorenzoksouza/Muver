package com.senac.muver.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senac.muver.model.Master;

public interface MasterRepository extends CrudRepository<Master, Integer> {

	@Query("SELECT m FROM Master m WHERE m.email = ?1 and m.senha = ?2")
	Master existeUsuario(String email, String senha);
	
	
	@Query("SELECT m FROM Master m")
	Master listarUsuario();

	@Query("SELECT m FROM Master m where m.tipoUsuario = 'estudio' or m.tipoUsuario = 'luthier'")
	ArrayList<Master> listaUsuariosSemMusico();

	@Query("SELECT m FROM Master m where m.tipoUsuario = 'estudio'")
	ArrayList<Master> listaEstudios();

	@Query("SELECT m FROM Master m where m.tipoUsuario = 'luthier'")
	ArrayList<Master> listaLuthiers();
	
	@Query("SELECT m FROM Master m where m.nome = :nome")
	Master PerfilNome(String nome);
	
	
	
	//native query
	/*
	@Query(value = "SELECT * FROM tarefas t WHERE t.status = ?1 AND t.operador IS NULL ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Tarefas findRandomByStatus(Integer status); */
	
	//jpa
	/*
	 * @Query("SELECT p FROM SessaoSiteColaborador p WHERE p.sessionId = ?1 ORDER BY id DESC")
    SessaoSiteColaborador findSessionId(String sessionId);
	 */
}
