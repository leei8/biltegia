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
		
		JButton btnBezeroaBorratu = new JButton("Bezeroa borratu");
		btnBezeroaBorratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteControlador.abrirVentanaBezeroaBorratu();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(118)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnConsulta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBezeroak, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnBezeroaBorratu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBezeroBerria, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblBezeroKudeaketa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBezeroKudeaketa)
					.addGap(18)
					.addComponent(btnBezeroBerria)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBezeroaBorratu)
					.addGap(67)
					.addComponent(btnConsulta)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBezeroak)
					.addGap(22))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
