package ventanasAPI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import modelo.LoginRegistro;
import modelo.Picotea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField nombretext;
	private JTextField telefonotext;
	private JTextField emailtext;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JButton btnRegistrar;
	private JButton btnVolver;
	private JLabel lblRegistro;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblTrminos;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTelefonotext());
		contentPane.add(getEmailtext());
		contentPane.add(getLblTelefono());
		contentPane.add(getLblEmail());
		contentPane.add(getBtnRegistrar());
		contentPane.add(getBtnVolver());
		contentPane.add(getLblRegistro());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblTrminos());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPasswordField());
	}
	
	private JTextField getTelefonotext() {
		if (telefonotext == null) {
			telefonotext = new JTextField();
			telefonotext.setBounds(46, 171, 238, 20);
			telefonotext.setColumns(10);
		}
		return telefonotext;
	}

	private JTextField getEmailtext() {
		if (emailtext == null) {
			emailtext = new JTextField();
			emailtext.setBounds(46, 239, 238, 20);
			emailtext.setColumns(10);
		}
		return emailtext;
	}

	private JLabel getLblTelefono() {
		if (lblTelefono == null) {
			lblTelefono = new JLabel("Tel\u00E9fono");
			lblTelefono.setForeground(Color.WHITE);
			lblTelefono
					.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
			lblTelefono.setBounds(50, 141, 89, 14);
		}
		return lblTelefono;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
			lblEmail.setBounds(50, 214, 69, 14);
		}
		return lblEmail;
	}

	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					String email = new String(emailtext.getText());
					String pass = new String(passwordField.getPassword());
					String telefono = telefonotext.getText();
					if (telefono.equals("")
							|| email.equals("") || pass.equals("")) {
						JOptionPane
								.showMessageDialog(null,
										"Hay campos vacios,debe llenar todos los campos");

					} else {
						if (telefono.length() < 9
								|| telefono.length() > 9) {
							JOptionPane
									.showMessageDialog(null,
											"el telefono debe contener minimo 9 digitos");
						}else {
							
							if (LoginRegistro.getInstance().esEmail(email)) {
								
								if (LoginRegistro.getInstance().existeUsuario(
										email)) {
									JOptionPane.showMessageDialog(null,
											"este Usuario ya esta registrado");

								} else {
									LoginRegistro.getInstance().registrar(email, pass, telefono);
									JOptionPane.showMessageDialog(null,
											"Registro guardado");

									Login l = new Login();
									l.setVisible(true);
									dispose();

								}
							}else {
								JOptionPane
								.showMessageDialog(null,
										"el e-mail está mal escrito");
							}
						}
					}

				}
			});
			btnRegistrar.setForeground(SystemColor.text);
			btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnRegistrar.setBackground(SystemColor.desktop);
			btnRegistrar.setBounds(380, 380, 144, 69);
		}
		return btnRegistrar;
	}

	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PicoteaV p = new PicoteaV();
					p.setVisible(true);
					dispose();
				}
			});
			btnVolver.setForeground(SystemColor.text);
			btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnVolver.setBackground(SystemColor.desktop);
			btnVolver.setBounds(50, 380, 168, 69);
		}
		return btnVolver;
	}

	private JLabel getLblRegistro() {
		if (lblRegistro == null) {
			lblRegistro = new JLabel("REGISTRO");
			lblRegistro.setForeground(Color.WHITE);
			lblRegistro
					.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 30));
			lblRegistro.setBounds(248, 11, 178, 32);
		}
		return lblRegistro;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Registro.class
					.getResource("/pintxos.png")));
			lblNewLabel.setBounds(308, 145, 306, 170);
		}
		return lblNewLabel;
	}

	private JLabel getLblTrminos() {
		if (lblTrminos == null) {
			lblTrminos = new JLabel("T\u00E9rminos y Condiciones de privacidad");
			lblTrminos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Picotea.getInstance().mostrarTerminos();
				}
			});
			lblTrminos.setForeground(Color.CYAN);
			lblTrminos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblTrminos.setBackground(Color.BLACK);
			lblTrminos.setBounds(50, 343, 350, 14);
		}
		return lblTrminos;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Contrase\u00F1a");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
					12));
			lblNewLabel_1.setBounds(50, 270, 100, 14);
		}
		return lblNewLabel_1;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(50, 292, 238, 20);
		}
		return passwordField;
	}
}
