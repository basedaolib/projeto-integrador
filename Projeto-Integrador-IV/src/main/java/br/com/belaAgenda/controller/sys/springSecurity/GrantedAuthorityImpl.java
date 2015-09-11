package br.com.belaAgenda.controller.sys.springSecurity;

import org.springframework.security.core.GrantedAuthority;

import br.com.belaAgenda.model.sys.Usuario;

public class GrantedAuthorityImpl implements GrantedAuthority {

	private static final long serialVersionUID = 1120812856415037070L;

	private Usuario usuario;
	
	public GrantedAuthorityImpl(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String getAuthority() {
		return usuario.getNivel().toString();
	}

}
