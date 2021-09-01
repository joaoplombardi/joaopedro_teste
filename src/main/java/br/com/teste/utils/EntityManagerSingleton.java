package br.com.teste.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {

	private static final EntityManagerFactory FACTORY = 
			Persistence.createEntityManagerFactory("teste-persistence-unit");
	private static EntityManager manager;
	
	public static EntityManager getInstance() {
		if (manager == null) manager = FACTORY.createEntityManager();
		return manager;
	}
}
