package vista;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ClienteControlador;

public class BezeroaBorratu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private ClienteControlador clienteControlador;


	public ClienteControlador getClienteControlador() {
		return clienteControlador;
	}


	public void setClienteControlador(ClienteControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
	}


	public BezeroaBorratu(BezeroKudeaketa parent, boolean modal) {
		super (parent,modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}

}
