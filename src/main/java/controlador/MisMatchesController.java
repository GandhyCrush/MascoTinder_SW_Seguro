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

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Llamar al modelo
		int idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));
		System.out.println(idMiMascota);
		List<Mascota> matches = new ArrayList<Mascota>();
		matches = DAOFactory.getFactory().getMatchDAO().getMatches(idMiMascota);
		System.out.println(matches.toString());
		
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getById(idMiMascota);
		System.out.println(mascota.toString());
		
		// Llamar a la vista
		request.setAttribute("matches", matches);
		request.setAttribute("mascota", mascota);
		request.getRequestDispatcher("/jsp/misMatches.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
