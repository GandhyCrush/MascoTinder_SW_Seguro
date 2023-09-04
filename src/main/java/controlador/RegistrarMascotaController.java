package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import modelo.dao.DAOFactory;
import modelo.entidades.Especie;
import modelo.entidades.Foto;
import modelo.entidades.Mascota;
import modelo.entidades.Persona;
import modelo.entidades.Preferencias;
import modelo.entidades.Sexo;

@WebServlet("/RegistrarMascotaController")
@MultipartConfig
public class RegistrarMascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String pathContext = "";
	private File uploads = new File(pathContext);
	private String[] extensionesPermitidas = { ".png", ".jpg", ".jpeg" };
	private List<Foto> fotos = new ArrayList<Foto>();
	private String directorioRaizImg = "http://localhost:8080/MascoTinder_Proyecto/imgs/";

	public RegistrarMascotaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("jsp/registrarMascota.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String especie = request.getParameter("especie");
		String sexo = request.getParameter("sexo");
		int edad = Integer.parseInt(request.getParameter("edad"));

		HttpSession session = request.getSession();
		Persona propietario = (Persona) session.getAttribute("usuarioLogeado");
		Mascota nuevaMascota = new Mascota(nombre, descripcion, Especie.valueOf(especie), Sexo.valueOf(sexo), edad,
				propietario);

		Part img1 = request.getPart("foto1");
		Part img2 = request.getPart("foto2");
		Part img3 = request.getPart("foto3");

		if (validacionExtensiones(img1, img2, img3)) {
			fotos.add(new Foto(getUrlFoto(img1), nuevaMascota));
			fotos.add(new Foto(getUrlFoto(img2), nuevaMascota));
			fotos.add(new Foto(getUrlFoto(img3), nuevaMascota));

			nuevaMascota.setFotos(fotos);
			nuevaMascota.setPreferencias(new Preferencias(nuevaMascota, Especie.PERRO, Sexo.MACHO, 1, 15));
			DAOFactory.getFactory().getMascotaDAO().create(nuevaMascota);
		}

		request.getRequestDispatcher("/MisMascotasController").forward(request, response);
	}

	private String getUrlFoto(Part part) throws ServletException, IOException {
		String urlResultante = "";
		this.pathContext = getServletContext().getRealPath("/imgs");

		try {
			Path path = Paths.get(part.getSubmittedFileName());
			String fileName = path.getFileName().toString();
			InputStream input = part.getInputStream();

			if (input != null) {
				File file = new File(uploads, fileName);
				Path destino = Paths.get(this.pathContext + "/" + file.toPath());
				Files.copy(input, destino);
				urlResultante = directorioRaizImg + fileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return urlResultante;

	}

	private boolean extensionValida(String fileName) {
		for (String string : this.extensionesPermitidas) {
			if (fileName.toLowerCase().endsWith(string))
				return true;
		}
		return false;
	}

	private boolean validacionExtensiones(Part img1, Part img2, Part img3) {
		return extensionValida(img1.getSubmittedFileName()) && extensionValida(img2.getSubmittedFileName())
				&& extensionValida(img3.getSubmittedFileName());
	}

}
