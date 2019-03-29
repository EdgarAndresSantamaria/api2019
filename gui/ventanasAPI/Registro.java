package ventanasAPI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNombre;
	private JLabel lblDireccin;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JButton btnRegistrar;
	private JButton btnVolver;
	private JLabel lblRegistro;
	private JLabel lblNewLabel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 432);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_3());
		contentPane.add(getLblNombre());
		contentPane.add(getLblDireccin());
		contentPane.add(getLblTelefono());
		contentPane.add(getLblEmail());
		contentPane.add(getBtnRegistrar());
		contentPane.add(getBtnVolver());
		contentPane.add(getLblRegistro());
		contentPane.add(getLblNewLabel());
		contentPane.add(getPanel());
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(46, 97, 140, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(46, 153, 140, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(46, 219, 140, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(46, 275, 140, 20);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setBounds(46, 72, 69, 14);
		}
		return lblNombre;
	}
	private JLabel getLblDireccin() {
		if (lblDireccin == null) {
			lblDireccin = new JLabel("Direcci\u00F3n");
			lblDireccin.setForeground(Color.WHITE);
			lblDireccin.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
			lblDireccin.setBounds(46, 128, 89, 14);
		}
		return lblDireccin;
	}
	private JLabel getLblTelefono() {
		if (lblTelefono == null) {
			lblTelefono = new JLabel("Tel\u00E9fono");
			lblTelefono.setForeground(Color.WHITE);
			lblTelefono.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
			lblTelefono.setBounds(46, 184, 89, 14);
		}
		return lblTelefono;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
			lblEmail.setBounds(46, 250, 69, 14);
		}
		return lblEmail;
	}
	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.setForeground(Color.WHITE);
			btnRegistrar.setBackground(SystemColor.windowText);
			btnRegistrar.setBounds(46, 359, 89, 23);
		}
		return btnRegistrar;
	}
	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("Volver");
			btnVolver.setBackground(SystemColor.windowText);
			btnVolver.setForeground(Color.WHITE);
			btnVolver.setBounds(175, 359, 89, 23);
		}
		return btnVolver;
	}
	private JLabel getLblRegistro() {
		if (lblRegistro == null) {
			lblRegistro = new JLabel("REGISTRO");
			lblRegistro.setForeground(Color.WHITE);
			lblRegistro.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 30));
			lblRegistro.setBounds(248, 11, 178, 32);
		}
		return lblRegistro;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Registro.class.getResource("/aplicacionApi/pintxos.png")));
			lblNewLabel.setBounds(268, 25, 346, 307);
		}
		return lblNewLabel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 10, 10);
		}
		return panel;
	}
}
