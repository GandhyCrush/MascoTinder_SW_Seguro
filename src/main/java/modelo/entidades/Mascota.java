package modelo.entidades;

import java.io.Serializable;
import java.util.List;

public class Mascota implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idMascota;
	private String nombre;
	private String descripcion;
	private Especie especie;
	private Sexo sexo;
	private int edad;
	private List<Foto> fotos;
	private Preferencias preferencias;
	private Persona propietario;
	
	public Mascota() {
		
	}

	public Mascota(String nombre, Especie especie, Sexo sexo, int edad, Persona propietario) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.sexo = sexo;
		this.edad = edad;
		this.propietario = propietario;
	}

	public int getIdMascota() {
		return idMascota;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Especie getEspecie() {
		return especie;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Preferencias getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(Preferencias preferencias) {
		this.preferencias = preferencias;
	}

	public Persona getPropietario() {
		return propietario;
	}

	@Override
	public String toString() {
		return "Mascota: " + this.nombre + "(" + this.especie + ")";
	}
	
	
}
