package br.com.belaAgenda.model.rh;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import br.com.belaAgenda.model.glb.Pessoa;
import br.com.belaAgenda.model.svc.Servico;

@Entity
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = -8193525146089076187L;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="funcionario_servico", 
    		joinColumns={
    				@JoinColumn(name="funcionario_id")}, 
    		inverseJoinColumns={
    				@JoinColumn(name="servico_id")})
	private Set<Servico> servicos = new HashSet<Servico>();

	public Set<Servico> getServicos() {
		return servicos == null ? new HashSet<Servico>() : servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}
}
