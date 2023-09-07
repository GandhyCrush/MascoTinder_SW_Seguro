package controlador;

import java.io.IOException;
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
	private Persona usuario;
	private Persona matchPropitario;

	public MensajesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarSolicitud(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mensaje newMensaje = new Mensaje(usuario, matchPropitario, request.getParameter("mensaje"));
		DAOFactory.getFactory().getMensajeDAO().create(newMensaje);
		procesarSolicitud(request, response);
	}

	private void ordenarMensajes(List<Mensaje> mensajes) {
		mensajes.sort(new ComparatorMensaje());
	}

	private List<Mensaje> fusionarListas(List<Mensaje> mensajesEnviados, List<Mensaje> mensajesRecibidos) {
		Iterator<Mensaje> iteradorEnviados = mensajesEnviados.iterator();

		while (iteradorEnviados.hasNext()) {
			Mensaje mensaje = iteradorEnviados.next();

			mensajesRecibidos.add(mensaje);
		}

		return mensajesRecibidos;
	}

	private void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		usuario = (Persona) session.getAttribute("usuarioLogeado");
		if (usuario != null && request.getParameter("idMatchMascota") != null) {
			int idMatchMascota = Integer.parseInt(request.getParameter("idMatchMascota"));
			Mascota matchMascota = DAOFactory.getFactory().getMascotaDAO().getById(idMatchMascota);
			matchPropitario = matchMascota.getPropietario();
			List<Mensaje> mensajesEnviados = DAOFactory.getFactory().getMensajeDAO().getMensajes(usuario.getIdPersona(),
					matchPropitario.getIdPersona());
			List<Mensaje> mensajesRecibidos = DAOFactory.getFactory().getMensajeDAO()
					.getMensajes(matchPropitario.getIdPersona(), usuario.getIdPersona());
			List<Mensaje> conversacion = fusionarListas(mensajesEnviados, mensajesRecibidos);
			ordenarMensajes(conversacion);
			request.setAttribute("idUsuario", usuario.getIdPersona());
			request.setAttribute("conversacion", conversacion);
			request.setAttribute("idMatchMascota", idMatchMascota);
			request.getRequestDispatcher("/jsp/mensajes.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/LoginController").forward(request, response);
		}

	}
}
