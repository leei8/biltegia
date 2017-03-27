/**
 * 
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author enautirakasle
 * 24 mar. 2017
 */
public class ClienteModelo extends Conector{
	
	public ArrayList<Cliente> selectAll(){
		//TODO bezero guztiak itzuliko ditu
		return null;
	}
	
	public Cliente select(String id){
			try {
				Statement st = this.conexion.createStatement();
				ResultSet rs = st.executeQuery("select * from clientes where id='" + id + "'");
				rs.next();
				Cliente cliente = new Cliente(rs.getString("id"), rs.getString("nombre"),
										rs.getString("direccion"), rs.getString("codPostal"),
										rs.getString("telefono"));	
				return cliente;
			} catch (SQLException e) {
				e.printStackTrace();
			}
				return null;
	}
	
	public void update(Cliente cliente){
		//TODO clienteren id-a erabilita update egiten du
	}
	
	public void insert(Cliente cliente){
		//TODO clienteren insert egiten du
	}
	
	
}
