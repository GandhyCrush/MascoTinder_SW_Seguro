package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Especie;
import modelo.entidades.Mascota;
import modelo.entidades.Persona;
import modelo.entidades.Sexo;

@WebServlet("/RegistrarMascotaController")
public class RegistrarMascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		//request.getRequestDispatcher("/PreferenciasController").forward(request, response);
		request.getRequestDispatcher("/MisMascotasController").forward(request, response);
	}

}
