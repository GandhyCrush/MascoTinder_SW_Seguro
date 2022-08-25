package modelo.JPADAO;

import java.util.List;

import modelo.dao.MatchDAO;
import modelo.entidades.Mascota;
import modelo.entidades.Match;

public class JPAMatchDAO extends JPAGenericDAO<Match, Integer> implements MatchDAO{

	public boolean isMatch(int idMascotaObjetivo, int idMiMascota) {
		// TODO Auto-generated method stub
		return false;
	}

	public void createMatch(int idMiMascota, int idMascotaObjetivo) {
		// TODO Auto-generated method stub
		
	}

	public List<Mascota> getMatches(int idMiMascota) {
		// TODO Auto-generated method stub
		return null;
	}

}
