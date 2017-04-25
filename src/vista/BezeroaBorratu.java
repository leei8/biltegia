package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ClienteControlador;
import modelo.Cliente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BezeroaBorratu extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ClienteControlador clienteControlador;
	private JComboBox comboBoxBorrado;

	public ClienteControlador getClienteControlador() {
		return clienteControlador;
	}

	public void setClienteControlador(ClienteControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
	}

	public BezeroaBorratu(BezeroKudeaketa parent, boolean modal) {
		super(parent, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		comboBoxBorrado = new JComboBox();

		JButton btnBorratu = new JButton("Borratu");
		btnBorratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String datosCliente = (String) comboBoxBorrado.getSelectedItem();

				String[] partes = datosCliente.split(":");
				// En la parte 0 esta el ID
				String idCliente = (partes[0]);
				eliminarCliente(idCliente);

			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(100).addComponent(
										comboBoxBorrado, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(176).addComponent(btnBorratu)))
						.addContainerGap(109, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(81)
						.addComponent(comboBoxBorrado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnBorratu).addContainerGap(109, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
	}

	public void resetearCombo(ArrayList<Cliente> clientes) {
		comboBoxBorrado.removeAll();
		rellenarCombo(clientes);

	}

	public void rellenarCombo(ArrayList<Cliente> clientes) {

		for (Cliente cliente : clientes) {
			this.comboBoxBorrado.addItem(cliente.getId() + ": " + cliente.getNombre());
		}
		this.comboBoxBorrado.setSelectedIndex(-1);
	}

	protected void eliminarCliente(String idCliente) {
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas borrar este socio?");
		if (respuesta == JOptionPane.OK_OPTION) {
			clienteControlador.borrarCliente(idCliente);
		}

	}

}
