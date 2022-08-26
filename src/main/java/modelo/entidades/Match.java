package modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "match")
public class Match implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMatch;
	
	//@Column(name = "idmascotapretendiente")
	//@ManyToOne @JoinColumn(name = "idmascotapretendiente", referencedColumnName = "matches")
	//private int idMascotaPretendiente;
	
	//@ManyToOne @JoinColumn(name = "idmascotapretendida", referencedColumnName = "matches")
	//@Column(name = "idmascotapretendida")
	//private int idMascotaPretendida;
	
	@Column(name = "match")
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
