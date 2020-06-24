package com.senac.muver.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senac.muver.model.Estudio;

public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

	@Query(value = "SELECT * FROM Master m INNER JOIN Estudio e WHERE m.idmaster = e.idestudio AND m.nome = ?1", nativeQuery = true)
	Estudio perfilPorNomeEstudio(String nome);
	
	@Query(value = "SELECT * FROM Master m INNER JOIN Estudio e WHERE m.idmaster = e.idestudio AND m.tipo_usuario = 'estudio'", nativeQuery = true)
	ArrayList<Estudio> listaEstudios();
}
