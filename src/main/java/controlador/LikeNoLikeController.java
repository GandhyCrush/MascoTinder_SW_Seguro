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
		int idSession = 0;
		int idMiMascota = 1;
		int idPretendido = Integer.parseInt(request.getParameter("idCard").toString().split("mid")[1]);
		matchControl(request, response,idMiMascota,idPretendido);
		

	}

	private void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener Parametros
		// Hablar con el modelo
		Preferencias preferencias = new Preferencias(Especie.PERRO, Sexo.MACHO,1 , 4);		
		List<Mascota> mascotas = DAOFactory.getFactory().getMascotaDAO().getMascotas(preferencias);
		// Envio a la vista
		request.setAttribute("match",false);
		request.setAttribute("mascotas", mascotas);
		request.getRequestDispatcher("/jsp/likeNolike.jsp").forward(request, response);
	}
	private void matchControl(HttpServletRequest request,HttpServletResponse response,int idMiMascota, int idPretendido) throws ServletException, IOException {
		
		boolean existMatch = DAOFactory.getFactory().getMatchDAO().isMatch(idPretendido, idMiMascota);
		if (!existMatch) {
			DAOFactory.getFactory().getMatchDAO().createMatch(idMiMascota, idPretendido);
			request.setAttribute("match",false);
			request.getRequestDispatcher("/jsp/likeNolike.jsp").forward(request, response);
		}else {
			request.setAttribute("match",true);
			request.getRequestDispatcher("/jsp/likeNolike.jsp").forward(request, response);
		}
	}

}
