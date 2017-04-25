package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.PedidoControlador;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EskariKudeaketa extends JDialog {

	private PedidoControlador pedidoControlador;
	
	public PedidoControlador getPedidoControlador() {
		return pedidoControlador;
	}

	public void setPedidoControlador(PedidoControlador pedidoControlador) {
		this.pedidoControlador = pedidoControlador;
	}

	private final JPanel contentPanel = new JPanel();
	private JButton btnEskarienKontsulta;

	public EskariKudeaketa(Nagusia parent, boolean modal) {
		super(parent,modal); 
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			btnEskarienKontsulta = new JButton("Eskarien Kontsulta");
			btnEskarienKontsulta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pedidoControlador.abrirVentanaEskariKontsulta();
				}
			});
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addComponent(btnEskarienKontsulta)
					.addGap(150))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(75)
					.addComponent(btnEskarienKontsulta)
					.addContainerGap(153, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}

}
