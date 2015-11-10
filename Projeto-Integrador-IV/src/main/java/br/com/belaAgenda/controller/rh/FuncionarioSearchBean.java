package br.com.belaAgenda.controller.rh;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.belaAgenda.business.rh.FuncionarioBusiness;
import br.com.belaAgenda.infra.base.controller.BaseBean;
import br.com.belaAgenda.model.rh.Funcionario;
import br.com.generic.dao.SearchEntityListBuilder;

 @Named
 @ViewScoped
public class FuncionarioSearchBean extends BaseBean {
	private static final long serialVersionUID = -6805305359830905268L;

	private List<Funcionario> funcionarios;
	
	private String pesquisa;
	
	@Inject
	private FuncionarioBusiness funcionarioBusiness;
	
	public void pesquisar(){
		String codigoS;
		Long codigo;
		SearchEntityListBuilder<Funcionario> funcionarioWhere = funcionarioBusiness.listEntities();
		try{
			if(pesquisa!= null && pesquisa.startsWith(",")){
					codigoS = pesquisa.replace(",", "");
					codigo = Long.parseLong(codigoS);
					funcionarios = funcionarioWhere.sortBy("codigo")
							.equal("codigo", codigo)
							.list();
					return;
			}
		}finally{}
		funcionarios = funcionarioWhere.sortBy("nome")
				.like("nome", pesquisa + "%")
				.list();
	}
	
	public void openSearch(){
		RequestContext.getCurrentInstance().openDialog("/pages/rh/funcionarioSearch.xhtml");
	}
	
	public void selecionar(Funcionario funcionario){
		RequestContext.getCurrentInstance().closeDialog(funcionario);
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
	

}
