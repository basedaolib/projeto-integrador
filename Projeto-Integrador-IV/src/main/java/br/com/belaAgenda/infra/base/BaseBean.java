package br.com.belaAgenda.infra.base;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseBean {
	
	protected FacesContext facesContext = FacesContext.getCurrentInstance();
	
	public void addMessage(String messagesConteiner, String summary, String detail, Object... detalArg){
		if(detalArg != null){
			for(int i = 0; i < detalArg.length ; i++){
				detail = detail.replace("{" + i +"}", detalArg[i].toString());
				summary = summary.replace("{" + i +"}", detalArg[i].toString());
			}
		}
		facesContext.addMessage(messagesConteiner, new FacesMessage(summary, detail));
	}
}
