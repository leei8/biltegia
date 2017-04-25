package main;

import controlador.ClienteControlador;
import controlador.PedidoControlador;
import controlador.ProductoControlador;
import modelo.ClienteModelo;
import modelo.DetallesPedidoModelo;
import modelo.PedidoModelo;
import modelo.ProductoModelo;
import vista.BezeroFormulario;
import vista.BezeroKudeaketa;
import vista.BezeroaBorratu;
import vista.EskariKontsulta;
import vista.EskariKudeaketa;
import vista.Nagusia;

public class Main {

	public static void main(String[] args) {
		
		//Crear controladores
		ClienteControlador clienteControlador = new ClienteControlador();
		ProductoControlador productoControlador = new ProductoControlador();
		PedidoControlador pedidoControlador = new PedidoControlador();
		
		//Crear modelos
		ClienteModelo clienteModelo = new ClienteModelo();
		ProductoModelo productoModelo = new ProductoModelo();
		PedidoModelo pedidoModelo = new PedidoModelo();
		DetallesPedidoModelo detallesPedidoModelo = new DetallesPedidoModelo();
		
		//Crear ventanas
		Nagusia nagusia = new Nagusia();
		BezeroKudeaketa bezeroKudeaketa = new BezeroKudeaketa(nagusia, true);
		BezeroFormulario bezeroFormulario = new BezeroFormulario(bezeroKudeaketa,true);
		BezeroaBorratu bezeroaBorratu = new BezeroaBorratu(bezeroKudeaketa,true);
		
		EskariKudeaketa eskariKudeaketa = new EskariKudeaketa(nagusia, true);
		EskariKontsulta eskariKontsulta = new EskariKontsulta(eskariKudeaketa,true);
		
		nagusia.setClienteControlador(clienteControlador);
		bezeroKudeaketa.setClienteControlador(clienteControlador);
		bezeroFormulario.setClienteControlador(clienteControlador);
		bezeroaBorratu.setClienteControlador(clienteControlador);
		
		nagusia.setProductoControlador(productoControlador);
		
		nagusia.setPedidoControlador(pedidoControlador);
		eskariKudeaketa.setPedidoControlador(pedidoControlador);
		eskariKontsulta.setPedidoControlador(pedidoControlador);
		
		
		//Asignar ventanas y modelos al controlador
		clienteControlador.setNagusia(nagusia);
		clienteControlador.setBezeroKudeaketa(bezeroKudeaketa);
		clienteControlador.setBezeroFormulario(bezeroFormulario);
		clienteControlador.setBezeroaBorratu(bezeroaBorratu);
		clienteControlador.setClienteModelo(clienteModelo);
		
		pedidoControlador.setNagusia(nagusia);
		pedidoControlador.setEskariKudeaketa(eskariKudeaketa);
		pedidoControlador.setEskariKontsulta(eskariKontsulta);
		pedidoControlador.setPedidoModelo(pedidoModelo);
		pedidoControlador.setClienteModelo(clienteModelo);
		pedidoControlador.setDetallesPedidoModelo(detallesPedidoModelo);
		
		nagusia.setVisible(true);
		
	}


}
