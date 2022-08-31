package controlador;

import java.io.IOException;
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

@WebServlet("/PreferenciasController")
public class PreferenciasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PreferenciasController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));
		
		int idMiMascota = 3;
		Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(idMiMascota);
		
		Preferencias preferencias = DAOFactory.getFactory().getPreferenciasDAO().getPreferenciasByIdMascota(idMiMascota);
		
		if (preferencias != null) {
			request.setAttribute("preferenciasMiMascota", preferencias);
		}
		else {
			request.setAttribute("preferenciasMiMascota", null);
		}
		
		request.setAttribute("miMascota", miMascota);
		request.getRequestDispatcher("/jsp/preferencias.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMiMascota = 3;
		//int idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));
		//String especie = Integer.parseInt(request.getParameter("especie"));
		//String sexo = Integer.parseInt(request.getParameter("sexo"));
		//int edadMinima = Integer.parseInt(request.getParameter("edadMinima"));
		//int edadMaxima = Integer.parseInt(request.getParameter("edadMaxima"));
		
		//Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(idMiMascota);
		
		//Preferencias nuevasPreferenciasMiMascota = new Preferencias(miMascota, Especie.valueOf(especie), Sexo.valueOf(sexo), edadMinima, edadMaxima);
		
		
		
		Preferencias preferenciasMiMascota = DAOFactory.getFactory().getPreferenciasDAO().getPreferenciasByIdMascota(idMiMascota);
		
		if (preferenciasMiMascota != null) {
			DAOFactory.getFactory().getPreferenciasDAO().update(preferenciasMiMascota);
		}
		else {
			DAOFactory.getFactory().getPreferenciasDAO().create(preferenciasMiMascota);
		}
		
		
	}

}
