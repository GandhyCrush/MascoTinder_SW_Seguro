package modelo.dao;

import java.util.List;

import modelo.entidades.Mensaje;

public interface MensajeDAO extends GenericDAO<Mensaje, Integer>{
	public List<Mensaje> getMensajes(int idEmisor, int idReceptor);
}
