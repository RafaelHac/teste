package io.spring.trihappy.alpha.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.trihappy.alpha.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	List<Usuario> findByNomeLikeIgnoreCase(String nome);
	
	Usuario findByEmail(String username);
}
