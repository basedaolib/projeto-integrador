package br.com.belaAgenda.infra.util;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
public class JpaUtil {
	
	private static EntityManagerFactory factory;
	
	
	public JpaUtil() {
		if(factory == null)
			factory =  Persistence.createEntityManagerFactory("bela_agenda");
	}
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
		
	} 
	
	
	
	
	public void closeManager(@Disposes EntityManager en){
		if(en.isOpen())
			en.close();
	}
	
	
	
	@PreDestroy
	private void closeFactory(){
		factory.close();
	}
	

}
