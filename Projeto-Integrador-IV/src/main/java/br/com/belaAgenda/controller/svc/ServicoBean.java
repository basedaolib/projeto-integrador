package br.com.belaAgenda.controller.svc;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.belaAgenda.business.svc.ServicoBusiness;
import br.com.belaAgenda.infra.base.controller.BaseBean;
import br.com.belaAgenda.infra.base.model.type.EstadoEntidade;
import br.com.belaAgenda.model.svc.Servico;
import br.com.generic.dao.SearchEntityListBuilder;

@Named
@ViewScoped
public class ServicoBean extends BaseBean {

	private static final long serialVersionUID = -5110313860331400925L;
	
	@Inject
	private ServicoBusiness servicoBusiness;
	
	private Servico servico = new Servico();
	private List<Servico> servicos = new ArrayList<>();
	private EstadoEntidade estado = EstadoEntidade.Ativo;
	private String pesquisa;
	
	public void adicionar(){
		servico = new Servico();
	}
	
	public void clonar(Servico servico){
		this.servico = (Servico) servico.clone();
	}
		
	public void salvar(){
		this.servico = servicoBusiness.save(this.servico);
		
		addMessage(null, FacesMessage.SEVERITY_INFO ,getMessage("servicoBean.servicoSalvo"), null);
		servicos.add(servico);
	}
	
	public void inativar(){
		this.servico = servicoBusiness.inativar(this.servico);
		addMessage(null, FacesMessage.SEVERITY_INFO ,getMessage("servicoBean.servicoInativado"), null);
	}
	
	public void pesquisar(){
		String codigoS;
		Long codigo;
		SearchEntityListBuilder<Servico> servicoWhere = servicoBusiness.listEntities();
		
		try{
			if(pesquisa!= null && pesquisa.startsWith(",")){
					codigoS = pesquisa.replace(",", "");
					codigo = Long.parseLong(codigoS);
					servicos = servicoWhere.sortBy("nome")
							.equal("codigo", codigo)
							.equal("estado", estado)
							.list();
					return;
			}
			
		}finally{}
		servicos = servicoWhere.sortBy("nome")
				.like("nome", pesquisa + "%")
				.equal("estado", estado)
				.list();
	}
	
	public void editar(Servico servico){
		this.servico = servico;
	}
	
	public String obterTituloCadastro(){
		if(servico == null || (servico != null && servico.getId() == 0)){
			return getMessage("global.novo");
		}else{
			return servico.getCodigo().toString() + " - " +servico.getNome();
		}
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	
	
	public EstadoEntidade getEstado() {
		return estado;
	}

	public void setEstado(EstadoEntidade estado) {
		this.estado = estado;
	}
	
	public boolean podeInativar(){
		return servico.getId() == 0? true : false;
	}
	
	public EstadoEntidade[] estadosEntidade(){
		return EstadoEntidade.values();
	}
			
}

	
		

