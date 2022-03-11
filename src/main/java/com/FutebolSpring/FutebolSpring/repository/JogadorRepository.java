package com.FutebolSpring.FutebolSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.FutebolSpring.FutebolSpring.models.Jogador;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, String>{
	Jogador findById(long id);
	List<Jogador> findByNome(String nome);
	
}
