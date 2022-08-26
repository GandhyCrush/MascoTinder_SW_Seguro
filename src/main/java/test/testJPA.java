package test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import modelo.entidades.Persona;

public class testJPA {

	public static void main(String[] args) {
		EntityManager em =  Persistence.createEntityManagerFactory("MascoTinder_Proyecto").createEntityManager();
		
		//INSERCION
		Persona p = new Persona("Gandhy", "Garcia", "Gandhy123", "1234");
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

}
