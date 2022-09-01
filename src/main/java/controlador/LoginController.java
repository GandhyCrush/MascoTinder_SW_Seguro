package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.entidades.Persona;



@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("username");
		String clave = request.getParameter("clave");	
		Persona personaAutorizada = DAOFactory.getFactory().getPersonaDAO().autorizarPersona(usuario, clave);
		if (personaAutorizada != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado",personaAutorizada);
			request.getRequestDispatcher("/MisMascotasController").forward(request, response);
		}else {
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
		
	}

}
