package modelo.dao;

import modelo.entidades.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer>{
	public Persona autorizarPersona(String username, String password);
}
