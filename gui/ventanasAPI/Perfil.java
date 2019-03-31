package ventanasAPI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import modelo.LoginRegistro;
import modelo.Picotea;
import modelo.Resumen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Perfil extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblPicotea;
	private JLabel lblC;
	private JButton btnSalir;
	private JLabel lblBienvenido;
	private JLabel lblNewLabel;
	private JButton btnPedidos;
	private JButton btnResumen;
	private JLabel lblCategoria;
	private JButton btnNewButton;
	private JButton btnVerMiCuenta;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
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
	public Perfil() {
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
			panel.add(getLblPicotea());
			panel.add(getLblC());
			panel.add(getBtnSalir());
			panel.add(getLblBienvenido());
			panel.add(getLblNewLabel());
			panel.add(getBtnPedidos());
			panel.add(getBtnResumen());
			panel.add(getLblCategoria());
			panel.add(getBtnNewButton());
			panel.add(getBtnVerMiCuenta());
		}
		return panel;
	}
	private JLabel getLblPicotea() {
		if (lblPicotea == null) {
			lblPicotea = new JLabel("Picotea");
			lblPicotea.setForeground(Color.WHITE);
			lblPicotea.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblPicotea.setBounds(248, 11, 178, 32);
		}
		return lblPicotea;
	}
	private JLabel getLblC() {
		if (lblC == null) {
			lblC = new JLabel("T\u00E9rminos y Condiciones de Privacidad");
			lblC.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Picotea.getInstance().mostrarTerminos();
				}
			});
			lblC.setBackground(Color.WHITE);
			lblC.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblC.setForeground(Color.CYAN);
			lblC.setBounds(50, 64, 500, 19);
		}
		return lblC;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setForeground(SystemColor.text);
			btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnSalir.setBackground(SystemColor.desktop);
			btnSalir.setBounds(50, 120, 200, 30);
			btnSalir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					LoginRegistro.getInstance().salir();
					PicoteaV g=new PicoteaV();
					g.setVisible(true);
					dispose();
				}
			});
		}
		return btnSalir;
	}
	private JLabel getLblBienvenido() {
		if (lblBienvenido == null) {
			lblBienvenido = new JLabel("Bienvenido:");
			lblBienvenido.setForeground(Color.WHITE);
			lblBienvenido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lblBienvenido.setBounds(50, 94, 150, 22);
		}
		return lblBienvenido;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(LoginRegistro.getInstance().verLogin().getString("usuario"));	
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(181, 94, 200, 20);
		}
		return lblNewLabel;
	}
	private JButton getBtnPedidos() {
		if (btnPedidos == null) {
			btnPedidos = new JButton("Pedidos");
			btnPedidos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Pedidos();
					dispose();
				}
			});
			btnPedidos.setForeground(SystemColor.text);
			btnPedidos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnPedidos.setBackground(SystemColor.desktop);
			btnPedidos.setBounds(50, 320, 200, 30);
		}
		return btnPedidos;
	}
	private JButton getBtnResumen() {
		if (btnResumen == null) {
			btnResumen = new JButton("Ver Resumen");
			btnResumen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ResumenV r=new ResumenV();
					r.setVisible(true);
					dispose();
				}
			});
			btnResumen.setForeground(SystemColor.text);
			btnResumen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnResumen.setBackground(SystemColor.desktop);
			btnResumen.setBounds(50, 280, 200, 30);
		}
		return btnResumen;
	}
	private JLabel getLblCategoria() {
		if (lblCategoria == null) {
			lblCategoria = new JLabel("Realiza y administra pedidos:");
			lblCategoria.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lblCategoria.setForeground(Color.WHITE);
			lblCategoria.setBounds(50, 200, 300, 22);
		}
		return lblCategoria;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Ver Bares");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// faltarian botones de busqueda
					new Bares("bar","Ibarrekolanda");
					dispose();
					
				}
			});
			btnNewButton.setForeground(SystemColor.text);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnNewButton.setBackground(SystemColor.desktop);
			btnNewButton.setBounds(50, 240, 200, 30);
		}
		return btnNewButton;
	}
	
	private JButton getBtnVerMiCuenta() {
		if (btnVerMiCuenta == null) {
			btnVerMiCuenta = new JButton("Ver mi Cuenta");
			btnVerMiCuenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MiCuenta r=new MiCuenta();
					r.setVisible(true);
					dispose();
				}
			});
			btnVerMiCuenta.setForeground(SystemColor.text);
			btnVerMiCuenta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnVerMiCuenta.setBackground(SystemColor.desktop);
			btnVerMiCuenta.setBounds(50, 160, 200, 30);
		}
		return btnVerMiCuenta;
	}
}
