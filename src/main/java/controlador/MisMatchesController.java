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

@WebServlet("/MisMatchesController")
public class MisMatchesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MisMatchesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Persona personaAutorizada = (Persona) session.getAttribute("usuarioLogeado");
		if (personaAutorizada != null && request.getParameter("idMiMascota") != null) {
			int idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));
			List<Mascota> matches;
			matches = DAOFactory.getFactory().getMatchDAO().getMatches(idMiMascota);
			Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getById(idMiMascota);
			request.setAttribute("matches", matches);
			request.setAttribute("mascota", mascota);
			request.getRequestDispatcher("/jsp/misMatches.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/LoginController").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// En esta instancia no se manda ninguna solicitud por POST
	}

}
