package controlador;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.DAOFactory;
import modelo.entidades.Mascota;

@WebServlet("/MisMatchesController")
public class MisMatchesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MisMatchesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));
		List<Mascota> matches = new ArrayList<>();
		matches = DAOFactory.getFactory().getMatchDAO().getMatches(idMiMascota);
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getById(idMiMascota);
		request.setAttribute("matches", matches);
		request.setAttribute("mascota", mascota);
		request.getRequestDispatcher("/jsp/misMatches.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//En esta instancia no se manda ninguna solicitud por POST
	}

}
