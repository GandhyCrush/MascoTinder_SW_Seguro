package modelo.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name = "mensaje")
public class Mensaje implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMensaje;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "emisor", referencedColumnName = "idPersona")
	private Persona emisor;
	@ManyToOne
	private Persona receptor;
	@Column(name = "mensaje")
	private String mensaje;
	
	public Mensaje() {
		
	}
	
	public Mensaje(Persona emisor, Persona receptor, String mensaje) {
		super();
		this.emisor = emisor;
		this.receptor = receptor;
		this.mensaje = mensaje;
	}
	
	public int getIdMensaje() {
		return idMensaje;
	}
	
	public Persona getEmisor() {
		return emisor;
	}
	
	public Persona getReceptor() {
		return receptor;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return Objects.equals(emisor, other.emisor) && idMensaje == other.idMensaje
				&& Objects.equals(mensaje, other.mensaje) && Objects.equals(receptor, other.receptor);
	}

	@Override
	public String toString() {
		return "Mensaje [idEmisor=" + emisor + ", idReceptor=" + receptor + ", mensaje=" + mensaje + "]";
	}
}
