package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Pedido {
	
	private int id;
	private String idCliente;
	private Date fecha;
	private String codPostal;
	private ArrayList<DetallesPedido> detallesPedidos;
	
	
	public Pedido() {
		super();
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public ArrayList<DetallesPedido> getDetallesPedidos() {
		return detallesPedidos;
	}

	public void setDetallesPedidos(ArrayList<DetallesPedido> detallesPedidos) {
		this.detallesPedidos = detallesPedidos;
	}
	

}
