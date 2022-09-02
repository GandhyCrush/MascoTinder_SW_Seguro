package modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "mascota")
public class Mascota implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMascota;
	
	@Column(name ="nombre")
	private String nombre;
	
	@Column(name ="descripcion")
	private String descripcion;
	
	@Enumerated(EnumType.STRING)
	@Column(name ="especie")
	private Especie especie;
	
	@Column(name ="sexo")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name ="edad")
	private int edad;
	
	//claves foraneas
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "mascota")
	private List<Foto> fotos;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "mascota")
	private Preferencias preferencias;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Persona propietario;
	
	@OneToMany(mappedBy = "mascotaPretendida")
	private List<Match> matches;
	
	public Mascota() {
		
	}

	public Mascota(String nombre, String descripcion, Especie especie, Sexo sexo, int edad, Persona propietario) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.especie = especie;
		this.sexo = sexo;
		this.edad = edad;
		this.propietario = propietario;
		this.fotos = new ArrayList<Foto>();
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
		return "Mascota: " + this.nombre + "(" + this.especie + ")"+ this.fotos;
	}
	
	
}
