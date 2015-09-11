package br.com.belaAgenda.controller.sys.springSecurity;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.belaAgenda.business.sys.UsuarioBusiness;
import br.com.belaAgenda.infra.resourceBundle.MessageProvider;
import br.com.belaAgenda.model.sys.Usuario;

public class UserServiceImpl implements UserService {

	@Inject
	private UsuarioBusiness usuarioBusiness;
	
	@Inject
	protected MessageProvider messageProvider;
	
	public String getMessage(String key){
		return messageProvider.getValue(key);
	}
	
	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		Usuario usuario = usuarioBusiness.findEntityForProperties("login", login);
		if(usuario == null){
			throw new UsernameNotFoundException(getMessage("userService.usuarioNaoEncontrado"));
		}
		return new UserDetailsImpl(usuario);
	}

}
