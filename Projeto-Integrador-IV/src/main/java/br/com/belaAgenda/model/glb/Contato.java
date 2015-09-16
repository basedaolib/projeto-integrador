package br.com.belaAgenda.model.glb;

import javax.persistence.Embeddable;

import br.com.belaAgenda.infra.base.model.EntityBase;

@Embeddable
public class Contato extends EntityBase{

	private static final long serialVersionUID = 4110936356127159119L;
	
	private String email;
	private String clular;
	private String telefoneFixo;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClular() {
		return clular;
	}
	public void setClular(String clular) {
		this.clular = clular;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clular == null) ? 0 : clular.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((telefoneFixo == null) ? 0 : telefoneFixo.hashCode());
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
		Contato other = (Contato) obj;
		if (clular == null) {
			if (other.clular != null)
				return false;
		} else if (!clular.equals(other.clular))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (telefoneFixo == null) {
			if (other.telefoneFixo != null)
				return false;
		} else if (!telefoneFixo.equals(other.telefoneFixo))
			return false;
		return true;
	}
	
	

}
