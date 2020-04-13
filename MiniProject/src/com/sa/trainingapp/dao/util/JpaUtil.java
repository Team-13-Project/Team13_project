package com.sa.trainingapp.dao.util;
/**
 * Chandra Shekhar H M for SkillAssure
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("test_jpql");
		
		return emf.createEntityManager();
	}
}
