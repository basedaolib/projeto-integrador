package br.com.belaAgenda.controller.glb;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.belaAgenda.business.glb.ClienteBusiness;
import br.com.belaAgenda.infra.base.controller.BaseBean;
import br.com.belaAgenda.model.glb.Cliente;
import br.com.generic.dao.SearchEntityListBuilder;

 @Named
 @ViewScoped
public class ClienteSearchBean extends BaseBean {
	private static final long serialVersionUID = -6805305359830905268L;

	private List<Cliente> clientes;
	
	private String pesquisa;
	
	@Inject
	private ClienteBusiness clienteBusiness;
	
	public void pesquisar(){
		String codigoS;
		Long codigo;
		SearchEntityListBuilder<Cliente> clienteWhere = clienteBusiness.listEntities();
		try{
			if(pesquisa!= null && pesquisa.startsWith(",")){
					codigoS = pesquisa.replace(",", "");
					codigo = Long.parseLong(codigoS);
					clientes = clienteWhere.sortBy("codigo")
							.equal("codigo", codigo)
							.list();
					return;
			}
		}finally{}
		clientes = clienteWhere.sortBy("nome")
				.like("nome", pesquisa + "%")
				.list();
	}
	
	public void openSearch(){
		RequestContext.getCurrentInstance().openDialog("/pages/glb/clienteSearch.xhtml");
	}
	
	public void selecionar(Cliente cliente){
		RequestContext.getCurrentInstance().closeDialog(cliente);
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
	

}
