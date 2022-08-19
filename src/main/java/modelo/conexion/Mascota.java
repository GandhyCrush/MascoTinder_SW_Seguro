package modelo.conexion;

public class Mascota {
	private int id;
	private String nombre;
	private String descripcion;
	private String rutaImg;
	public Mascota(String nombre, String descripcion, String rutaImg) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rutaImg = rutaImg;
	}
	
	public Mascota(int id, String nombre, String descripcion, String rutaImg) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rutaImg = rutaImg;
	}

	public Mascota() {
		
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

	public String getRutaImg() {
		return rutaImg;
	}

	public void setRutaImg(String rutaImg) {
		this.rutaImg = rutaImg;
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", rutaImg=" + rutaImg
				+ "]";
	}
	
	
	
	
	
}
