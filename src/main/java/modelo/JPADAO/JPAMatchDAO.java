package modelo.JPADAO;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.MatchDAO;
import modelo.entidades.Mascota;
import modelo.entidades.Match;

public class JPAMatchDAO extends JPAGenericDAO<Match, Integer> implements MatchDAO{

	public JPAMatchDAO() {
		super(Match.class);
	}
	
	public Match isMatch(int idMascotaPretendiente, int idMiMascota) {
		
		Match resultado = null;
		String sentenceJPQL = "SELECT m from matchTable m WHERE m.mascotaPretendiente.idMascota= :idMiMascota and "
				+ "m.mascotaPretendida.idMascota= :idMascotaPretendiente";

		Query query = this.em.createQuery(sentenceJPQL);
		query.setParameter("idMiMascota", idMiMascota);
		query.setParameter("idMascotaPretendiente", idMascotaPretendiente);
		@SuppressWarnings("unchecked")
		List<Match> queryResult = query.getResultList();
		if (queryResult.size() != 0) {
			resultado = queryResult.get(0);
		} 
		
		return resultado;
	}

	public void createMatch(int idMiMascota, int idMascotaPretendiente) {
		String miMascotaJPQL = "SELECT m from mascota m WHERE m.idMascota= :idMiMascota";
		String miPretendienteJPQL = "SELECT m from mascota m WHERE m.idMascota= :idMascotaPretendiente";

		Query miMascotaQuery = this.em.createQuery(miMascotaJPQL);
		Query miPretendienteQuery = this.em.createQuery(miPretendienteJPQL);
		
		miMascotaQuery.setParameter("idMiMascota", idMiMascota);
		miPretendienteQuery.setParameter("idMascotaPretendiente", idMascotaPretendiente);
		Mascota miMascota = (Mascota) miMascotaQuery.getSingleResult();
		Mascota miPretendiente = (Mascota) miPretendienteQuery.getSingleResult();		
		
		Match newMatch = new Match(miPretendiente, miMascota, false);
		super.create(newMatch);
	}

	public List<Mascota> getMatches(int idMiMascota) {
		String sentenciaJPQL = "SELECT m from mascota m where m.idMascota in (SELECT "
				+ "ma.mascotaPretendida.idMascota from matchTable ma where ma.match = true and ma.mascotaPretendiente.idMascota =:idMiMascota) or m.idMascota in"
				+ " (SELECT ma.mascotaPretendiente.idMascota from matchTable ma where ma.match = true and ma.mascotaPretendida.idMascota =:idMiMascota )";
		
		Query query = this.em.createQuery(sentenciaJPQL);
		query.setParameter("idMiMascota", idMiMascota);
		@SuppressWarnings("unchecked")
		List<Mascota> resultado = query.getResultList();
		return resultado;
	}

}
