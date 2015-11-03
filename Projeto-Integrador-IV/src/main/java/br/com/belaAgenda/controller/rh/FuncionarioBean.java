package br.com.belaAgenda.controller.rh;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.belaAgenda.business.rh.FuncionarioBusiness;
import br.com.belaAgenda.infra.base.controller.BaseBean;
import br.com.belaAgenda.infra.base.model.type.EstadoEntidade;
import br.com.belaAgenda.model.glb.Cliente;
import br.com.belaAgenda.model.glb.types.EstadoCivil;
import br.com.belaAgenda.model.glb.types.OrgaoExpedidorRG;
import br.com.belaAgenda.model.glb.types.Sexo;
import br.com.belaAgenda.model.glb.types.UnidadeFederacao;
import br.com.belaAgenda.model.rh.Funcionario;
import br.com.belaAgenda.model.svc.Servico;
import br.com.generic.dao.WhereEntityListBuilder;

@Named
@ViewScoped
public class FuncionarioBean extends BaseBean {
	
	private static final long serialVersionUID = -4737484614157295865L;
	
	@Inject
	private FuncionarioBusiness funcionarioBusiness;
	
	private Funcionario funcionario = new Funcionario();
	
	private List<Funcionario> funcionarios;
	
	private EstadoEntidade estado = EstadoEntidade.Ativo;
	
	private String pesquisa;
	
	public void adicionar(){
		funcionario = new Funcionario();
	}
	
	public void clonar(Funcionario funcionario){
		this.funcionario = (Funcionario) funcionario.clone();
	}
	
	public void salvar(){
		this.funcionario = funcionarioBusiness.save(this.funcionario);
		
		addMessage(null, FacesMessage.SEVERITY_INFO ,getMessage("funcionarioBean.funcionarioSalvo"), null);
		funcionarios.add(funcionario);
	}
	
	public void inativar(){
		this.funcionario = funcionarioBusiness.inativar(this.funcionario);
		
		addMessage(null, FacesMessage.SEVERITY_INFO ,getMessage("funcionarioBean.funcionarioInativado"), null);
	}
	
	public void pesquisar(){
		String codigoS;
		Long codigo;
		WhereEntityListBuilder<Funcionario> funcionarioWhere = funcionarioBusiness.listEntities();
		try{
			if(pesquisa!= null && pesquisa.startsWith(",")){
					codigoS = pesquisa.replace(",", "");
					codigo = Long.parseLong(codigoS);
					funcionarios = funcionarioWhere.sortBy("codigo")
							.equal("codigo", codigo)
							.equal("estado", estado)
							.list();
					return;
			}
		}finally{}
		funcionarios = funcionarioWhere.sortBy("nome")
				.like("nome", pesquisa + "%")
				.equal("estado", estado)
				.list();
	}
	
	public void editar(Funcionario funcionario){
		this.funcionario = funcionario;
	}
	
	public String obterTituloCadastro(){
		if(funcionario == null || (funcionario != null && funcionario.getId() == 0)){
			return getMessage("global.novo");
		}else{
			return funcionario.getCodigo().toString() + " - " +funcionario.getNome();
		}
	}
	
	
	public void remover(Servico servico){
		funcionario.getServicos().remove(servico);
	}
	
	public void onServicosChosen(SelectEvent event) {
	    Servico  servico = (Servico) event.getObject();
	    
	    funcionario.getServicos().add(servico);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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

	public OrgaoExpedidorRG[] getOrgaos(){
		return OrgaoExpedidorRG.values();
	}
	
	public UnidadeFederacao[] getUnidadesFederacoes(){
		return UnidadeFederacao.values();
	}
	
	public EstadoCivil[] getEstadosCivis() {
		return EstadoCivil.values();
	}
	
	public Sexo[] getSexos(){
		return Sexo.values();
	}
	
	public boolean podeInativar(){
		return funcionario.getId() == 0? true : false;
	}
	public EstadoEntidade[] estadosEntidade(){
		return EstadoEntidade.values();
	}
}
