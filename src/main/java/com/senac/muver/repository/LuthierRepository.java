package com.senac.muver.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senac.muver.model.Instrumento;
import com.senac.muver.model.Luthier;

public interface LuthierRepository extends CrudRepository<Luthier, Integer> {

	@Query(value = "SELECT * FROM Master m INNER JOIN Luthier l WHERE m.idmaster = l.idluthier AND m.nome = :nome and tipo_usuario = 'luthier'", nativeQuery = true)
	Luthier perfilPorNomeLuthier(String nome);
	
	@Query(value = "SELECT * FROM Master m INNER JOIN Luthier l WHERE m.idmaster = l.idluthier", nativeQuery = true)
	ArrayList<Luthier> listaLuthiers();

}
