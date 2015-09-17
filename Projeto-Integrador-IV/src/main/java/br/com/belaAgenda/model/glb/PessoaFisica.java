package br.com.belaAgenda.model.glb;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.com.belaAgenda.infra.base.model.EntityBase;
import br.com.belaAgenda.infra.util.LocalDatePersistenceConverter;
import br.com.belaAgenda.model.glb.exceptions.PessoaFisicaException;
import br.com.belaAgenda.model.glb.types.EstadoCivil;
import br.com.belaAgenda.model.glb.types.OrgaoExpedidorRG;
import br.com.belaAgenda.model.glb.types.Sexo;
import br.com.belaAgenda.model.glb.types.UnidadeFederacao;

@Embeddable
public class PessoaFisica extends EntityBase{

	private static final long serialVersionUID = 394359038026985519L;
	
	@CPF(message = "{pessoaFisica.cpfInvalido}")
	private String cpf;
	
	@NotEmpty(message = "{pessoaFisica.rgObrigatorio}")
	private String rg;
	
	@NotNull(message= "{pessoaFisica.orgaoExpedidorObrigatorio}")
	@Enumerated(EnumType.STRING) 
	private OrgaoExpedidorRG orgaoExpedidor;
	
	@NotNull(message="{pessoaFisica.ufObrigatoria}")
	@Enumerated(EnumType.STRING) 
	private UnidadeFederacao ufOrgaoExpedidor;
	
	@NotNull(message="{pessoaFisica.dataNascimentoObrigatorio}")
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate dataNascimento;
	
	private String pai;
	
	private String mae;
	
	@NotNull(message="{pessoaFisica.sexoObrigatorio}")
	@Enumerated(EnumType.STRING) 
	private Sexo sexo = Sexo.Masculino;
	
	@NotNull(message="{pessoaFisica.estadoCivilObrigatorio}")
	@Enumerated(EnumType.STRING) 
	private EstadoCivil estadoCivil = EstadoCivil.Solteiro;
	
	private String conjuge;
	
	@PrePersist
	@PreUpdate
	private void consistir(){
		verificarConjuge();
	}
	
	private void verificarConjuge(){
		if(estadoCivil.contemConjugue()){
			throw new PessoaFisicaException(getMessage("pessoaFisiaca.conjugueObrigatorio"));
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public OrgaoExpedidorRG getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(OrgaoExpedidorRG orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public UnidadeFederacao getUfOrgaoExpedidor() {
		return ufOrgaoExpedidor;
	}

	public void setUfOrgaoExpedidor(UnidadeFederacao ufOrgaoExpedidor) {
		this.ufOrgaoExpedidor = ufOrgaoExpedidor;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getConjuge() {
		return conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}
	
	public Boolean getFeminino() {
		return getSexo() != null && getSexo().equals(Sexo.Feminino);
	}
	
	public Boolean getMasculino() {
		return getSexo() != null && getSexo().equals(Sexo.Masculino);
	}
	
	public Boolean getSolteiro() {
		return getEstadoCivil() != null && getEstadoCivil().equals(EstadoCivil.Solteiro);
	}
	
	public Boolean getCasado() {
		return getEstadoCivil() != null && getEstadoCivil().equals(EstadoCivil.Casado);
	}
	
	public Boolean getUniaoEstavel() {
		return getEstadoCivil() != null && getEstadoCivil().equals(EstadoCivil.UniaoEstavel);
	}
	
	public Boolean getDesquitado() {
		return getEstadoCivil() != null && getEstadoCivil().equals(EstadoCivil.Desquitado);
	}
	
	public Boolean getViuvo() {
		return getEstadoCivil() != null && getEstadoCivil().equals(EstadoCivil.Viuvo);
	}
	
}
