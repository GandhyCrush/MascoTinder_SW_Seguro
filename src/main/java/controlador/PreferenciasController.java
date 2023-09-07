package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.entidades.Especie;
import modelo.entidades.Persona;
import modelo.entidades.Preferencias;
import modelo.entidades.Sexo;

@WebServlet("/PreferenciasController")
public class PreferenciasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int idMiMascota = 0;

	public PreferenciasController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Persona personaAutorizada = (Persona) session.getAttribute("usuarioLogeado");
		if (request.getParameter("idMiMascota") != null && personaAutorizada != null) {

			idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));

			Preferencias preferenciasMiMascota = DAOFactory.getFactory().getPreferenciasDAO()
					.getPreferenciasByIdMascota(idMiMascota);

			request.setAttribute("preferenciasMiMascota", preferenciasMiMascota);
			request.getRequestDispatcher("/jsp/preferencias.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/LoginController").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String especie = request.getParameter("especie");
		String sexo = request.getParameter("sexo");
		if (sexo.equals("null") && especie.equals("null") && request.getParameter("edadMinima").equals("")
				&& request.getParameter("edadMaxima").equals("")) {
			request.getRequestDispatcher("/MisMascotasController").forward(request, response);

		} else {
			int edadMinima = Integer.parseInt(request.getParameter("edadMinima"));
			int edadMaxima = Integer.parseInt(request.getParameter("edadMaxima"));

			Preferencias preferenciasMiMascota = DAOFactory.getFactory().getPreferenciasDAO()
					.getPreferenciasByIdMascota(idMiMascota);

			preferenciasMiMascota.setEspecie(Especie.valueOf(especie));
			preferenciasMiMascota.setSexo(Sexo.valueOf(sexo));
			preferenciasMiMascota.setEdadMinima(edadMinima);
			preferenciasMiMascota.setEdadMaxima(edadMaxima);

			DAOFactory.getFactory().getPreferenciasDAO().update(preferenciasMiMascota);

			request.getRequestDispatcher("/MisMascotasController").forward(request, response);
		}
	}

}
