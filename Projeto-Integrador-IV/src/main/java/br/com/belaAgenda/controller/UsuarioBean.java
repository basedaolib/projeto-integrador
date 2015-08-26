package br.com.belaAgenda.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.belaAgenda.business.UsuarioBusiness;
import br.com.belaAgenda.model.sys.Usuario;

@Named
@RequestScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = -1141653908595714524L;

	@Inject
	private UsuarioBusiness usuarioBusiness;
	
	private Usuario usuario = new Usuario();
	
	
	public String salvar(){
		if(usuario.getId() == 0)
			usuarioBusiness.insert(usuario);
		else
			usuarioBusiness.update(usuario);
		
		return "usuarioShow";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
