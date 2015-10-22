package br.com.belaAgenda.controller.svc;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.belaAgenda.business.svc.ServicoBusiness;
import br.com.belaAgenda.infra.base.controller.BaseBean;
import br.com.belaAgenda.infra.base.model.type.EstadoEntidade;
import br.com.belaAgenda.model.svc.Servico;

 @Named
 @ViewScoped
public class ServicoSearchBean extends BaseBean {
	private static final long serialVersionUID = -6805305359830905268L;

	private List<Servico> servicos;
	
	private String pesquisa;
	
	@Inject
	private ServicoBusiness servicoBusiness;
	
	public void pesquisar(){
		String codigoS;
		Long codigo;
		try{
			if(pesquisa!= null && pesquisa.startsWith(",")){
					codigoS = pesquisa.replace(",", "");
					codigo = Long.parseLong(codigoS);
					servicos = servicoBusiness.findEntitiesForProperties(0, 0, "codigo", "codigo,estado", codigo, EstadoEntidade.Ativo);
					return;
			}
		}finally{}
		servicos = servicoBusiness.findEntitiesForProperties(0, 0, "nome", "nome+,estado", pesquisa + "%", EstadoEntidade.Ativo);
	}
	
	public void openSearch(){
		RequestContext.getCurrentInstance().openDialog("/pages/svc/servicoSearch.xhtml");
	}
	
	public void selecionar(Servico servico){
		RequestContext.getCurrentInstance().closeDialog(servico);
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
	

}
