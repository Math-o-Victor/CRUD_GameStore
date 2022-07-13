package br.org.generation.gamestore.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.generation.gamestore.models.UsuarioModel;
import br.org.generation.gamestore.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<UsuarioModel> usuario = userRepository.findByUsuario(userName);

		
		usuario.orElseThrow(() -> new UsernameNotFoundException("O usuario " + userName + "  não foi encontrado na base de dados."));

		return usuario.map(UserDetailsImpl::new).get();
	}
}