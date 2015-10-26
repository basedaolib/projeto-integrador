
package br.com.belaAgenda.infra.util;

import java.io.Serializable;
import java.lang.reflect.Modifier;

import javax.annotation.Priority;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor @Transactional @Priority(Interceptor.Priority.APPLICATION)
public class NamedInterceptor implements Serializable{
	
	private static final long serialVersionUID = -7994877557421884197L;
	
	@Inject
	private EntityManager en;
	
	@AroundInvoke
	public Object auditar(InvocationContext context) throws Exception {
		if(context.getMethod().getModifiers() != Modifier.PUBLIC){
			return context.proceed();
		}
		Object retorno = null;
		try{
			retorno = context.proceed();
			return retorno;
		}catch (Exception t) {
            lancarFacesMessage(t.getMessage());
            en.getTransaction().setRollbackOnly();
        }
		return retorno;
	}
	
	private void lancarFacesMessage(String message){ 
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null , new FacesMessage(FacesMessage.SEVERITY_ERROR , message, null));
		}catch (Throwable t) {
		}
	}
}
