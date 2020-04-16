package com.senac.ads.experts.repository;

import org.springframework.data.repository.CrudRepository;

import com.senac.ads.experts.model.Convidados;

/**
 * interface entre o serviço e a base de dados
 * esta é responsável por implementar os métodos base do jpa utilizando o crudrepository
 * @author bruno.rafael
 *
 */
public interface ConvidadosRepository extends CrudRepository<Convidados, Integer> {
	
	

}
