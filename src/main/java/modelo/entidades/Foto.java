package modelo.entidades;

import java.io.Serializable;

public class Foto implements Serializable{
	private int idFoto;
	private String url;
	
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
