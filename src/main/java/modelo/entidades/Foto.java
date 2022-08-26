package modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity(name = "foto")
public class Foto implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFoto;
	@Column(name = "url")
	private String url;
	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Mascota mascota;
	
	public Foto() {
		
	}

	public Foto(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIdFoto() {
		return idFoto;
	}

	@Override
	public String toString() {
		return "Foto [url=" + url + "]";
	}
	
	
}
