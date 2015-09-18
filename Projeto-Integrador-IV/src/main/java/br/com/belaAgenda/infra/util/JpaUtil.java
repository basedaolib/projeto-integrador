package br.com.belaAgenda.infra.util;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
class JpaUtil {
	
	private static final EntityManagerFactory factory =  Persistence.createEntityManagerFactory("bela_agenda");
	
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
		
	}
	
	@PreDestroy
	private void closeFactory(){
		factory.close();
	}

}
