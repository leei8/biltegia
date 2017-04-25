package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ClienteControlador;
import controlador.PedidoControlador;
import controlador.ProductoControlador;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Nagusia extends JFrame {

	private JPanel contentPane;

	private ClienteControlador clienteControlador;
	private ProductoControlador productoControlador;
	private PedidoControlador pedidoControlador;

	
	public ClienteControlador getClienteControlador() {
		return clienteControlador;
	}

	public void setClienteControlador(ClienteControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
	}

	public ProductoControlador getProductoControlador() {
		return productoControlador;
	}

	public void setProductoControlador(ProductoControlador productoControlador) {
		this.productoControlador = productoControlador;
	}

	public PedidoControlador getPedidoControlador() {
		return pedidoControlador;
	}

	public void setPedidoControlador(PedidoControlador pedidoControlador) {
		this.pedidoControlador = pedidoControlador;
	}

	public Nagusia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBezeroKudeaketa = new JButton("Bezero Kudeaketa");
		btnBezeroKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteControlador.abrirVentanaBezeroKudeaketa();
			}
		});
		btnBezeroKudeaketa.setBounds(132, 77, 177, 23);
		contentPane.add(btnBezeroKudeaketa);

		JButton btnProduktuKudeaketa = new JButton("Produktu Kudeaketa");
		btnProduktuKudeaketa.setBounds(132, 122, 177, 23);
		contentPane.add(btnProduktuKudeaketa);

		JLabel lblBiltegia = new JLabel("BILTEGIA");
		lblBiltegia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBiltegia.setBounds(173, 25, 136, 14);
		contentPane.add(lblBiltegia);

		JButton btnEskariKudeaketa = new JButton("Eskari Kudeaketa");
		btnEskariKudeaketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedidoControlador.abrirVentanaEskariKudeaketa();
			}
		});
		btnEskariKudeaketa.setBounds(132, 165, 177, 23);
		contentPane.add(btnEskariKudeaketa);
	}
}
