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

@WebServlet("/LikeNoLikeController")
public class LikeNoLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idMiMascota;
	public LikeNoLikeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));
		Preferencias preferenciasMiMascota = DAOFactory.getFactory().getPreferenciasDAO().getPreferenciasByIdMascota(idMiMascota);
		if (existePreferencias(preferenciasMiMascota)) {
			List<Mascota> mascotas = DAOFactory.getFactory().getMascotaDAO().getMascotas(preferenciasMiMascota);
			request.setAttribute("mascotas", mascotas);
			request.setAttribute("idMiMascota", idMiMascota);
			mostrarVista(request, response);
		}else {
			request.getRequestDispatcher("/PreferenciasController").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isLike = Boolean.parseBoolean(request.getParameter("like"));
		int idMascotaPretendiente = Integer.parseInt(request.getParameter("idCard").toString().split("mid")[1]);
		if (isLike && idMascotaPretendiente != 0) {
			controlarMatch(request, response,idMascotaPretendiente);
		}else if (idMascotaPretendiente == 0) {
			request.getRequestDispatcher("/PreferenciasController").forward(request, response);
		}
	}

	private void mostrarVista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/likeNolike.jsp").forward(request, response);
	}
	
	private void controlarMatch(HttpServletRequest request,HttpServletResponse response, int idPretendido) throws ServletException, IOException {
		
		Match matchExistente = DAOFactory.getFactory().getMatchDAO().isMatch(idPretendido, this.idMiMascota);
		
		if (matchExistente == null) {
			DAOFactory.getFactory().getMatchDAO().createMatch(this.idMiMascota, idPretendido);
		}else {
			matchExistente.setMatch(true);
			DAOFactory.getFactory().getMatchDAO().update(matchExistente);
		}
		mostrarVista(request, response);
	}
	private boolean existePreferencias(Preferencias preferences) {
		return preferences != null;
	}

}
