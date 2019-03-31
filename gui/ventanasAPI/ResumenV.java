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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.Choice;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import modelo.Picotea;
import modelo.Resumen;

public class ResumenV extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblResumenDelPedido;
	private JScrollPane scrollPane;
	private JList ofertas;
	private JList items;
	private JLabel lblMetodoDePago;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton_4;
	private JLabel lblPais;
	private JButton btnReservar;
	private JLabel lblNewLabel;
	private JLabel lblDisfruteDeSu;
	private JComboBox comboBox;
	private JLabel lblNombreBar;

	/**
	 * Create the frame.
	 */
	public ResumenV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		
		
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setForeground(Color.WHITE);
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(0, 0, 801, 523);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblDisfruteDeSu());
			panel.add(getLblNombreBar());
			panel.add(getLblResumenDelPedido());
			panel.add(getLblMetodoDePago());
			panel.add(getRdbtnNewRadioButton());
			panel.add(getBtnVolver());
			panel.add(getBtnReservar());
			panel.add(getIcon());
			panel.add(getOfertas());
			panel.add(getProductos());
			panel.add(getLblOfertas());
			panel.add(getLblProductos());
		}
		return panel;
	}
	
	private JLabel getLblResumenDelPedido() {
		if (lblResumenDelPedido == null) {
			lblResumenDelPedido = new JLabel("Resumen del pedido");
			lblResumenDelPedido.setForeground(Color.WHITE);
			lblResumenDelPedido.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblResumenDelPedido.setBounds(291, 4, 500, 37);
		}
		return lblResumenDelPedido;
	}
	
	private JLabel getLblOfertas() {
		JLabel lblOfertas = new JLabel();
		lblOfertas = new JLabel("Ofertas");
		lblOfertas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblOfertas.setForeground(Color.WHITE);
		lblOfertas.setBounds(50, 60, 190, 30);
		return lblOfertas;
	}
	
	private JList getOfertas() {
		if (ofertas == null) {
			JSONObject resumen = Resumen.getInstance().verResumen();
			Vector<String>  data = new Vector<String> ();
			JSONArray offers = resumen.getJSONArray("ofertas");
			for (Object obj:offers) {
				JSONObject laoferta = (JSONObject) obj;
				JSONObject info = (JSONObject) laoferta.get("informacion");
				//recuperar información
				data.add(info.getString("nombre")+ ", "+ String.valueOf(laoferta.getFloat("precio"))+ " €");
			}
			
			ofertas = new JList<String>(data);
			ofertas.setBounds(50, 100, 250, 100);
		}
		return ofertas;
	}
	
	private JLabel getLblProductos() {
		JLabel lblProductos = new JLabel();
		lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setBounds(50, 210, 190, 30);
		return lblProductos;
	}
	
	private JList getProductos() {
		if (items == null) {
			JSONObject resumen = Resumen.getInstance().verResumen();
			Vector<String>  data = new Vector<String> ();
			JSONArray productos = resumen.getJSONArray("productos");
			for (Object item : productos) {
				JSONObject elItem = (JSONObject) item;
				// añadir nombre item
				data.add(elItem.getString("name") + ", " +String.valueOf(elItem.getFloat("precio")) + " €" );
			}
			items = new JList<String>(data);
			items.setBounds(50, 250, 250, 100);
		}
		return items;
	}
	
	private JLabel getLblMetodoDePago() {
		if (lblMetodoDePago == null) {
			lblMetodoDePago = new JLabel("Metodo de pago");
			lblMetodoDePago.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblMetodoDePago.setForeground(Color.WHITE);
			lblMetodoDePago.setBounds(380, 170, 190, 30);
		}
		return lblMetodoDePago;
	}
	
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("Visa");
			rdbtnNewRadioButton.setSelected(true);
			rdbtnNewRadioButton.setBounds(380, 200, 110, 30);
		}
		return rdbtnNewRadioButton;
	}
	
	private JButton getBtnReservar() {
		if (btnReservar == null) {
			btnReservar = new JButton("Reservar");
			btnReservar.setForeground(SystemColor.text);
			btnReservar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnReservar.setBackground(SystemColor.desktop);
			btnReservar.setBounds(380, 380, 144, 69);
			btnReservar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Resumen.getInstance().finalizarPedido();
					dispose();
					Perfil p=new Perfil();
					p.setVisible(true);
				}
				
			});
		}
		return btnReservar;
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
	
	private JButton getBtnVolver() {
		JButton btnVolver = new JButton("Volver");
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
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Gracias por su pedido! ");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(380, 90, 300, 30);
		}
		return lblNewLabel;
	}
	
	private JLabel getLblDisfruteDeSu() {
		if (lblDisfruteDeSu == null) {
			lblDisfruteDeSu = new JLabel("Disfrute de su pintxo pote!!");
			lblDisfruteDeSu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblDisfruteDeSu.setForeground(Color.WHITE);
			lblDisfruteDeSu.setBounds(380, 120, 300, 30);
		}
		return lblDisfruteDeSu;
	}
	
	private JLabel getLblNombreBar() {
		if (lblNombreBar == null) {
			lblNombreBar = new JLabel(Resumen.getInstance().verResumen().getString("nombre"));
			lblNombreBar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblNombreBar.setForeground(Color.WHITE);
			lblNombreBar.setBounds(50, 30, 100, 30);
		}
		return lblNombreBar;
	}
}
