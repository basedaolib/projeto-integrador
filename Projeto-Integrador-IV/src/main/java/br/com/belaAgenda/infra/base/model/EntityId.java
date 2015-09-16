package br.com.belaAgenda.infra.base.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class EntityId extends EntityBase {
	

	private static final long serialVersionUID = -1842377326317111427L;
	@Id
	@GeneratedValue
	protected long id;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public Object clone() {
		EntityId clone = (EntityId) super.clone();
		clone.setId(0);
		return clone;
	}
	
}
