package modelo.JPADAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import javax.persistence.Query;

import modelo.dao.MascotaDAO;
import modelo.entidades.Mascota;
import modelo.entidades.Preferencias;

public class JPAMascotaDAO extends JPAGenericDAO<Mascota, Integer> implements MascotaDAO {
	private EntityManager em =  Persistence.createEntityManagerFactory("MascoTinder_Proyecto").createEntityManager();
	
	
	
	public List<Mascota> getMascotas(Preferencias preferencias) {
		return null;
	}

	public List<Mascota> getMisMascotas(int idPropietario) {
		String sentenciaSQL = "SELECT * FROM Mascota m where m.PROPIETARIO_IDPERSONA = (?)";
		Query consultaNativa = em.createNativeQuery(sentenciaSQL, Mascota.class);
		consultaNativa.setParameter(1, idPropietario);
		 
		return consultaNativa.getResultList() ;
	}

}
