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
	
	public boolean isMatch(int idMascotaObjetivo, int idMiMascota) {
		String sentenciaSQL = "SELECT * from matchtable m where m.mascotapretendiente = (?) and "
				+ "m.mascotapretendida_idmascota = (?)";
		Query consultaNativa = em.createNativeQuery(sentenciaSQL, Mascota.class);
		consultaNativa.setParameter(1, idMascotaObjetivo);
		consultaNativa.setParameter(2, idMiMascota);
		
		return consultaNativa.getResultList() == null;
	}

	public void createMatch(int idMiMascota, int idMascotaObjetivo) {
		String sentenciaSQL = "INSERT INTO matchtable VALUES (NULL, (?), (?), 0)";
		Query consultaNativa = em.createNativeQuery(sentenciaSQL, Match.class);
		consultaNativa.setParameter(1, idMiMascota);
		consultaNativa.setParameter(2, idMascotaObjetivo);
		
		consultaNativa.executeUpdate();
	}

	public List<Mascota> getMatches(int idMiMascota) {
		String sentenciaSQL = "SELECT * from MASCOTA where idmascota in (SELECT "
				+ "    CASE (?) "
				+ "    WHEN MASCOTAPRETENDIDA_IDMASCOTA THEN mascotapretendiente "
				+ "    WHEN mascotapretendiente THEN MASCOTAPRETENDIDA_IDMASCOTA "
				+ "    END "
				+ "FROM matchtable where ismatch = 1)";
		Query consultaNativa = em.createNativeQuery(sentenciaSQL, Mascota.class);
		consultaNativa.setParameter(1, idMiMascota);
		return consultaNativa.getResultList();
	}

}
