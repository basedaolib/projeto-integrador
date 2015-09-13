package br.com.belaAgenda.infra.base.controller;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.belaAgenda.infra.resourceBundle.MessageProvider;
import br.com.belaAgenda.infra.util.Transactional;

@Transactional
public class BaseBean {
	
	@Inject
	@RequestScoped
	protected FacesContext facesContext;
	
	@Inject
	protected MessageProvider messageProvider;
	
	protected String getMessage(String key){
		return messageProvider.getValue(key);
	}
	
	protected void addMessage(String messagesConteiner, FacesMessage.Severity severity, String summary, String detail, Object... detalArg){
		summary = formatar(summary, detalArg);
		detail = formatar(detail, detalArg);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(messagesConteiner, new FacesMessage(severity, summary, detail));
	}
	
	private String formatar(String message, Object[] detalArg){
		if(detalArg != null && detalArg.length > 0 && message != null && message.length() > 0){
			for(int i = 0; i < detalArg.length ; i++){
				message = message.replace("{" + i +"}", detalArg[i].toString());
			}
		}
		return message;
	}
	
	@Produces
	@RequestScoped
	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
}
