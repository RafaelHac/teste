package io.spring.trihappy.alpha.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.trihappy.alpha.entity.Usuario;
import io.spring.trihappy.alpha.repository.UsuarioRepository;
import io.spring.trihappy.alpha.service.UsuarioService;

@RestController
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public List<Usuario> listar(){
		return this.usuarioService.listaUsuario();
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public Usuario salvar(@RequestBody Usuario usuario){
		return this.usuarioService.salvarUsuario(usuario);
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT)
	public Usuario editar(@RequestBody Usuario usuario){
		return this.usuarioService.salvarUsuario(usuario);
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable String id){
		this.usuarioService.deletarUsuario(id);
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public Optional<Usuario> consultar(@PathVariable String id){
		return this.usuarioService.getById(id);
	}
	
	@RequestMapping(value = "/usuario/{page}/{count}", method = RequestMethod.GET)
	public Page<Usuario> listaPaginada(@PathVariable int page, @PathVariable int count){
		return this.usuarioService.listaPaginada(count, page);
	}
	
	@RequestMapping(value = "/usuario/{nome}/nome", method = RequestMethod.GET)
	public List<Usuario> buscarPorNome(@PathVariable String nome){
		return this.usuarioService.buscaPorNome(nome);
	}
	
	@RequestMapping(value = "/usuario/logado", method = RequestMethod.GET)
	public Usuario currentUsername(Principal principal){
		Usuario usuario = this.usuarioRepository.findByEmail(principal.getName());
        usuario.setSenha("");
        return usuario;
	}
	
	
}
