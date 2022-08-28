package modelo.dao;

import java.util.List;

import modelo.entidades.Mascota;
import modelo.entidades.Match;

public interface MatchDAO extends GenericDAO<Match, Integer>{
	public Match isMatch(int idMascotaObjetivo, int idMiMascota);
	public void createMatch(int idMiMascota, int idMascotaObjetivo);
	public List<Mascota> getMatches(int idMiMascota);
}
