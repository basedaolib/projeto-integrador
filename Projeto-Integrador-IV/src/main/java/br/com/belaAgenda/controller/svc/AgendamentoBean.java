package br.com.belaAgenda.controller.svc;

import java.time.LocalDateTime;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.belaAgenda.business.svc.AgendamentoBusiness;
import br.com.belaAgenda.infra.base.controller.BaseBean;
import br.com.belaAgenda.infra.util.UtilData;
import br.com.belaAgenda.infra.util.UtilList;
import br.com.belaAgenda.model.glb.Cliente;
import br.com.belaAgenda.model.rh.Funcionario;
import br.com.belaAgenda.model.svc.Agendamento;
import br.com.belaAgenda.model.svc.Servico;

@Named
@ViewScoped
public class AgendamentoBean extends BaseBean {

	private static final long serialVersionUID = 5039419771488014150L;

	@Inject
	private AgendamentoBusiness agendamentoBusiness;
	
	private Agendamento agendamento = new Agendamento();
	
	private List<Agendamento> agendamentos;
	
	
	private Long pesquisa;
	
	public void adicionar(){
		agendamento = new Agendamento();
	}
	
	public void clonar(Agendamento agendamento){
		this.agendamento = (Agendamento) agendamento.clone();
	}
	
	public void salvar(){
		this.agendamento = agendamentoBusiness.save(this.agendamento);
		
		addMessage(null, FacesMessage.SEVERITY_INFO ,getMessage("agendamentoBean.agendamentoSalvo"), null);
		agendamentos.add(agendamento);
	}
	
	public void pesquisar(){
	
		agendamentos = agendamentoBusiness.listEntities()
				.sortBy("codigo")
				.equal("codigo", pesquisa)
				.list();
					
	}
	
	public void onServicosChosen(SelectEvent event) {
	    Servico  servico = (Servico) event.getObject();
	    
	    agendamento.getServicos().add(servico);
	}
	
	public void onClienteChosen(SelectEvent event) {
	    agendamento.setCliente((Cliente) event.getObject());
	}
	
	public void onFuncionarioChosen(SelectEvent event) {
	    agendamento.setFuncionario((Funcionario) event.getObject());
	}
	
	public void editar(Agendamento agendamento){
		this.agendamento = agendamento;
	}
	
	public void show(Agendamento agendamento){
		this.agendamento = agendamento;
	}
	
	public void iniciarAtendimento(Agendamento agendamento){
		this.agendamento = agendamentoBusiness.iniciarAtendimento(agendamento);
		UtilList.update(agendamentos, agendamento, this.agendamento);
		 
	}
	
	public void terminarAtendimento(Agendamento agendamento){
		this.agendamento = agendamentoBusiness.terminarAtendimento(agendamento);
		UtilList.update(agendamentos, agendamento, this.agendamento);
	}
	
	public String obterTituloCadastro(Agendamento agendamento){
		if(agendamento == null || (agendamento != null && agendamento.getId() == 0)){
			return getMessage("global.novo");
		}else{
			return agendamento.getCodigo().toString() + " - " + UtilData.formatarData(agendamento.getData());
		}
	}
	
	public String obterDataFormatada(LocalDateTime localDateTime){
		return UtilData.formatarData(localDateTime);
				
	}
	

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public List<Agendamento> getAgendamentos() {
		if(agendamentos == null){
			agendamentos = listarProximosAgendamentos();
		}
		return agendamentos;
	}
	
	private List<Agendamento> listarProximosAgendamentos(){
		return agendamentoBusiness.listEntities()
				.greaterThanOrEqualTo("data", LocalDateTime.now())
				.list();
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public Long getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Long pesquisa) {
		this.pesquisa = pesquisa;
	}

	
}
