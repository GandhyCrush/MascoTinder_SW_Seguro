package modelo.JPADAO;

import modelo.dao.PersonaDAO;
import modelo.entidades.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO{

	public JPAPersonaDAO() {
		super(Persona.class);
	}

	public Persona autorizarPersona(String username, String password) {
		return null;
	}

}
