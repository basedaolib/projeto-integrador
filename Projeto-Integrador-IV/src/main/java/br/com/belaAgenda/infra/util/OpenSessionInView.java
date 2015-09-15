package br.com.belaAgenda.infra.util;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("*.xhtml")
public class OpenSessionInView implements Filter {

	@Inject
	@RequestScoped
	private EntityManager entityManager;

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		entityManager.getTransaction().begin();
		try{
		chain.doFilter(request, response);
		entityManager.getTransaction().commit();
		}catch (Throwable t) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
            	entityManager.getTransaction().rollback();
            }
            lancarFacesMessage(t.getMessage());
        }
        if (entityManager != null && entityManager.isOpen()) {
          	entityManager.close();
        }
        
		
	}
	
	private void lancarFacesMessage(String message){ 
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null , new FacesMessage(FacesMessage.SEVERITY_ERROR , null, message));
		}catch (Throwable t) {
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
