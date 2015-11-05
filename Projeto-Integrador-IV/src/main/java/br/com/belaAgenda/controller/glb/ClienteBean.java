package br.com.belaAgenda.controller.glb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.belaAgenda.business.glb.ClienteBusiness;
import br.com.belaAgenda.infra.base.controller.BaseBean;
import br.com.belaAgenda.infra.base.model.type.EstadoEntidade;
import br.com.belaAgenda.model.glb.types.EstadoCivil;
import br.com.belaAgenda.model.glb.types.OrgaoExpedidorRG;
import br.com.belaAgenda.model.glb.types.Sexo;
import br.com.belaAgenda.model.glb.types.UnidadeFederacao;
import br.com.generic.dao.WhereEntityListBuilder;
import br.com.belaAgenda.model.glb.Cliente;

@Named
@ViewScoped
public class ClienteBean extends BaseBean {
	
	private static final long serialVersionUID = -4737484614157295865L;
	
	@Inject
	private ClienteBusiness clienteBusiness;
	
	private Cliente cliente = new Cliente();
	
	private List<Cliente> clientes;
	
	private EstadoEntidade estado = EstadoEntidade.Ativo;
	
	private String pesquisa;
	
	public void adicionar(){
		cliente = new Cliente();
	}
	
	public void clonar(Cliente cliente){
		this.cliente = (Cliente) cliente.clone();
	}
	
	public void salvar(){
		this.cliente = clienteBusiness.save(this.cliente);
		
		addMessage("mensagem", FacesMessage.SEVERITY_INFO ,getMessage("clienteBean.clienteSalvo"), null);
		clientes.add(cliente);
	}
	
	public void inativar(){
		this.cliente = clienteBusiness.inativar(this.cliente);
		
		addMessage(null, FacesMessage.SEVERITY_INFO ,getMessage("clienteBean.clienteInativado"), null);
	}
	
	public void pesquisar(){
		String codigoS;
		Long codigo;
		WhereEntityListBuilder<Cliente> clienteWhere = clienteBusiness.listEntities();
		try{
			if(pesquisa!= null && pesquisa.startsWith(",")){
					codigoS = pesquisa.replace(",", "");
					codigo = Long.parseLong(codigoS);
					clientes = clienteWhere.sortBy("codigo")
							.equal("codigo", codigo)
							.equal("estado", estado)
							.list();
					return;
			}
		}finally{}
		clientes = clienteWhere.sortBy("nome")
				.like("nome", pesquisa + "%")
				.equal("estado", estado)
				.list();
	}
	
	public void editar(Cliente cliente){
		this.cliente = cliente;
	}
	
	public String obterTituloCadastro(){
		if(cliente == null || (cliente != null && cliente.getId() == 0)){
			return getMessage("global.novo");
		}else{
			return cliente.getCodigo().toString() + " - " +cliente.getNome();
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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
		return cliente.getId() == 0? true : false;
	}
	public EstadoEntidade[] estadosEntidade(){
		return EstadoEntidade.values();
	}
}
