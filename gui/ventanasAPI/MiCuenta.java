package ventanasAPI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.LoginRegistro;
import modelo.Picotea;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MiCuenta extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblNewLabel_1;
	private JLabel lblTelefono;
	private JLabel label;
	private JLabel lblEmail;
	private JLabel lblFooemailcom;
	private JLabel label_1;
	private JLabel lblC;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiCuenta frame = new MiCuenta();
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
	public MiCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 801, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}
	
	private JButton getIcon() {
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Carta.class.getResource("/resources/icon.png")));
		btnNewButton.setBounds(624, 4, 50, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Perfil p=new Perfil();
				p.setVisible(true);
			}
			
		});
		return btnNewButton;
	}
	
	private JButton getVolver() {
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Perfil p=new Perfil();
				p.setVisible(true);
			}
			
		});
		btnVolver.setForeground(SystemColor.text);
		btnVolver.setBackground(SystemColor.desktop);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnVolver.setBounds(50, 380, 168, 69);
		return btnVolver;
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(0, 0, 801, 523);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblTelefono());
			panel.add(getLabel());
			panel.add(getLblEmail());
			panel.add(getLblFooemailcom());
			panel.add(getLabel_1());
			panel.add(getVolver());
			panel.add(getLblC());
			panel.add(getIcon());
		}
		return panel;
	}
	
	private JLabel getLblC() {
		if (lblC == null) {
			lblC = new JLabel("Contacto");
			lblC.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Picotea.getInstance().mostrarContatcto();
				}
			});
			lblC.setBackground(Color.WHITE);
			lblC.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblC.setForeground(Color.CYAN);
			lblC.setBounds(50, 220, 500, 19);
		}
		return lblC;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Mi Cuenta");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblNewLabel.setBounds(291, 4, 300, 37);
		}
		return lblNewLabel;
	}

	private JLabel getLblTelefono() {
		if (lblTelefono == null) {
			lblTelefono = new JLabel("Telefono:");
			lblTelefono.setForeground(Color.WHITE);
			lblTelefono.setBounds(50, 140, 200, 30);
		}
		return lblTelefono;
	}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel(LoginRegistro.getInstance().verLogin().getString("telefono"));
			label.setForeground(Color.WHITE);
			label.setBounds(250, 140, 200, 30);
		}
		return label;
	}
	
    private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setBounds(50, 180, 200, 30);
		}
		return lblEmail;
	}
	
    private JLabel getLblFooemailcom() {
		if (lblFooemailcom == null) {
			lblFooemailcom = new JLabel(LoginRegistro.getInstance().verLogin().getString("usuario"));
			lblFooemailcom.setForeground(Color.WHITE);
			lblFooemailcom.setBounds(250, 180, 200, 30);
		}
		return lblFooemailcom;
	}
	
    private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(MiCuenta.class.getResource("/resources/miCuenta.png")));
			label_1.setBounds(440, 130, 200, 138);
		}
		return label_1;
	}
}
