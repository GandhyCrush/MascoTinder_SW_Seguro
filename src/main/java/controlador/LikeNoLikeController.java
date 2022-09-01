package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.DAOFactory;
import modelo.entidades.Mascota;
import modelo.entidades.Match;
import modelo.entidades.Preferencias;

/**
 * Servlet implementation class LikeNoLikeController
 */
@WebServlet("/LikeNoLikeController")
public class LikeNoLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int idMiMascota;
	public LikeNoLikeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));
		Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(idMiMascota);
		Preferencias preferencias = miMascota.getPreferencias();
		List<Mascota> mascotas = DAOFactory.getFactory().getMascotaDAO().getMascotas(preferencias);
		request.setAttribute("mascotas", mascotas);
		request.setAttribute("idMiMascota", idMiMascota);
		enviarAVista(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isLike = Boolean.parseBoolean(request.getParameter("like"));
		int idPretendiente = Integer.parseInt(request.getParameter("idCard").toString().split("mid")[1]);
		if (isLike && idPretendiente != 0) {
			matchControl(request, response,idMiMascota,idPretendiente);
		}
	}

	private void enviarAVista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/likeNolike.jsp").forward(request, response);
	}
	
	private void matchControl(HttpServletRequest request,HttpServletResponse response,int idMiMascota, int idPretendido) throws ServletException, IOException {
		
		Match existMatch = DAOFactory.getFactory().getMatchDAO().isMatch(idPretendido, idMiMascota);
		
		if (existMatch == null) {
			DAOFactory.getFactory().getMatchDAO().createMatch(idMiMascota, idPretendido);
		}else {
			existMatch.setMatch(true);
			DAOFactory.getFactory().getMatchDAO().update(existMatch);
		}
		enviarAVista(request, response);
	}

}
