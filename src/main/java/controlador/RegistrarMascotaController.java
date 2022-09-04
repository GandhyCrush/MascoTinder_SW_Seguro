package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelo.dao.DAOFactory;
import modelo.entidades.Especie;
import modelo.entidades.Foto;
import modelo.entidades.Mascota;
import modelo.entidades.Persona;
import modelo.entidades.Sexo;

@WebServlet("/RegistrarMascotaController")
@MultipartConfig
public class RegistrarMascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path = "";
	private File uploads = new File(path);
    private String[] extensions = {".png",".jpg", ".jpeg"};
    public RegistrarMascotaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/registrarMascota.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String especie = request.getParameter("especie");
		String sexo = request.getParameter("sexo");
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		Persona propietario = DAOFactory.getFactory().getPersonaDAO().getById(1);
		Mascota nuevaMascota = new Mascota(nombre, descripcion, Especie.valueOf(especie), Sexo.valueOf(sexo), edad, propietario);
		DAOFactory.getFactory().getMascotaDAO().create(nuevaMascota);
		Part img1 = request.getPart("foto1");
		Part img2 = request.getPart("foto2");
		Part img3 = request.getPart("foto3");
		
		if (validacionExtensions(img1, img2, img3) ) {
			Foto foto1 = new Foto(UploadFotos(img1,uploads),nuevaMascota);
			Foto foto2 = new Foto(UploadFotos(img2,uploads),nuevaMascota);
			Foto foto3 = new Foto(UploadFotos(img3,uploads),nuevaMascota);
		}
		request.getRequestDispatcher("/MisMascotasController").forward(request, response);
	}
	
	private String UploadFotos(Part part,File pathUploads) throws ServletException, IOException {
		String pathAbsolute = "";
		this.path = getServletContext().getRealPath("/imgs");
		try {
			Path path = Paths.get(part.getSubmittedFileName());
			String fileName = path.getFileName().toString();
			InputStream input = part.getInputStream();
			if (input != null) {
				File file = new File(pathUploads,fileName);
				pathAbsolute = file.getAbsolutePath();
				Path destino = Paths.get(this.path+"/"+file.toPath());
				Files.copy(input, destino );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pathAbsolute;
		
	}
	private boolean isExtension(String fileName) {
		for (String string : this.extensions) {
			if(fileName.toLowerCase().endsWith(string))
				return true;
		}
		return false;
	}
	private boolean validacionExtensions(Part img1,Part img2,Part img3) {
		 return isExtension(img1.getSubmittedFileName()) &&
				 isExtension(img2.getSubmittedFileName()) &&
				 isExtension(img3.getSubmittedFileName());
	}

}
