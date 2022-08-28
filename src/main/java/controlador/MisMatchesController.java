package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.JPADAO.JPAMatchDAO;
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
		JPAMatchDAO misMatches = new JPAMatchDAO();
		List<Mascota> matches = new ArrayList<Mascota>();
		matches = misMatches.getMatches(idMiMascota);
		System.out.println(matches.toString());

		// Llamar a la vista
		request.setAttribute("matches", matches);
		request.getRequestDispatcher("/jsp/misMatches.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
