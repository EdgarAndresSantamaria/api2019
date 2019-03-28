package api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Login extends JFrame {
	private JPanel panel;
	private JButton btnNewButton;
	private JTextField textField;
	private JSeparator separator;
	private JPasswordField passwordField;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblNewLabel;
	private JLabel lblPicotea;
	private JLabel lblLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getTextField());
		getContentPane().add(getSeparator());
		getContentPane().add(getPasswordField());
		getContentPane().add(getLblEmail());
		getContentPane().add(getLblPassword());
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 436);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(0, 0, 360, 445);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblPicotea());
			panel.add(getLblLogin());
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("SignUp");
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(Color.BLACK);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton.setBounds(423, 268, 124, 37);
		}
		return btnNewButton;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(370, 85, 228, 23);
			textField.setColumns(10);
		}
		return textField;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(370, 85, 228, 2);
		}
		return separator;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(370, 204, 224, 20);
		}
		return passwordField;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("EMAIL");
			lblEmail.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
			lblEmail.setBounds(370, 60, 63, 14);
		}
		return lblEmail;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("PASSWORD");
			lblPassword.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
			lblPassword.setBounds(371, 171, 94, 14);
		}
		return lblPassword;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/aplicacionApi/pintxoabando.png")));
			lblNewLabel.setBounds(54, 86, 296, 143);
		}
		return lblNewLabel;
	}
	private JLabel getLblPicotea() {
		if (lblPicotea == null) {
			lblPicotea = new JLabel("PICOTEA");
			lblPicotea.setForeground(Color.WHITE);
			lblPicotea.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 30));
			lblPicotea.setBackground(Color.WHITE);
			lblPicotea.setBounds(77, 282, 185, 44);
		}
		return lblPicotea;
	}
	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("LOGIN");
			lblLogin.setForeground(Color.WHITE);
			lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			lblLogin.setBounds(101, 11, 202, 37);
		}
		return lblLogin;
	}
}
