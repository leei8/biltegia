package vista;

import java.awt.BorderLayout;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.PedidoControlador;
import modelo.Cliente;
import modelo.DetallesPedido;
import modelo.Pedido;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EskariKontsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableListado;
	private JTable tableDetalles;
	private JTextField textField_Nombre;
	private JTextField textField_Telefono;
	private JTextField textField_Direccion;
	private JTextField textField_CodPostal;

	private PedidoControlador pedidoControlador;

	public PedidoControlador getPedidoControlador() {
		return pedidoControlador;
	}

	public void setPedidoControlador(PedidoControlador pedidoControlador) {
		this.pedidoControlador = pedidoControlador;
	}

	public EskariKontsulta(EskariKudeaketa parent, boolean modal) {
		super(parent, modal);
		setBounds(100, 100, 605, 348);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane_Listado = new JScrollPane();
		scrollPane_Listado.setBounds(10, 36, 267, 173);
		contentPanel.add(scrollPane_Listado);

		tableListado = new JTable();
		tableListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					mouseClickedTablaPedidos();
				}
		});
		scrollPane_Listado.setViewportView(tableListado);

		JLabel lblListadoDePedidos = new JLabel("LISTADO DE PEDIDOS");
		lblListadoDePedidos.setBounds(70, 11, 169, 14);
		contentPanel.add(lblListadoDePedidos);

		JLabel lblDetallesDelPedido = new JLabel("DETALLES DEL PEDIDO");
		lblDetallesDelPedido.setBounds(379, 11, 138, 14);
		contentPanel.add(lblDetallesDelPedido);

		JScrollPane scrollPane_Detalles = new JScrollPane();
		scrollPane_Detalles.setBounds(301, 36, 267, 171);
		contentPanel.add(scrollPane_Detalles);

		tableDetalles = new JTable();
		scrollPane_Detalles.setViewportView(tableDetalles);

		JLabel lblDetallesDelCliente = new JLabel("DETALLES DEL CLIENTE");
		lblDetallesDelCliente.setBounds(35, 221, 191, 14);
		contentPanel.add(lblDetallesDelCliente);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 246, 62, 14);
		contentPanel.add(lblNombre);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 271, 62, 14);
		contentPanel.add(lblTelefono);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(301, 243, 59, 14);
		contentPanel.add(lblDireccion);

		JLabel lblCodigoPostal = new JLabel("Codigo Postal:");
		lblCodigoPostal.setBounds(301, 268, 86, 14);
		contentPanel.add(lblCodigoPostal);

		textField_Nombre = new JTextField();
		textField_Nombre.setEditable(false);
		textField_Nombre.setBounds(76, 243, 201, 20);
		contentPanel.add(textField_Nombre);
		textField_Nombre.setColumns(10);

		textField_Telefono = new JTextField();
		textField_Telefono.setEditable(false);
		textField_Telefono.setBounds(76, 268, 201, 20);
		contentPanel.add(textField_Telefono);
		textField_Telefono.setColumns(10);

		textField_Direccion = new JTextField();
		textField_Direccion.setEditable(false);
		textField_Direccion.setBounds(387, 240, 191, 20);
		contentPanel.add(textField_Direccion);
		textField_Direccion.setColumns(10);

		textField_CodPostal = new JTextField();
		textField_CodPostal.setEditable(false);
		textField_CodPostal.setBounds(387, 265, 191, 20);
		contentPanel.add(textField_CodPostal);
		textField_CodPostal.setColumns(10);
	}

	protected void mouseClickedTablaPedidos() {
		int lineaSeleccionada = tableListado.getSelectedRow();
		int idPedido = (int)tableListado.getModel().getValueAt(lineaSeleccionada, 0);
		String idCliente = (String)tableListado.getModel().getValueAt(lineaSeleccionada, 1);
		
		this.pedidoControlador.ensenarPedidoYClienteDeSeleccionado(idPedido,idCliente);
	}

	public void rellenarTablaDePedidos(ArrayList<Pedido> pedidos) {
		// modeloa sortu
		DefaultTableModel defaultTableModel = new DefaultTableModel();

		// cabecerako arraya sortu eta modeloari ezarri
		Object[] cabecera = { "ID", "ID CLIENTE", "FECHA" };
		defaultTableModel.setColumnIdentifiers(cabecera);

		// modeloa datuekin bete
		for (Pedido pedido : pedidos) {

			Object[] linea = { pedido.getId(), pedido.getIdCliente(), pedido.getFecha() };
			defaultTableModel.addRow(linea);
		}

		// modeloa taulari ezarri
		tableListado.setModel(defaultTableModel);

		// taula ordenagarria bihurtu
		TableRowSorter<DefaultTableModel> modeloOrdenado;
		modeloOrdenado = new TableRowSorter<DefaultTableModel>(defaultTableModel);
		tableListado.setRowSorter(modeloOrdenado);
	}

	public void rellenarCamposCliente(Cliente cliente) {
		this.textField_Nombre.setText(cliente.getNombre());
		this.textField_Direccion.setText(cliente.getDireccion());
		this.textField_Telefono.setText(cliente.getTelefono());
		this.textField_CodPostal.setText(cliente.getCodPostal());
	}

	public void rellenarTablaDetallesPedido(ArrayList<DetallesPedido> detallesPedido) {
		// modeloa sortu
				DefaultTableModel defaultTableModel = new DefaultTableModel();

				// cabecerako arraya sortu eta modeloari ezarri
				Object[] cabecera = { "ID PEDIDO", "ID PRODUCTO", "CANTIDAD" };
				defaultTableModel.setColumnIdentifiers(cabecera);

				// modeloa datuekin bete
				for (DetallesPedido detallesdepedido : detallesPedido) {

					Object[] linea = { detallesdepedido.getIdPedido(),detallesdepedido.getIdProducto(), detallesdepedido.getCantidad() };
					defaultTableModel.addRow(linea);
				}

				// modeloa taulari ezarri
				tableDetalles.setModel(defaultTableModel);

				// taula ordenagarria bihurtu
				TableRowSorter<DefaultTableModel> modeloOrdenado;
				modeloOrdenado = new TableRowSorter<DefaultTableModel>(defaultTableModel);
				tableDetalles.setRowSorter(modeloOrdenado);
			}

}
