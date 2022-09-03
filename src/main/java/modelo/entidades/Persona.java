package modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "persona")
public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "clave")
	private String clave;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "propietario")
	private List<Mascota> mascotas;
	
	@OneToMany(mappedBy = "receptor")
	private List<Mensaje> mensajes;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, String apellido, String username, String clave) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.clave = clave;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return this.nombre + " " + this.apellido;
	}
}
