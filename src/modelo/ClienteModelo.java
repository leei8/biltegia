/**
 * 
 */
package modelo;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author enautirakasle 24 mar. 2017
 */

public class ClienteModelo extends Conector {

	
	public ArrayList<Cliente> selectAll() {
		// bezero guztiak itzuliko ditu

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from clientes");
			while (rs.next()) {
				clientes.add(new Cliente(rs.getString("id"), rs.getString("nombre"), rs.getString("direccion"),
						rs.getString("codPostal"), rs.getString("telefono")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public Cliente select(String id) {
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from clientes where id='" + id + "'");
			rs.next();
			Cliente cliente = new Cliente(rs.getString("id"), rs.getString("nombre"), rs.getString("direccion"),
					rs.getString("codPostal"), rs.getString("telefono"));
			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Cliente cliente) {
		try {
			Statement st = super.getConexion().createStatement();
			st.executeUpdate("UPDATE clientes " + "SET nombre='" + cliente.getNombre() + "'," + "direccion='"
					+ cliente.getDireccion() + "'," + "codPostal='" + cliente.getCodPostal() + "'," + "telefono='"
					+ cliente.getTelefono() + "'" + " WHERE id=" + cliente.getId());

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void insert(Cliente cliente) {

		try {
			PreparedStatement pst = super.getConexion().prepareStatement("insert into clientes (id, nombre, direccion, codPostal, telefono) values (?,?,?,?,?)");
			
			pst.setString(1,cliente.getId());
			pst.setString(2,cliente.getNombre());
			pst.setString(3,cliente.getDireccion());
			pst.setString(4,cliente.getCodPostal());
			pst.setString(5,cliente.getTelefono());
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}