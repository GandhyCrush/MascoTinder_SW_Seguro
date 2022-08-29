package modelo.dao;

import modelo.JPADAO.JPADAOFactory;

public abstract class DAOFactory {
	protected static DAOFactory factory = new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract PersonaDAO getPersonaDAO();
	public abstract MascotaDAO getMascotaDAO();
	public abstract MatchDAO getMatchDAO();
	public abstract PreferenciasDAO getPreferenciasDAO();
}
