package controlador;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.ClienteModelo;
import vista.BezeroFormulario;
import vista.BezeroKudeaketa;
import vista.BezeroaBorratu;
import vista.Nagusia;

public class ClienteControlador {

	// ---- Atributos
	private ClienteModelo clienteModelo;
	private Nagusia nagusia;
	private BezeroKudeaketa bezeroKudeaketa;
	private BezeroFormulario bezeroFormulario;
	private BezeroaBorratu bezeroaBorratu;

	// ---- Metodos
	public void abrirVentanaBezeroFormulario() {
		bezeroFormulario.setVisible(true);

	}

	public void abrirVentanaBezeroKudeaketa() {
		bezeroKudeaketa.setVisible(true);
	}

	public void bezeroBerriaSartu(String id, String nombre, String direccion, String codPostal, String telefono) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNombre(nombre);
		cliente.setDireccion(direccion);
		cliente.setCodPostal(codPostal);
		cliente.setTelefono(telefono);

		clienteModelo.insert(cliente);
	}

	
	public void abrirVentanaBezeroaBorratu() {
		ArrayList<Cliente> clientes = clienteModelo.selectAll();
		this.bezeroaBorratu.rellenarCombo(clientes);
		this.bezeroaBorratu.setVisible(true);

	}

	public void borrarCliente(String idCliente) {

		clienteModelo.delete(idCliente);

		// Rellenar de nuevo el formulario
		ArrayList<Cliente> clientes = clienteModelo.selectAll();
		bezeroaBorratu.resetearCombo(clientes);
	}
	

	// ---- Getters y Setters
	public ClienteModelo getClienteModelo() {
		return clienteModelo;
	}

	public void setClienteModelo(ClienteModelo clienteModelo) {
		this.clienteModelo = clienteModelo;
	}

	public Nagusia getNagusia() {
		return nagusia;
	}

	public void setNagusia(Nagusia nagusia) {
		this.nagusia = nagusia;
	}

	public BezeroKudeaketa getBezeroKudeaketa() {
		return bezeroKudeaketa;
	}

	public void setBezeroKudeaketa(BezeroKudeaketa bezeroKudeaketa) {
		this.bezeroKudeaketa = bezeroKudeaketa;
	}

	public BezeroFormulario getBezeroFormulario() {
		return bezeroFormulario;
	}

	public void setBezeroFormulario(BezeroFormulario bezeroFormulario) {
		this.bezeroFormulario = bezeroFormulario;
	}

	public BezeroaBorratu getBezeroaBorratu() {
		return bezeroaBorratu;
	}

	public void setBezeroaBorratu(BezeroaBorratu bezeroaBorratu) {
		this.bezeroaBorratu = bezeroaBorratu;
	}

}
