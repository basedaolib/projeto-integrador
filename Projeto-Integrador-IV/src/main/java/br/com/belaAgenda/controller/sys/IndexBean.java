package br.com.belaAgenda.controller.sys;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.belaAgenda.infra.base.controller.BaseBean;

@Named
@ViewScoped
public class IndexBean extends BaseBean {

	private String page;
	

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	

}
