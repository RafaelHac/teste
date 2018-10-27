package io.spring.trihappy.alpha.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.trihappy.alpha.entity.Perfil;
import io.spring.trihappy.alpha.service.PerfilService;

@RestController
public class PerfilController {
	@Autowired
	PerfilService perfilService;
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public List<Perfil> listarAll(){
		return this.perfilService.listarAll();
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public Optional<Perfil> getById(@PathVariable String id){
		return this.perfilService.getById(id);
	}
	
	@RequestMapping(value = "/perfil/{page}/{count}", method = RequestMethod.GET)
	public Page<Perfil> listar(@PathVariable int page, @PathVariable int count){
		return this.perfilService.listaPaginada(count, page);
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.POST)
	public Perfil salvar(@RequestBody Perfil perfil){
		return this.perfilService.salvar(perfil);
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.PUT)
	public Perfil editar(@RequestBody Perfil perfil){
		return this.perfilService.salvar(perfil);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
	public void deletarUsuario(@PathVariable String id){
		this.perfilService.deletar(id);
	}
}
