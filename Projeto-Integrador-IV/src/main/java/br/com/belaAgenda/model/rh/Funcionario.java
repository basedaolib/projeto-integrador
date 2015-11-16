package br.com.belaAgenda.model.rh;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	private List<Servico> servicos = new ArrayList<>();

	public List<Servico> getServicos() {
		return servicos = servicos == null ? new ArrayList<>() : servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
}
