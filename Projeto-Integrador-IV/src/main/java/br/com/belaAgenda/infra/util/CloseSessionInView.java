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
public class CloseSessionInView implements Filter {

	@Inject
	@RequestScoped
	private EntityManager entityManager;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try{
		chain.doFilter(request, response);
		if(entityManager.getTransaction().isActive()){
			entityManager.getTransaction().commit();
		}else if(entityManager.getTransaction().getRollbackOnly()){
			entityManager.getTransaction().rollback();
		}
		}catch (Throwable t) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
            	entityManager.getTransaction().rollback();
            }
        }
        if (entityManager != null && entityManager.isOpen()) {
          	entityManager.close();
        }
        
		
	}
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
