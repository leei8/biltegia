package main;

import controlador.ClienteControlador;
import controlador.ProductoControlador;
import modelo.ClienteModelo;
import modelo.ProductoModelo;
import vista.BezeroFormulario;
import vista.BezeroKudeaketa;
import vista.BezeroaBorratu;
import vista.Nagusia;

public class Main {

	public static void main(String[] args) {
		
		//Crear controladores
		ClienteControlador clienteControlador = new ClienteControlador();
		ProductoControlador productoControlador = new ProductoControlador();
		
		//Crear modelos
		ClienteModelo clienteModelo = new ClienteModelo();
		ProductoModelo productoModelo = new ProductoModelo();
		
		//Crear ventanas
		Nagusia nagusia = new Nagusia();
		BezeroKudeaketa bezeroKudeaketa = new BezeroKudeaketa(nagusia, true);
		BezeroFormulario bezeroFormulario = new BezeroFormulario(bezeroKudeaketa,true);
		BezeroaBorratu bezeroaBorratu = new BezeroaBorratu(bezeroKudeaketa,true);
		
		nagusia.setClienteControlador(clienteControlador);
		bezeroKudeaketa.setClienteControlador(clienteControlador);
		bezeroFormulario.setClienteControlador(clienteControlador);
		bezeroaBorratu.setClienteControlador(clienteControlador);
		
		nagusia.setClienteControlador(clienteControlador);
		
		//Asignar ventanas y modelos al controlador
		clienteControlador.setNagusia(nagusia);
		clienteControlador.setBezeroKudeaketa(bezeroKudeaketa);
		clienteControlador.setBezeroFormulario(bezeroFormulario);
		clienteControlador.setBezeroaBorratu(bezeroaBorratu);
		clienteControlador.setClienteModelo(clienteModelo);
		
		nagusia.setVisible(true);
		
	}

	private static void bezeroKudeaketa(Nagusia nagusia, boolean b) {
		
		
	}

}
