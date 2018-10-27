package io.spring.trihappy.alpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.spring.trihappy.alpha.config.MyUserDetails;
import io.spring.trihappy.alpha.entity.Usuario;
import io.spring.trihappy.alpha.repository.UsuarioRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário ou senha inválidos.");
		}
		
		return new MyUserDetails(usuario);
	}
	
}
