package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.entidades.Mascota;
import modelo.entidades.Persona;

@WebServlet("/MisMascotasController")
public class MisMascotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MisMascotasController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarSolicitud(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarSolicitud(request, response);
	}

	private void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Persona personaAutorizada = (Persona) session.getAttribute("usuarioLogeado");
		if (personaAutorizada != null) {
			List<Mascota> misMascotas = DAOFactory.getFactory().getMascotaDAO().getMisMascotas(personaAutorizada);
			request.setAttribute("misMascotas", misMascotas);
			request.getRequestDispatcher("/jsp/misMascotas.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/LoginController").forward(request, response);
		}

	}

}
