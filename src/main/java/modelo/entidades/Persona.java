package modelo.entidades;

import java.io.Serializable;

public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idPersona;
	private String nombre;
	private String apellido;
	private String username;
	private String clave;
	
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
		return "Persona: " + this.nombre + " " + this.apellido;
	}
}
