package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Persona;
import utils.PasswordEncryptionUtil;

@WebServlet("/RegistrarPersonaController")
public class RegistrarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrarPersonaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/registrarPersona.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("nombre") != null && request.getParameter("apellido") != null
				&& request.getParameter("username") != null && request.getParameter("clave") != null) {
			String nombre = (String) request.getParameter("nombre");
			String apellido = (String) request.getParameter("apellido");
			String username = (String) request.getParameter("username");
			String clave = (String) request.getParameter("clave");
			String encryptedPassword = PasswordEncryptionUtil.encryptPassword(clave);
			DAOFactory.getFactory().getPersonaDAO().create(new Persona(nombre, apellido, username, encryptedPassword));
			request.getRequestDispatcher("/LoginController").forward(request, response);
		} else {
			request.getRequestDispatcher("/LoginController").forward(request, response);
		}
	}

}
