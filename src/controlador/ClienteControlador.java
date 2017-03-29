package controlador;

import modelo.Cliente;
import modelo.ClienteModelo;
import vista.BezeroFormulario;
import vista.BezeroKudeaketa;
import vista.BezeroaBorratu;
import vista.Nagusia;

/**
 * @author leei8 28 mar. 2017
 */

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
		bezeroaBorratu.setVisible(true);

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
