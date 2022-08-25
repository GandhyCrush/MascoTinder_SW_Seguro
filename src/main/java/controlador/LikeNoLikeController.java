package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.conexion.Mascota;
import modelo.conexion.MascotaDAO;

/**
 * Servlet implementation class LikeNoLikeController
 */
@WebServlet("/LikeNoLikeController")
public class LikeNoLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LikeNoLikeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarSolicitud(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean match = Boolean.parseBoolean(request.getParameter("match"));
		
		procesarSolicitud(request, response);
	}

	private void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener Parametros
		// Hablar con el modelo
		MascotaDAO mascotaModelo = new MascotaDAO();
		List<Mascota> mascotas = mascotaModelo.getMascotas();
		// Envio a la vista
		request.setAttribute("mascotas", mascotas);
		request.getRequestDispatcher("/jsp/likeNolike.jsp").forward(request, response);
	}

}
