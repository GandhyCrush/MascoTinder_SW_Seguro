package modelo.JPADAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import javax.persistence.Query;

import modelo.dao.DAOFactory;
import modelo.dao.MascotaDAO;
import modelo.entidades.Mascota;
import modelo.entidades.Match;
import modelo.entidades.Preferencias;

public class JPAMascotaDAO extends JPAGenericDAO<Mascota, Integer> implements MascotaDAO {

	public JPAMascotaDAO() {
		super(Mascota.class);
	}

	private EntityManager em = Persistence.createEntityManagerFactory("MascoTinder_Proyecto").createEntityManager();

	public List<Mascota> getMascotas(Preferencias preferencias) {

		String sentenceJPQL = "SELECT m from mascota m WHERE "
				+ "m.especie = :par_especie and "
				+ "m.edad >= :par_edadMin and " 
				+ "m.edad <= :par_edadMax and " 
				+ "m.sexo = :par_sexo and "
				+ "m.idMascota not in (SELECT match.mascotapretendiente.idMascota from match "
				+ "where match.mascotapretendida.idMascota = :par_idMiMascota)";

		Query query = this.em.createQuery(sentenceJPQL);
		query.setParameter("par_especie", preferencias.getEspecie());
		query.setParameter("par_edadMin", preferencias.getEdadMinima());
		query.setParameter("par_edadMax", preferencias.getEdadMaxima());
		query.setParameter("par_sexo", preferencias.getSexo());
		query.setParameter("par_idMiMascota", preferencias.getMascota().getIdMascota());
		@SuppressWarnings("unchecked")
		List<Mascota> resultado = query.getResultList();
		
		return resultado;
	}

	public List<Mascota> getMisMascotas(int idPropietario) {

		String sentenceJPQL = "SELECT m from mascota m WHERE m.propietario.idPersona= :idPropietario";

		Query query = this.em.createQuery(sentenceJPQL);
		query.setParameter("idPropietario", idPropietario);
		@SuppressWarnings("unchecked")
		List<Mascota> resultado = query.getResultList();

		return resultado;
	}

}
