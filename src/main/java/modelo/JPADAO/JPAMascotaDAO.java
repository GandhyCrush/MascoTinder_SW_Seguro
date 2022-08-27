package modelo.JPADAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import javax.persistence.Query;

import modelo.dao.MascotaDAO;
import modelo.entidades.Mascota;
import modelo.entidades.Preferencias;

public class JPAMascotaDAO extends JPAGenericDAO<Mascota, Integer> implements MascotaDAO {
	
	public JPAMascotaDAO() {
		super(Mascota.class);
	}

	private EntityManager em =  Persistence.createEntityManagerFactory("MascoTinder_Proyecto").createEntityManager();
	
	
	
	public List<Mascota> getMascotas(Preferencias preferencias) {
		String sentenciaSQL = "SELECT * FROM Mascota m where m.especie = (?) and "
				+ "m.edad >= (?) and "
				+ "m.edad <= (?) and "
				+ "m.sexo = (?)";
		Query consultaNativa = em.createNativeQuery(sentenciaSQL, Mascota.class);
		consultaNativa.setParameter(1, preferencias.getEspecie());
		consultaNativa.setParameter(2, preferencias.getEdadMinima());
		consultaNativa.setParameter(3, preferencias.getEdadMaxima());
		consultaNativa.setParameter(4, preferencias.getSexo());
		 
		return consultaNativa.getResultList() ;
	}

	public List<Mascota> getMisMascotas(int idPropietario) {
		String sentenciaSQL = "SELECT * FROM Mascota m where m.PROPIETARIO_IDPERSONA = (?)";
		Query consultaNativa = em.createNativeQuery(sentenciaSQL, Mascota.class);
		consultaNativa.setParameter(1, idPropietario);
		 
		return consultaNativa.getResultList();
	}

}
