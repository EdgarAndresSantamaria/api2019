package ventanasAPI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import modelo.LoginRegistro;

import java.awt.Font;

public class Login extends JFrame {
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnVolver;
	private JTextField emailtext;
	private JSeparator separator;
	private JPasswordField passwordField;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblNewLabel;
	private JLabel lblPicotea;
	private JLabel lblLogin;

	
	/**
	 * Create the frame.
	 */
	public Login() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getEmailtext());
		getContentPane().add(getSeparator());
		getContentPane().add(getPasswordField());
		getContentPane().add(getLblEmail());
		getContentPane().add(getLblPassword());
		getContentPane().add(getBtnVolver());
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 523);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(0, 0, 370, 320);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblLogin());
		}
		return panel;
	}
	
    private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Entrar");
			btnNewButton.setForeground(SystemColor.text);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnNewButton.setBackground(SystemColor.desktop);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String email = new String(emailtext.getText());
					String pass = new String(passwordField.getPassword());
					if(email.equals("") || pass.equals("")){
						JOptionPane
						.showMessageDialog(null,
								"Hay campos vacios,debe llenar todos los campos");
					}else{
						if (LoginRegistro.getInstance().esEmail(email)) {
							if (!LoginRegistro.getInstance().existeUsuario(
									email)) {
								JOptionPane.showMessageDialog(null,
										"este Usuario no esta registrado");
								emailtext.setText("");
								passwordField.setText("");
								
						}else{
							LoginRegistro.getInstance().entrar(email, pass);
							JOptionPane.showMessageDialog(null,
									"loggeo con exito!!");
							Perfil p=new Perfil();
							p.setVisible(true);
							dispose();
							
						}
					}
					
					}
					
					
					
					
				}
			});
			btnNewButton.setBounds(380, 380, 144, 69);
		}
		return btnNewButton;
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
	
	private JTextField getEmailtext() {
		if (emailtext == null) {
			emailtext = new JTextField();
			emailtext.setBounds(380, 85, 228, 23);
			emailtext.setColumns(10);
		}
		return emailtext;
	}
	
	
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(380, 85, 228, 2);
		}
		return separator;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(380, 204, 224, 20);
		}
		return passwordField;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("EMAIL");
			lblEmail.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
			lblEmail.setBounds(380, 60, 63, 14);
		}
		return lblEmail;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("PASSWORD");
			lblPassword.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
			lblPassword.setBounds(380, 171, 94, 14);
		}
		return lblPassword;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/resources/pintxoabando.png")));
			lblNewLabel.setBounds(54, 86, 296, 143);
		}
		return lblNewLabel;
	}
	
	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("LOGIN");
			lblLogin.setForeground(Color.WHITE);
			lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			lblLogin.setBounds(248, 11, 178, 32);
		}
		return lblLogin;
	}
}
