package modelo.JPADAO;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.MensajeDAO;
import modelo.entidades.Mascota;
import modelo.entidades.Mensaje;

public class JPAMensajeDAO extends JPAGenericDAO<Mensaje, Integer> implements MensajeDAO {

	public JPAMensajeDAO(Class<Mensaje> persistenceClass) {
		super(Mensaje.class);
	}

	@Override
	public List<Mensaje> getMensajes(int idEmisor, int idReceptor) {
		String sentenciaJPQL = "SELECT m from mensaje m where m.emisor.idPersona = :par_idEmisor and"
				+ "m.receptor.idPersona = :par_idReceptor";
		
		Query query = this.em.createQuery(sentenciaJPQL);
		query.setParameter("par_idEmisor", idEmisor);
		query.setParameter("par_idReceptor", idReceptor);
		@SuppressWarnings("unchecked")
		List<Mensaje> resultado = query.getResultList();
		return resultado;
	}
}
