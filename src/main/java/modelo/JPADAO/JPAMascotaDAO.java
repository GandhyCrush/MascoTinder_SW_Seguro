package modelo.JPADAO;

import java.util.List;
import javax.persistence.Query;
import modelo.dao.MascotaDAO;
import modelo.entidades.Mascota;
import modelo.entidades.Persona;
import modelo.entidades.Preferencias;

public class JPAMascotaDAO extends JPAGenericDAO<Mascota, Integer> implements MascotaDAO {

	public JPAMascotaDAO() {
		super(Mascota.class);
	}

	

	public List<Mascota> getMascotas(Preferencias preferencias) {

		String sentenceJPQL = "SELECT m from mascota m WHERE "
				+ "m.especie = :par_especie and "
				+ "m.edad >= :par_edadMin and " 
				+ "m.edad <= :par_edadMax and " 
				+ "m.sexo = :par_sexo and "
				+ "m.propietario != :par_idPropietario and "
				+ "m.idMascota not in (SELECT ma.mascotaPretendiente.idMascota from matchTable ma "
				+ "where ma.mascotaPretendida.idMascota = :par_idMiMascota) and "
				+ "m.idMascota not in (SELECT "
				+ "ma.mascotaPretendida.idMascota from matchTable ma where ma.match = true and ma.mascotaPretendiente.idMascota =:par_idMiMascota)";

		Query query = this.em.createQuery(sentenceJPQL);
		query.setParameter("par_especie", preferencias.getEspecie());
		query.setParameter("par_edadMin", preferencias.getEdadMinima());
		query.setParameter("par_edadMax", preferencias.getEdadMaxima());
		query.setParameter("par_sexo", preferencias.getSexo());
		query.setParameter("par_idMiMascota", preferencias.getMascota().getIdMascota());
		query.setParameter("par_idPropietario", preferencias.getMascota().getPropietario());
		@SuppressWarnings("unchecked")
		List<Mascota> resultado = query.getResultList();
		
		return resultado;
	}

	public List<Mascota> getMisMascotas(Persona propietario) {

		String sentenceJPQL = "SELECT m from mascota m WHERE m.propietario =:par_propietario";

		Query query = this.em.createQuery(sentenceJPQL);
		query.setParameter("par_propietario", propietario);
		@SuppressWarnings("unchecked")
		List<Mascota> resultado = query.getResultList();

		return resultado;
	}

}
