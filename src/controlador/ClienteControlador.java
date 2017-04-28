package controlador;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.ClienteModelo;
import modelo.DetallesPedido;
import modelo.DetallesPedidoModelo;
import modelo.Pedido;
import modelo.PedidoModelo;
import modelo.Producto;
import modelo.ProductoModelo;
import vista.BezeroFormulario;
import vista.BezeroKudeaketa;
import vista.BezeroaBorratu;
import vista.BezeroenEskariak;
import vista.Nagusia;

public class ClienteControlador {

	// ---- Atributos
	private ClienteModelo clienteModelo;
	private Nagusia nagusia;
	private BezeroKudeaketa bezeroKudeaketa;
	private BezeroFormulario bezeroFormulario;
	private BezeroaBorratu bezeroaBorratu;
	private BezeroenEskariak bezeroenEskariak;
	private PedidoModelo pedidoModelo;
	private DetallesPedidoModelo detallesPedidoModelo;
	private ProductoModelo productoModelo;

	

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

	public void abrirVentanaBezeroenEskariak() {
		ArrayList<Cliente> clientes = clienteModelo.selectAll();
		this.bezeroenEskariak.rellenarListaClientes(clientes);
		this.bezeroenEskariak.setVisible(true);

	}

	public void ensenarPedidosDeCliente(String idCliente) {
		Cliente clienteSeleccionado = clienteModelo.select(idCliente);
		ArrayList<Pedido> pedidosCliente = pedidoModelo.selectPorIdCliente(idCliente);
		
		bezeroenEskariak.rellenarTablaPedidosDeCliente(pedidosCliente);
	}
	
	public void ensenarDetallesDePedido(int idPedido) {
		
		ArrayList<DetallesPedido> detallesDePedido = detallesPedidoModelo.selectPorIdPedido(idPedido);
		
		for(DetallesPedido detallesPedido: detallesDePedido){
			Producto producto = this.productoModelo.select(detallesPedido.getIdProducto());
			detallesPedido.setProducto(producto);
		}
		this.bezeroenEskariak.rellenarTablaDetallesDePedido(detallesDePedido);
	}


	

	// ---- Getters y Setters
	
	public ProductoModelo getProductoModelo() {
		return productoModelo;
	}

	public void setProductoModelo(ProductoModelo productoModelo) {
		this.productoModelo = productoModelo;
	}
	
	public PedidoModelo getPedidoModelo() {
		return pedidoModelo;
	}

	public void setPedidoModelo(PedidoModelo pedidoModelo) {
		this.pedidoModelo = pedidoModelo;
	}

	public DetallesPedidoModelo getDetallesPedidoModelo() {
		return detallesPedidoModelo;
	}

	public void setDetallesPedidoModelo(DetallesPedidoModelo detallesPedidoModelo) {
		this.detallesPedidoModelo = detallesPedidoModelo;
	}
	
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

	public BezeroenEskariak getBezeroenEskariak() {
		return bezeroenEskariak;
	}

	public void setBezeroenEskariak(BezeroenEskariak bezeroenEskariak) {
		this.bezeroenEskariak = bezeroenEskariak;
	}

}
