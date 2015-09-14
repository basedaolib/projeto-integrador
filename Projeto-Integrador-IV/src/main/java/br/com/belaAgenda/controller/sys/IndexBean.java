package br.com.belaAgenda.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.belaAgenda.infra.base.controller.BaseBean;

@Named
@ViewScoped
public class IndexBean extends BaseBean {

	private static final long serialVersionUID = 4091213943779197205L;
	private String page;
	
	public void opem(String page, String header, int width, int height) {
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("minimizable", true);
        options.put("header", "'" + header + "'");
        options.put("width", width);
        options.put("height", height);
        options.put("contentHeight", "'100%'");
        options.put("contentWidth", "'100%'");
        
        RequestContext.getCurrentInstance().openDialog(page, options, null);
    }

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	

}
