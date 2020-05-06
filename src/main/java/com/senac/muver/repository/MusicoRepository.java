package com.senac.muver.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.senac.muver.model.Master;
import com.senac.muver.model.Musico;

public interface MusicoRepository extends CrudRepository<Musico, Integer> {

}
