package modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "matchTable")
public class Match implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMatch;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "mascotapretendiente", referencedColumnName = "idmascota")
	private Mascota mascotaPretendiente;
	
	@ManyToOne 
	private Mascota mascotaPretendida;
	
	@Column(name = "isMatch")
	private boolean match;
	//private Fecha fecha;
	
	public Match() {
		
	}
	
	public Match(Mascota mascotaPretendiente, Mascota idMascotaPretendida, boolean match) {
		this.mascotaPretendiente = mascotaPretendiente;
		this.mascotaPretendida = idMascotaPretendida;
		this.match = match;
	}

	public int getIdMatch() {
		return idMatch;
	}
	


	public boolean isMatch() {
		return match;
	}

	public void setMatch(boolean match) {
		this.match = match;
	}


	
	
}
