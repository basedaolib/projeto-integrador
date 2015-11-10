package br.com.belaAgenda.infra.base.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.belaAgenda.infra.base.model.type.EstadoEntidade;


@MappedSuperclass
public abstract class EntityId extends EntityBase {
	

	private static final long serialVersionUID = -1842377326317111427L;
	@Id
	@GeneratedValue
	protected long id;
	
	@Enumerated(EnumType.STRING) 
	protected EstadoEntidade estado;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}       
	
	public EstadoEntidade getEstado() {
		return estado;
	}

	public void setEstado(EstadoEntidade estado) {
		this.estado = estado;
	}

	@Override
	public Object clone() {
		EntityId clone = (EntityId) super.clone();
		clone.setId(0);
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		EntityId other = (EntityId) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
