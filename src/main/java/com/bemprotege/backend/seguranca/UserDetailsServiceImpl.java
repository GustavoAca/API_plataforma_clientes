package com.bemprotege.backend.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bemprotege.backend.domain.usuario.UsuarioModel;
import com.bemprotege.backend.domain.usuario.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UsuarioModel> user  = usuarioRepository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found. "));
		
		
		return user.map(UserDetailsImpl::new).get();
	}
}
