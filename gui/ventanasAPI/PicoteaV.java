package ventanasAPI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;

import org.json.JSONObject;

import modelo.LoginRegistro;
import modelo.Picotea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PicoteaV extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblPicotea;
	private JLabel label;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PicoteaV frame = new PicoteaV();
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
	public PicoteaV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(0, 0, 801, 523);
			panel.setLayout(null);
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_1_1());
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
		}
		return panel;
	}
	private JLabel getLabel_1() {
		if (lblPicotea == null) {
			lblPicotea = new JLabel("PICOTEA");
			lblPicotea.setForeground(Color.WHITE);
			lblPicotea.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblPicotea.setBounds(291, 4, 135, 37);
		}
		return lblPicotea;
	}
	private JLabel getLabel_2() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(PicoteaV.class.getResource("/resources/ppp.PNG")));
			label.setBounds(50, 85, 511, 79);
		}
		return label;
	}
	private JLabel getLabel_1_1() {
		if (lblNewLabel == null) {
			String Descri= Picotea.getInstance().verPicotea().getString("descripcion");
			lblNewLabel = new JLabel(Descri);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(50, 213, 511, 43);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Entrar");
			btnNewButton.setForeground(SystemColor.text);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnNewButton.setBackground(SystemColor.desktop);
			btnNewButton.setBounds(50, 380, 168, 69);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login g=new Login();
					g.setVisible(true);
					dispose();
				}
			});
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Registrarse");
			btnNewButton_1.setForeground(SystemColor.text);
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnNewButton_1.setBackground(SystemColor.desktop);
			btnNewButton_1.setBounds(380, 380, 144, 69);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Registro r=new Registro();
					r.setVisible(true);
					dispose();
				}
				
			});
		}
		return btnNewButton_1;
	}
}
