package modelo.JPADAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import modelo.dao.GenericDAO;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID>{
	
	public Class<T> persistenceClass;
	protected EntityManager em;
	
	public JPAGenericDAO(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
		this.em = Persistence.createEntityManagerFactory("MascoTinder_Proyecto").createEntityManager();
	}
	
	@Override
	public void create(T instancia) {
		em.getTransaction().begin();
		try {
			em.persist(instancia);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Error S.O.S");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public T getById(ID id) {
		return em.find(persistenceClass, id);
	}

	@Override
	public void update(T instancia) {
		em.getTransaction().begin();
		try {
			em.merge(instancia);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Error S.O.S");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public void delete(T instancia) {
		em.getTransaction().begin();
		try {
			em.remove(instancia);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Error S.O.S");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public void deleteById(ID id) {
		T entidad = this.getById(id);
		
		em.getTransaction().begin();
		try {
			em.remove(entidad);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Error S.O.S");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

}
