package br.com.belaAgenda.infra.util;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
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
		
		try{
			entityManager.getTransaction().begin();
			chain.doFilter(request, response);
			entityManager.getTransaction().commit();
		}catch (Throwable t) {
			if(entityManager.getTransaction().isActive()){
				entityManager.getTransaction().rollback();
			}
        }
        if (entityManager != null && entityManager.isOpen()) {
          	entityManager.close();
        }
        
		
	}
	
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
