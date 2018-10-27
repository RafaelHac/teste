package io.spring.trihappy.alpha.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.trihappy.alpha.entity.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String>{
	List<Perfil> findByNomeLikeIgnoreCase(String nome);
	
	Perfil findByNome(String role_admin);
}
