package modelo.JPADAO;

import modelo.dao.DAOFactory;
import modelo.dao.MascotaDAO;
import modelo.dao.MatchDAO;
import modelo.dao.PersonaDAO;
import modelo.dao.PreferenciasDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public PersonaDAO getPersonaDAO() {
		return new JPAPersonaDAO();
	}

	@Override
	public MascotaDAO getMascotaDAO() {
		return new JPAMascotaDAO();
	}

	@Override
	public MatchDAO getMatchDAO() {
		return new JPAMatchDAO();
	}

	public PreferenciasDAO getPreferenciasDAO() {
		return new JPAPreferenciaDAO();
	}
}
