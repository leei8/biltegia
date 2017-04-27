package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.ClienteControlador;
import controlador.PedidoControlador;
import modelo.Cliente;
import modelo.Pedido;

import javax.swing.JList;
import javax.swing.DefaultListModel;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BezeroenEskariak extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaPedidosDeCliente;
	private JTable tablaDetallesPedido;
	private JTextField precioPedido;
	private JList listaClientes;
	private ClienteControlador clienteControlador;
	private PedidoControlador pedidoControlador;
	

	public PedidoControlador getPedidoControlador() {
		return pedidoControlador;
	}

	public void setPedidoControlador(PedidoControlador pedidoControlador) {
		this.pedidoControlador = pedidoControlador;
	}

	public ClienteControlador getClienteControlador() {
		return clienteControlador;
	}

	public void setClienteControlador(ClienteControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
	}

	public BezeroenEskariak(BezeroKudeaketa parent, boolean modal) {
		super(parent, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblClientes = new JLabel("CLIENTES");
		lblClientes.setBounds(66, 11, 70, 14);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 28, 205, 128);
		contentPanel.add(scrollPane);
		
				listaClientes = new JList();
				scrollPane.setViewportView(listaClientes);
				listaClientes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						listaClientesMouseClicked();
					}
				});
		contentPanel.add(lblClientes);

		JScrollPane scrollPedidosDeCliente = new JScrollPane();
		scrollPedidosDeCliente.addMouseListener(new MouseAdapter() {
			
		});
		scrollPedidosDeCliente.setBounds(230, 28, 189, 128);
		contentPanel.add(scrollPedidosDeCliente);

		tablaPedidosDeCliente = new JTable();
		tablaPedidosDeCliente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				tablaPedidosDeClienteMouseClicked();
			}
		});
		scrollPedidosDeCliente.setViewportView(tablaPedidosDeCliente);

		JLabel lblPedidosDelCliente = new JLabel("PEDIDOS DEL CLIENTE");
		lblPedidosDelCliente.setBounds(248, 11, 147, 14);
		contentPanel.add(lblPedidosDelCliente);

		JScrollPane scrollDetallesPedido = new JScrollPane();
		scrollDetallesPedido.setBounds(15, 181, 264, 69);
		contentPanel.add(scrollDetallesPedido);

		tablaDetallesPedido = new JTable();
		scrollDetallesPedido.setViewportView(tablaDetallesPedido);

		JLabel lblDetallesDelPedido = new JLabel("DETALLES DEL PEDIDO");
		lblDetallesDelPedido.setBounds(25, 167, 155, 14);
		contentPanel.add(lblDetallesDelPedido);

		JLabel lblPrecioDelPedido = new JLabel("Precio del pedido:");
		lblPrecioDelPedido.setBounds(308, 180, 111, 25);
		contentPanel.add(lblPrecioDelPedido);

		precioPedido = new JTextField();
		precioPedido.setEditable(false);
		precioPedido.setBounds(297, 202, 107, 34);
		contentPanel.add(precioPedido);
		precioPedido.setColumns(10);
	}

	protected void tablaPedidosDeClienteMouseClicked() {
	//	int pedidoSeleccionado = tablaPedidosDeClientes.
		
	}

	protected void listaClientesMouseClicked() {
		int lineaSeleccionada = listaClientes.getSelectedIndex();
		String cliente = (String) this.listaClientes.getModel().getElementAt(lineaSeleccionada);
		String[] partes = cliente.split(",");
		String idCliente = (partes[0]);

		this.clienteControlador.ensenarPedidosDeCliente(idCliente);
	}

	public void rellenarListaClientes(ArrayList<Cliente> clientes) {

		DefaultListModel defaultListModel = new DefaultListModel();

		for (Cliente cliente : clientes) {
			defaultListModel.addElement(cliente.getId() + ", " + cliente.getNombre());
		}
		listaClientes.setModel(defaultListModel);
	}

	public void rellenarTablaPedidosDeCliente(ArrayList<Pedido> pedidosCliente) {

		DefaultTableModel defaultTableModel = new DefaultTableModel();

		Object[] cabecera = { "ID", "FECHA", "CP" };
		defaultTableModel.setColumnIdentifiers(cabecera);

		for (Pedido pedido : pedidosCliente) {

			Object[] linea = { pedido.getId(), pedido.getFecha(), pedido.getCodPostal()};
			defaultTableModel.addRow(linea);
		}

		this.tablaPedidosDeCliente.setModel(defaultTableModel);

		TableRowSorter<DefaultTableModel> modeloOrdenado;
		modeloOrdenado = new TableRowSorter<DefaultTableModel>(defaultTableModel);
		tablaPedidosDeCliente.setRowSorter(modeloOrdenado);
	}

}
