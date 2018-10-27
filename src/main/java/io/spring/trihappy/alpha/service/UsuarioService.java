package io.spring.trihappy.alpha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.spring.trihappy.alpha.entity.Usuario;
import io.spring.trihappy.alpha.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> listaUsuario(){
		return usuarioRepository.findAll();
	}
	
	public Page<Usuario> listaPaginada(int count, int page){
		Pageable pages = PageRequest.of(page, count);
		return usuarioRepository.findAll(pages);
	}
	
	public List<Usuario> buscaPorNome(String nome) {
		return usuarioRepository.findByNomeLikeIgnoreCase(nome);
	}
	
	public Usuario salvarUsuario(Usuario usuarioAdd) {
		return usuarioRepository.save(usuarioAdd);
    }
	
	public void deletarUsuario(String id) {
		usuarioRepository.deleteById(id);
	}
	
	public Optional<Usuario> getById(String id) {
		return usuarioRepository.findById(id);
	}

}
