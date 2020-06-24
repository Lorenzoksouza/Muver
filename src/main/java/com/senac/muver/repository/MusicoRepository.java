package com.senac.muver.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senac.muver.model.Musico;

public interface MusicoRepository extends CrudRepository<Musico, Integer> {

	@Query(value = "SELECT * FROM Master m INNER JOIN Musico mu WHERE m.idmaster = mu.idmusico AND m.nome = :nome and tipo_usuario = 'musico'", nativeQuery = true)
	Musico perfilPorNomeMusico(String nome);
	
}
