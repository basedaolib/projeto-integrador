package br.com.belaAgenda.model.glb;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.belaAgenda.infra.base.model.EntityBase;
import br.com.belaAgenda.model.glb.types.UnidadeFederacao;

@Embeddable
public class Endereco extends EntityBase{

	private static final long serialVersionUID = -6417625003670672983L;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String pontoReferencia;
	private String municipio;
	@Enumerated(EnumType.STRING) 
	private UnidadeFederacao uf;
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public UnidadeFederacao getUf() {
		return uf;
	}

	public void setUf(UnidadeFederacao uf) {
		this.uf = uf;
	}

}
