package io.spring.trihappy.alpha.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.trihappy.alpha.entity.Usuario;

@RestController
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getTexto() {
		return "finalmente, um teste";
	}
	
	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public Usuario getTexto(@PathVariable String nome) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		return usuario;
	}
}
