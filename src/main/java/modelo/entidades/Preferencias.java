package modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity(name = "preferencias")
public class Preferencias implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPreferencias;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "especie")
	private Especie especie;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo")
	private Sexo sexo;
	
	@Column(name = "edadMinima")
	private int edadMinima;
	
	@Column(name = "edadMaxima")
	private int edadMaxima;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Mascota mascota;
	
	public Preferencias() {
		
	}

	public Preferencias(Especie especie, Sexo sexo, int edadMinima, int edadMaxima) {
		super();
		this.especie = especie;
		this.sexo = sexo;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
	}

	public int getIdPreferencias() {
		return idPreferencias;
	}
	
	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	@Override
	public String toString() {
		return "Preferencias [especie=" + especie + ", sexo=" + sexo + ", edadMinima=" + edadMinima + ", edadMaxima="
				+ edadMaxima + "]";
	}
}
