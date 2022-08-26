package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.JDBCImplementacionesDAO.PersonaDAO_ANTES;

import modelo.Persona;

@WebServlet("/MisMatchesController")
public class MisMatchesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MisMatchesController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getMatches(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void getMatches(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Llamar al modelo
		MascotaDAO mascotaModelo = new MascotaDAO();
		Mascota miMascota = mascotaModelo.getMascota();
		List<Mascota> matches = miMascota.getMatches();

		// Llamar a la vista
		request.setAttribute("matches", matches);
		request.getRequestDispatcher("/jsp/misMatches.jsp").forward(request, response);
	}

}
