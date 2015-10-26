package br.com.belaAgenda.infra.base.model;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public abstract class ChaveValor extends EntityId {

	private static final long serialVersionUID = -4671557208350184076L;
	
	@NaturalId(mutable=false)
	protected Long codigo;
	
	@NotBlank(message="{chaveValor.nomeObrigatorio}")
	protected String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public Object clone() {
		ChaveValor clone = (ChaveValor) super.clone();
		clone.setCodigo(null);
		return clone;
	}
	
}
