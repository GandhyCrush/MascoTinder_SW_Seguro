package modelo.JPADAO;


import javax.persistence.Query;

import modelo.dao.PreferenciasDAO;
import modelo.entidades.Preferencias;

public class JPAPreferenciasDAO extends JPAGenericDAO<Preferencias, Integer> implements PreferenciasDAO{

	public JPAPreferenciasDAO() {
		super(Preferencias.class);
	}
	
	@Override
	public Preferencias getPreferenciasByIdMascota(int idMiMascota) {
		String sentenceJPQL = "SELECT p from preferencias p WHERE p.mascota.idMascota= :idMiMasctota";

		Query query = this.em.createQuery(sentenceJPQL);
		query.setParameter("idMiMascota", idMiMascota);
		Preferencias resultado = (Preferencias) query.getSingleResult();

		return resultado;
	}
	
}
