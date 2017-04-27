package vista;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ClienteControlador;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;


public class BezeroKudeaketa extends JDialog {
	
	private ClienteControlador clienteControlador;
	

	public ClienteControlador getClienteControlador() {
		return clienteControlador;
	}

	public void setClienteControlador(ClienteControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
	}

	private final JPanel contentPanel = new JPanel();

	public BezeroKudeaketa(Nagusia parent, boolean modal) {
		super(parent,modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JButton btnBezeroBerria = new JButton("Bezero berria");
		btnBezeroBerria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clienteControlador.abrirVentanaBezeroFormulario();
			}
		});
		
		JLabel lblBezeroKudeaketa = new JLabel("BEZERO KUDEAKETA");
		lblBezeroKudeaketa.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnBezeroaBorratu = new JButton("Bezeroa borratu");
		btnBezeroaBorratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteControlador.abrirVentanaBezeroaBorratu();
			}
		});
		
		JButton btnBezeroenEskariak = new JButton("Bezeroaren eskariak ikusi");
		btnBezeroenEskariak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clienteControlador.abrirVentanaBezeroenEskariak();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(118)
					.addComponent(lblBezeroKudeaketa)
					.addContainerGap(153, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBezeroenEskariak, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
						.addComponent(btnBezeroBerria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBezeroaBorratu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(97))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBezeroKudeaketa)
					.addGap(54)
					.addComponent(btnBezeroBerria)
					.addGap(18)
					.addComponent(btnBezeroaBorratu)
					.addGap(18)
					.addComponent(btnBezeroenEskariak)
					.addGap(62))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
