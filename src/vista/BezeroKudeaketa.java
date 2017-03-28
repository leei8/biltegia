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
		
		JButton btnBezeroak = new JButton("Bezeroak");
		btnBezeroak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnConsulta = new JButton("Kontsulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnBezeroBerria = new JButton("Bezero berria");
		btnBezeroBerria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clienteControlador.abrirVentanaBezeroFormulario();
			}
		});
		
		JLabel lblBezeroKudeaketa = new JLabel("BEZERO KUDEAKETA");
		lblBezeroKudeaketa.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(118)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBezeroBerria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblBezeroKudeaketa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBezeroak, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnConsulta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(153, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBezeroKudeaketa)
					.addGap(18)
					.addComponent(btnBezeroBerria)
					.addGap(18)
					.addComponent(btnBezeroak)
					.addGap(18)
					.addComponent(btnConsulta)
					.addGap(98))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
