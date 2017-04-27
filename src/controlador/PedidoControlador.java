package controlador;

import java.util.ArrayList;
import modelo.Pedido;
import modelo.PedidoModelo;
import modelo.Cliente;
import modelo.ClienteModelo;
import modelo.DetallesPedido;
import modelo.DetallesPedidoModelo;
import vista.BezeroenEskariak;
import vista.EskariKontsulta;
import vista.EskariKudeaketa;
import vista.Nagusia;


public class PedidoControlador {
	
	private PedidoModelo pedidoModelo;
	private Nagusia nagusia;
	private EskariKudeaketa eskariKudeaketa;
	private EskariKontsulta eskariKontsulta;
	private ClienteModelo clienteModelo;
	private DetallesPedidoModelo detallesPedidoModelo;
	private BezeroenEskariak bezeroenEskariak;
	
	
	public BezeroenEskariak getBezeroenEskariak() {
		return bezeroenEskariak;
	}
	public void setBezeroenEskariak(BezeroenEskariak bezeroenEskariak) {
		this.bezeroenEskariak = bezeroenEskariak;
	}
	public PedidoModelo getPedidoModelo() {
		return pedidoModelo;
	}
	public void setPedidoModelo(PedidoModelo pedidoModelo) {
		this.pedidoModelo = pedidoModelo;
	}
	public Nagusia getNagusia() {
		return nagusia;
	}
	public void setNagusia(Nagusia nagusia) {
		this.nagusia = nagusia;
	}
	public EskariKudeaketa getEskariKudeaketa() {
		return eskariKudeaketa;
	}
	public void setEskariKudeaketa(EskariKudeaketa eskariKudeaketa) {
		this.eskariKudeaketa = eskariKudeaketa;
	}
	public EskariKontsulta getEskariKontsulta() {
		return eskariKontsulta;
	}
	public void setEskariKontsulta(EskariKontsulta eskariKontsulta) {
		this.eskariKontsulta = eskariKontsulta;
	}
	
	public ClienteModelo getClienteModelo() {
		return clienteModelo;
	}
	public void setClienteModelo(ClienteModelo clienteModelo) {
		this.clienteModelo = clienteModelo;
	}
	
	public DetallesPedidoModelo getDetallesPedidoModelo() {
		return detallesPedidoModelo;
	}
	public void setDetallesPedidoModelo(DetallesPedidoModelo detallesPedidoModelo) {
		this.detallesPedidoModelo = detallesPedidoModelo;
	}
	
	
	public void abrirVentanaEskariKudeaketa() {
		eskariKudeaketa.setVisible(true);
		
	}
	public void abrirVentanaEskariKontsulta() {
		ArrayList<Pedido> pedidos = pedidoModelo.selectAll();
		this.eskariKontsulta.rellenarTablaDePedidos(pedidos);
		eskariKontsulta.setVisible(true);
		
	}
	public void ensenarPedidoYClienteDeSeleccionado(int idPedido, String idCliente) {
		
		Cliente cliente = clienteModelo.select(idCliente);
		ArrayList<DetallesPedido> detallesPedido = detallesPedidoModelo.selectPorIdPedido(idPedido);
		
		eskariKontsulta.rellenarTablaDetallesPedido(detallesPedido);
		eskariKontsulta.rellenarCamposCliente(cliente);
	}
	
	

	
}
