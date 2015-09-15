package br.com.belaAgenda.model.glb;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import br.com.belaAgenda.infra.base.model.ChaveValor;

@MappedSuperclass
public abstract class Pessoa extends ChaveValor {

	private static final long serialVersionUID = -6993956148404259051L;
	
	@Embedded
	private Contato contato = new Contato();
	
	@Embedded
	private Endereco endereco = new Endereco();
	
	@Embedded
	private PessoaFisica pessoaFisica = new PessoaFisica();
	
	
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	
}
