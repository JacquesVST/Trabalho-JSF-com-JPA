package fema;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SessionScoped
public class JpaManager implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private EntityManagerFactory entityManagerFactory;
	
	private EntityManager entityManager;
	
	public JpaManager() {
		
	}

	public EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("persistence-dados");
		}
		if (entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

}
