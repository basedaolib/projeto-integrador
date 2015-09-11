package br.com.belaAgenda.controller.sys;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.belaAgenda.business.sys.UsuarioBusiness;
import br.com.belaAgenda.infra.base.controller.BaseBean;
import br.com.belaAgenda.model.sys.Usuario;
import br.com.belaAgenda.model.sys.types.NivelUsuario;

@Named
@ViewScoped
public class UsuarioBean extends BaseBean implements Serializable{

	private static final long serialVersionUID = -1141653908595714524L;

	@Inject
	private UsuarioBusiness usuarioBusiness;
	
	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarios;
	
	
	private String pesquisa;
	
	public void adicionar(){
		usuario = new Usuario();
	}
	
	public void clonar(Usuario usuario){
		this.usuario = (Usuario) usuario.clone();
	}
	
	public void salvar(){
		this.usuario = usuarioBusiness.save(this.usuario);
		
		addMessage(null, FacesMessage.SEVERITY_INFO ,getMessage("usuarioBean.usuarioSalvo"), null);
		usuarios.add(usuario);
	}
	
	public void pesquisar(){
		String codigoS;
		Long codigo;
		if(pesquisa!= null && pesquisa.startsWith(",")){
			try{
				codigoS = pesquisa.replace(",", "");
				codigo = Long.parseLong(codigoS);
				usuarios = usuarioBusiness.findEntitiesForProperties(0, 0, "codigo", "codigo", codigo);
				return;
			}catch(Exception e){}
		}
		usuarios = usuarioBusiness.findEntitiesForProperties(0, 0, "nome", "nome+", pesquisa + "%");
	}
	
	public void editar(Usuario usuario){
		this.usuario = usuario;
	}
	
	public String obterTituloCadastro(){
		if(usuario == null || (usuario != null && usuario.getId() == 0)){
			return getMessage("global.novo");
		}else{
			return usuario.getCodigo().toString() + " - " +usuario.getNome();
		}
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public NivelUsuario[] getNiveisUsuario(){
		return NivelUsuario.values();
	}
	
}
