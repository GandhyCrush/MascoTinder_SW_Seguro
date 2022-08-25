package modelo.entidades;

import java.io.Serializable;

public class Match implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idMatch;
	private int idMascotaPretendiente;
	private int idMascotaPretendida;
	private boolean match;
	//private Fecha fecha;
	
	public Match() {
		
	}
	
	public Match(int idMascotaPretendiente, int idMascotaPretendida, boolean match) {
		this.idMascotaPretendiente = idMascotaPretendiente;
		this.idMascotaPretendida = idMascotaPretendida;
		this.match = match;
	}

	public int getIdMatch() {
		return idMatch;
	}
	
	public int getIdMascotaPretendiente() {
		return idMascotaPretendiente;
	}

	public void setIdMascotaPretendiente(int idMascotaPretendiente) {
		this.idMascotaPretendiente = idMascotaPretendiente;
	}

	public int getIdMascotaPretendida() {
		return idMascotaPretendida;
	}

	public void setIdMascotaPretendida(int idMascotaPretendida) {
		this.idMascotaPretendida = idMascotaPretendida;
	}

	public boolean isMatch() {
		return match;
	}

	public void setMatch(boolean match) {
		this.match = match;
	}

	@Override
	public String toString() {
		return "Match [idMascotaPretendiente=" + idMascotaPretendiente + ", idMascotaPretendida=" + idMascotaPretendida
				+ ", match=" + match + "]";
	}
	
	
}
