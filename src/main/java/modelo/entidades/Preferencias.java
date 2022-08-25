package modelo.entidades;

import java.io.Serializable;

public class Preferencias implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idPreferencias;
	private Especie especie;
	private Sexo sexo;
	private int edadMinima;
	private int edadMaxima;
	
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
