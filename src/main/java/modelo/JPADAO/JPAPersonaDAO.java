package modelo.JPADAO;

import javax.persistence.Query;

import modelo.dao.PersonaDAO;
import modelo.entidades.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO{

	public JPAPersonaDAO() {
		super(Persona.class);
	}

	public Persona autorizarPersona(String username, String password) {
		String sentenciaJPQL = "SELECT p FROM PERSONA p WHERE p.username= :username and p.clave= :clave";
		Query consulta =  em.createQuery(sentenciaJPQL);
		consulta.setParameter("username",username);
		consulta.setParameter("clave", password);
		return (Persona) consulta.getSingleResult();
	}

}
