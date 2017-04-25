package controlador;

import java.util.ArrayList;
import modelo.Pedido;
import modelo.PedidoModelo;
import vista.EskariKontsulta;
import vista.EskariKudeaketa;
import vista.Nagusia;

public class PedidoControlador {
	
	private PedidoModelo pedidoModelo;
	private Nagusia nagusia;
	private EskariKudeaketa eskariKudeaketa;
	private EskariKontsulta eskariKontsulta;
	
	
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
	public void abrirVentanaEskariKudeaketa() {
		eskariKudeaketa.setVisible(true);
		
	}
	public void abrirVentanaEskariKontsulta() {
		ArrayList<Pedido> pedidos = pedidoModelo.selectAll();
		this.eskariKontsulta.rellenarTablaDePedidos(pedidos);
		eskariKontsulta.setVisible(true);
		
	}
	
	

	
}
