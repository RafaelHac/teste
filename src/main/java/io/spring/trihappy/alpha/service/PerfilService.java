package io.spring.trihappy.alpha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.spring.trihappy.alpha.entity.Perfil;
import io.spring.trihappy.alpha.repository.PerfilRepository;

@Service
public class PerfilService {
	@Autowired
	PerfilRepository perfilRepository;
	
	public List<Perfil> listarAll(){
		return perfilRepository.findAll();
	}
	
	public Page<Perfil> listaPaginada(int count, int page){
		Pageable pages = PageRequest.of(page, count);
		return perfilRepository.findAll(pages);
	}
	
	public List<Perfil> buscaPorNome(String nome) {
		return perfilRepository.findByNomeLikeIgnoreCase(nome);
	}
	
	public Perfil salvar(Perfil perfilAdd) {
		return perfilRepository.save(perfilAdd);
    }
	
	public void deletar(String id) {
		perfilRepository.deleteById(id);
	}
	
	public Optional<Perfil> getById(String id) {
		return perfilRepository.findById(id);
	}
}
