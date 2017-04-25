package vista;

import java.awt.BorderLayout;

import java.util.ArrayList;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controlador.PedidoControlador;
import modelo.Pedido;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		scrollPane_Listado.setViewportView(tableListado);

		JLabel lblListadoDePedidos = new JLabel("LISTADO DE PEDIDOS");
		lblListadoDePedidos.setBounds(70, 11, 169, 14);
		contentPanel.add(lblListadoDePedidos);

		JLabel lblDetallesDelPedido = new JLabel("DETALLES DEL PEDIDO");
		lblDetallesDelPedido.setBounds(379, 11, 121, 14);
		contentPanel.add(lblDetallesDelPedido);

		JScrollPane scrollPane_Detalles = new JScrollPane();
		scrollPane_Detalles.setBounds(301, 36, 267, 171);
		contentPanel.add(scrollPane_Detalles);

		tableDetalles = new JTable();
		scrollPane_Detalles.setViewportView(tableDetalles);

		JLabel lblDetallesDelCliente = new JLabel("DETALLES DEL CLIENTE");
		lblDetallesDelCliente.setBounds(77, 221, 121, 14);
		contentPanel.add(lblDetallesDelCliente);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(42, 246, 46, 14);
		contentPanel.add(lblNombre);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(42, 271, 46, 14);
		contentPanel.add(lblTelefono);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(273, 246, 59, 14);
		contentPanel.add(lblDireccion);

		JLabel lblCodigoPostal = new JLabel("Codigo Postal:");
		lblCodigoPostal.setBounds(273, 271, 74, 14);
		contentPanel.add(lblCodigoPostal);

		textField_Nombre = new JTextField();
		textField_Nombre.setEditable(false);
		textField_Nombre.setEnabled(false);
		textField_Nombre.setBounds(98, 243, 158, 20);
		contentPanel.add(textField_Nombre);
		textField_Nombre.setColumns(10);

		textField_Telefono = new JTextField();
		textField_Telefono.setEnabled(false);
		textField_Telefono.setEditable(false);
		textField_Telefono.setBounds(98, 268, 158, 20);
		contentPanel.add(textField_Telefono);
		textField_Telefono.setColumns(10);

		textField_Direccion = new JTextField();
		textField_Direccion.setEditable(false);
		textField_Direccion.setEnabled(false);
		textField_Direccion.setBounds(359, 243, 191, 20);
		contentPanel.add(textField_Direccion);
		textField_Direccion.setColumns(10);

		textField_CodPostal = new JTextField();
		textField_CodPostal.setEditable(false);
		textField_CodPostal.setEnabled(false);
		textField_CodPostal.setBounds(359, 268, 191, 20);
		contentPanel.add(textField_CodPostal);
		textField_CodPostal.setColumns(10);
	}

	public void rellenarTablaDePedidos(ArrayList<Pedido> pedidos) {
		// modeloa sortu
		DefaultTableModel defaultTableModel = new DefaultTableModel();

		// cabecerako arraya sortu eta modeloari ezarri
		Object[] cabecera = { "ID", "ID CLIENTE", "FECHA"};
		defaultTableModel.setColumnIdentifiers(cabecera);

		// modeloa datuekin bete
		for (Pedido pedido : pedidos) {

			Object[] linea = { pedido.getId(), pedido.getIdCliente(), pedido.getFecha()};
			defaultTableModel.addRow(linea);
		}

		// modeloa taulari ezarri
		tableListado.setModel(defaultTableModel);

		// taula ordenagarria bihurtu
		TableRowSorter<DefaultTableModel> modeloOrdenado;
		modeloOrdenado = new TableRowSorter<DefaultTableModel>(defaultTableModel);
		tableListado.setRowSorter(modeloOrdenado);
	}

}
