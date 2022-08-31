package modelo.JPADAO;


import java.util.List;

import javax.persistence.Query;

import modelo.dao.PreferenciasDAO;
import modelo.entidades.Preferencias;

public class JPAPreferenciaDAO extends JPAGenericDAO<Preferencias, Integer> implements PreferenciasDAO{

	public JPAPreferenciaDAO() {
		super(Preferencias.class);
	}
	
	@Override
	public Preferencias getPreferenciasByIdMascota(int idMiMascota) {
		Preferencias resultado = null;
		String sentenceJPQL = "SELECT p from preferencias p WHERE p.mascota.idMascota= :idMiMascota";

		Query query = this.em.createQuery(sentenceJPQL);
		query.setParameter("idMiMascota", idMiMascota);
		@SuppressWarnings("unchecked")
		List<Preferencias> queryResult = query.getResultList();
		if( queryResult.size() != 0 )
			resultado = (Preferencias) query.getResultList().get(0);

		return resultado;
	}
	
}
