package com.senac.muver.repository;

import org.springframework.data.repository.CrudRepository;

import com.senac.muver.model.Master;

/**
 * interface entre o serviço e a base de dados
 * esta é responsável por implementar os métodos base do jpa utilizando o crudrepository
 * @author bruno.rafael
 *
 */
public interface MasterRepository extends CrudRepository<Master, Integer> {
	
	

}
