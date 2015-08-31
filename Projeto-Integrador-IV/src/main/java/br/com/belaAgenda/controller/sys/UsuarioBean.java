package br.com.belaAgenda.controller.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.belaAgenda.business.sys.UsuarioBusiness;
import br.com.belaAgenda.infra.base.controller.BaseBean;
import br.com.belaAgenda.model.sys.Usuario;

@Named
@ViewScoped
public class UsuarioBean extends BaseBean implements Serializable{

	private static final long serialVersionUID = -1141653908595714524L;

	@Inject
	private UsuarioBusiness usuarioBusiness;
	
	private Usuario usuario;
	
	private List<Usuario> usuarios;
	
	private List<Usuario> usuariosEdit = new ArrayList<>();
	
	public void adicionar(){
		usuariosEdit.add(new Usuario());
	}
	
	public void salvar(Usuario usuario){
		usuario = usuarioBusiness.save(usuario);
		
		addMessage(null, FacesMessage.SEVERITY_INFO ,getMessage("usuarioBean.usuarioSalvo"), null);
		
	}
	
	public void editar(Usuario usuario){
		if(usuario != null)
			usuariosEdit.add(usuario);
	}
	
	public void onTabClose(Usuario usuario){
		if(usuario != null)
			usuariosEdit.remove(usuario);
	}
	
	public String obterTituloTab(Usuario usuario){
		if(usuario.getId() == 0){
			return getMessage("global.novo");
		}else{
			return usuario.getCodigo().toString();
		}
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		if(usuarios == null){
			usuarios = usuarioBusiness.list(0, 0, "nome");
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosEdit() {
		return usuariosEdit;
	}

	public void setUsuariosEdit(List<Usuario> usuariosEdit) {
		this.usuariosEdit = usuariosEdit;
	}
	
	
	
}
