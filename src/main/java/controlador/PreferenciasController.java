package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Especie;
import modelo.entidades.Preferencias;
import modelo.entidades.Sexo;

@WebServlet("/PreferenciasController")
public class PreferenciasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int idMiMascota = 0;
	
    public PreferenciasController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));
		
		Preferencias preferenciasMiMascota = DAOFactory.getFactory().getPreferenciasDAO().getPreferenciasByIdMascota(idMiMascota);
		
		request.setAttribute("preferenciasMiMascota", preferenciasMiMascota);
		request.getRequestDispatcher("/jsp/preferencias.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String especie = request.getParameter("especie");
		String sexo = request.getParameter("sexo");
		int edadMinima = Integer.parseInt(request.getParameter("edadMinima"));
		int edadMaxima = Integer.parseInt(request.getParameter("edadMaxima"));
		
		Preferencias preferenciasMiMascota = DAOFactory.getFactory().getPreferenciasDAO().getPreferenciasByIdMascota(idMiMascota);
		
		preferenciasMiMascota.setEspecie(Especie.valueOf(especie));
		preferenciasMiMascota.setSexo(Sexo.valueOf(sexo));
		preferenciasMiMascota.setEdadMinima(edadMinima);
		preferenciasMiMascota.setEdadMaxima(edadMaxima);
		
		DAOFactory.getFactory().getPreferenciasDAO().update(preferenciasMiMascota);
		
		request.getRequestDispatcher("/MisMascotasController").forward(request, response);
	}

}
