package br.com.belaAgenda.infra.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class JpaUtil {
	
	private EntityManagerFactory factory =  Persistence.createEntityManagerFactory("bela_agenda");
	
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
	}

}
