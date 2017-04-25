package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DetallesPedidoModelo extends Conector {


	public ArrayList<DetallesPedido> selectPorIdPedido(int idPedido) {
	
		ArrayList<DetallesPedido> detallespedidos = new ArrayList<DetallesPedido>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from detallespedidos where idPedido='"+ idPedido + "'");
			while (rs.next()) {
				DetallesPedido detallespedido = new DetallesPedido();
				detallespedido.setIdPedido(rs.getInt("idPedido"));
				detallespedido.setIdProducto(rs.getInt("idProducto"));
				detallespedido.setCantidad(rs.getInt("cantidad"));
				
				detallespedidos.add(detallespedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detallespedidos;
	}

}
