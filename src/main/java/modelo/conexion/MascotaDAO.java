package modelo.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

	public MascotaDAO() {

	}

	public List<Mascota> getMascotas() {
		String sql = "SELECT * FROM MASCOTA";
		Connection cnn = null;
		ResultSet rs = null;
		List<Mascota> mascotas = new ArrayList<Mascota>();
		cnn = ConexionBDD.getConexion();
		try {
			rs = cnn.prepareStatement(sql).executeQuery();
			while (rs.next()) {
				
				Mascota p = new Mascota(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				mascotas.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionBDD.cerrar(rs);
		}
		return mascotas;
	}

}
