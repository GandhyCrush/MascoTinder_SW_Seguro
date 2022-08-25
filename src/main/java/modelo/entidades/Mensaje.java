package modelo.entidades;

import java.io.Serializable;

public class Mensaje implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idMensaje;
	private int idEmisor;
	private int idReceptor;
	private String mensaje;
	//private Fecha fecha;
	
	public Mensaje() {
		
	}
	
	public Mensaje(int idEmisor, int idReceptor, String mensaje) {
		super();
		this.idEmisor = idEmisor;
		this.idReceptor = idReceptor;
		this.mensaje = mensaje;
	}
	
	public int getIdMensaje() {
		return idMensaje;
	}
	
	public int getIdEmisor() {
		return idEmisor;
	}
	
	public int getIdReceptor() {
		return idReceptor;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	@Override
	public String toString() {
		return "Mensaje [idEmisor=" + idEmisor + ", idReceptor=" + idReceptor + ", mensaje=" + mensaje + "]";
	}
}
