package br.com.belaAgenda.model.sys;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.belaAgenda.infra.base.model.ChaveValor;
import br.com.belaAgenda.model.sys.types.NivelUsuario;
import br.com.belaAgenda.model.sys.types.UsuarioModelException;


@Entity
public class Usuario extends ChaveValor{

	private static final long serialVersionUID = -3327573295169448466L;
	
	@NotEmpty(message="{usuario.loginObrigatorio}")
	@Size(message="{usuario.tamanhoDoLogin}", min=6)
	private String login;
	
	@NotEmpty(message="{usuario.senhaObrigatoria}")
	@Size(message="{usuario.tamanhoDaSenha}", min=6)
	private String senha;
	
	@NotEmpty(message="{usuario.confirmacaoSenhaObrigatoria}")
	private String confirmacaoSenha;
	
	@NotEmpty(message="{usuario.nivelObrigatorio}")
	@Enumerated(EnumType.STRING) 
	private NivelUsuario nivel = NivelUsuario.EDITOR;
	
	
	public Usuario() {
		super();
	}
	
	@PrePersist
	@PreUpdate
	private void consistir(){
		consistirSenha();
	}
	
	@PostLoad
	private void postLoad(){
		this.senha = null;
		this.confirmacaoSenha = null;
	}
	
	private void consistirSenha(){
		if(!senha.equals(confirmacaoSenha)){
			throw new UsuarioModelException(getMessage("usuario.asSenhasNaoConferem"));
		}
	}

	public NivelUsuario getNivel() {
		return nivel;
	}
	public void setNivel(NivelUsuario nivel) {
		this.nivel = nivel;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}


	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	@Override
	public Object clone() {
		Usuario clone = (Usuario) super.clone();
		clone.setSenha(null);
		clone.setConfirmacaoSenha(null);
		return clone;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nivel != other.nivel)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	
}