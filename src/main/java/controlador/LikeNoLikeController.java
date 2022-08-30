package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.DAOFactory;
import modelo.entidades.Especie;
import modelo.entidades.Mascota;
import modelo.entidades.Match;
import modelo.entidades.Preferencias;
import modelo.entidades.Sexo;

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


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isLike = Boolean.parseBoolean(request.getParameter("like"));
		//Persona duenio = (Persona) request.getAttribute("duenio");
		int idMiMascota = 3;
		int idPretendiente = Integer.parseInt(request.getParameter("idCard").toString().split("mid")[1]);
		if (isLike && idPretendiente != 0) {
			matchControl(request, response,idMiMascota,idPretendiente);
		}
	}

	private void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Preferencias duenio = (Preferencias) request.getAttribute("preferencias");
		//int idMiMascota = Integer.parseInt(request.getParameter("idCard").toString().split("mid")[1]);
		Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(3);
		Preferencias preferencias = new Preferencias(miMascota,Especie.GATO, Sexo.MACHO,1 , 4);		
		List<Mascota> mascotas = DAOFactory.getFactory().getMascotaDAO().getMascotas(preferencias);
		request.setAttribute("mascotas", mascotas);
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
		procesarSolicitud(request, response);
	}

}
