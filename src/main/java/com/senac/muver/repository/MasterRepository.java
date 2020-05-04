package com.senac.muver.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senac.muver.model.Master;

public interface MasterRepository extends CrudRepository<Master, Integer> {

	@Query("SELECT m FROM Master as m WHERE m.email = ?1 and m.senha = ?2")
	Master existeUsuario(String email, String senha);
}
