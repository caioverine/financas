package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public EntityManager getEntityManager(){
		
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("financas");
		
		return entityManagerFactory.createEntityManager();
	}
}
