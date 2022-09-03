package controlador;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.entidades.ComparatorMensaje;
import modelo.entidades.Mascota;
import modelo.entidades.Mensaje;
import modelo.entidades.Persona;

@WebServlet("/MensajesController")
public class MensajesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MensajesController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Persona usuario = (Persona) session.getAttribute("usuarioLogeado");
		
		int idMatchMascota = Integer.parseInt(request.getParameter("idMatchMascota"));
		
		Mascota matchMascota = DAOFactory.getFactory().getMascotaDAO().getById(idMatchMascota);
		
		List<Mensaje> mensajesEnviados = DAOFactory.getFactory().getMensajeDAO().getMensajes(usuario.getIdPersona(), matchMascota.getPropietario().getIdPersona());
		List<Mensaje> mensajesRecibidos = DAOFactory.getFactory().getMensajeDAO().getMensajes(matchMascota.getPropietario().getIdPersona(), usuario.getIdPersona());
		
		List<Mensaje> conversacion = fusionarListas(mensajesEnviados, mensajesRecibidos);
		ordenarMensajes(conversacion);
		
		request.setAttribute("mensajesRecibidos", mensajesRecibidos);
		request.setAttribute("conversacion", conversacion);
		request.getRequestDispatcher("/jsp/mensajes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	private void ordenarMensajes(List<Mensaje> mensajes){
		mensajes.sort(new ComparatorMensaje());
	}
	
	private List<Mensaje> fusionarListas(List<Mensaje> mensajesEnviados, List<Mensaje> mensajesRecibidos){
		Iterator<Mensaje> iteradorEnviados = mensajesEnviados.iterator();
		
		while (iteradorEnviados.hasNext()) {
			Mensaje mensaje = iteradorEnviados.next();
			
			mensajesRecibidos.add(mensaje);
		}
		
		return mensajesRecibidos;
	}
}
