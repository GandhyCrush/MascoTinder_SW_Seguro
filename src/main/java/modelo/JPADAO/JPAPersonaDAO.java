package modelo.JPADAO;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.PersonaDAO;
import modelo.entidades.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO{

	public JPAPersonaDAO() {
		super(Persona.class);
	}

	@SuppressWarnings("unchecked")
	public Persona autorizarPersona(String username, String password) {
		Persona personaAutorizada = null;
		String sentenciaJPQL = "SELECT p FROM persona p WHERE p.username= :username and p.clave= :clave";
		Query consulta =  em.createQuery(sentenciaJPQL);
		consulta.setParameter("username",username);
		consulta.setParameter("clave", password);
		List<Persona> resultado = consulta.getResultList();
		if(resultado.size()>0) {
			personaAutorizada = resultado.get(0);
		}
		
		return personaAutorizada;
	}

}
