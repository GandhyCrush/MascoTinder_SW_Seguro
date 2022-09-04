package modelo.dao;

import modelo.entidades.Preferencias;

public interface PreferenciasDAO extends GenericDAO<Preferencias, Integer>{
	public Preferencias getPreferenciasByIdMascota(int idMiMascota);
}
