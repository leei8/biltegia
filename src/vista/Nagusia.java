package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ClienteControlador;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Nagusia extends JFrame {

	private JPanel contentPane;
	
	private ClienteControlador clienteControlador;
	
	
	public ClienteControlador getClienteControlador() {
		return clienteControlador;
	}


	public void setClienteControlador(ClienteControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
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
		btnBezeroKudeaketa.setBounds(132, 101, 177, 23);
		contentPane.add(btnBezeroKudeaketa);
		
		JButton btnProduktuKudeaketa = new JButton("Produktu Kudeaketa");
		btnProduktuKudeaketa.setBounds(132, 160, 177, 23);
		contentPane.add(btnProduktuKudeaketa);
		
		JLabel lblBiltegia = new JLabel("BILTEGIA");
		lblBiltegia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBiltegia.setBounds(173, 25, 136, 14);
		contentPane.add(lblBiltegia);
	}
}
