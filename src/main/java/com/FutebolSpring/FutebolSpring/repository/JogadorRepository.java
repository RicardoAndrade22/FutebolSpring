package com.FutebolSpring.FutebolSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.FutebolSpring.FutebolSpring.models.Jogador;


public interface JogadorRepository extends CrudRepository<Jogador, Long>{
	Jogador findById(long id);
	
	
	// para a busca
		@Query(value = "select u from Jogador u where u.nome like %?1%")
		List<Jogador> findByNomes(String nome);


		
}
