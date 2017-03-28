package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ClienteControlador;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BezeroFormulario extends JDialog {
	// ----- ATRIBUTOS
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_id;
	private JTextField textField_nombre;
	private JTextField textField_telefono;
	private JTextField textField_direccion;
	private JTextField textField_codPostal;

	private ClienteControlador clienteControlador;

	// ------ GETERS SETTERS
	public ClienteControlador getClienteControlador() {
		return clienteControlador;
	}

	public void setClienteControlador(ClienteControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
	}

	// ------- METODOS

	private void formularioaGarbitu() {
		textField_id.setText("");
		textField_nombre.setText("");
		textField_direccion.setText("");
		textField_codPostal.setText("");
		textField_telefono.setText("");

	}

	public BezeroFormulario(BezeroKudeaketa parent, boolean modal) {
		super(parent, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);

		JLabel lbl_id = new JLabel("ID:");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl_nombre = new JLabel("Nombre:");
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl_telefono = new JLabel("Telefono:");
		lbl_telefono.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl_direccion = new JLabel("Direccion:");
		lbl_direccion.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lbl_codPostal = new JLabel("CPostal:");
		lbl_codPostal.setHorizontalAlignment(SwingConstants.CENTER);

		textField_id = new JTextField();
		textField_id.setColumns(10);

		textField_nombre = new JTextField();
		textField_nombre.setColumns(10);

		textField_telefono = new JTextField();
		textField_telefono.setColumns(10);

		textField_direccion = new JTextField();
		textField_direccion.setColumns(10);

		textField_codPostal = new JTextField();
		textField_codPostal.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clienteControlador.bezeroBerriaSartu(textField_id.getText(), textField_nombre.getText(),
						textField_direccion.getText(), textField_codPostal.getText(), textField_telefono.getText());
				formularioaGarbitu();
			}

		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formularioaGarbitu();
				dispose();
			}
		});

		JLabel lblInsertarUnNuevo = new JLabel("INSERTAR UN NUEVO CLIENTE");
		lblInsertarUnNuevo.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(100)
					.addComponent(lblInsertarUnNuevo))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(262)
					.addComponent(btnGuardar)
					.addGap(6)
					.addComponent(btnCancelar))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lbl_telefono)
							.addGap(47)
							.addComponent(textField_telefono, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lbl_codPostal)
							.addGap(53)
							.addComponent(textField_codPostal, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(9)
									.addComponent(lbl_id))
								.addComponent(lbl_nombre))
							.addGap(52)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_id, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_nombre, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lbl_direccion)
							.addGap(46)
							.addComponent(textField_direccion, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblInsertarUnNuevo)
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_id))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_nombre))
					.addGap(4)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(7)
							.addComponent(lbl_direccion))
						.addComponent(textField_direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(textField_codPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lbl_codPostal)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(textField_telefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnGuardar)
								.addComponent(btnCancelar)))
						.addComponent(lbl_telefono)))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
