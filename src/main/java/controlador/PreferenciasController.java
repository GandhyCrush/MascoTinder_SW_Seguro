package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Mascota;
import modelo.entidades.Preferencias;

@WebServlet("/PreferenciasController")
public class PreferenciasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PreferenciasController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMiMascota = 3;
		Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(idMiMascota);
		
		Preferencias preferencias = DAOFactory.getFactory().getPreferenciasDAO().getPreferenciasByIdMascota(idMiMascota);
		
		if (preferencias != null) {
			request.setAttribute("preferenciasMiMascota", preferencias);
		}
		
		request.setAttribute("miMascota", miMascota);
		request.getRequestDispatcher("/jsp/preferencias.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMiMascota = 3;
		
		Preferencias preferenciasMiMascota = DAOFactory.getFactory().getPreferenciasDAO().getPreferenciasByIdMascota(idMiMascota);
		
		DAOFactory.getFactory().getPreferenciasDAO().update(preferenciasMiMascota);
	}

}
