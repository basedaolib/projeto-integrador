
package br.com.belaAgenda.infra.util;

import java.lang.reflect.Modifier;

import javax.annotation.Priority;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor @Transactional @Priority(Interceptor.Priority.APPLICATION)
public class NamedInterceptor {
	
	@AroundInvoke
	public Object auditar(InvocationContext context) throws Exception {
		if(context.getMethod().getModifiers() != Modifier.PUBLIC){
			return context.proceed();
		}
		Object retorno = null;
		try{
			retorno = context.proceed();
			return retorno;
		}catch (BaseException t) {
            lancarFacesMessage(t.getMessage());
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
