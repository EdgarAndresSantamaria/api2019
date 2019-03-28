package api;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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

public class Resumen extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblResumenDelPedido;
	private JScrollPane scrollPane;
	private JTable table;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resumen frame = new Resumen();
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
	public Resumen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 457);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblMetodoDePago());
		contentPane.add(getRdbtnNewRadioButton());
		contentPane.add(getRdbtnNewRadioButton_1());
		contentPane.add(getRdbtnNewRadioButton_2());
		contentPane.add(getRdbtnNewRadioButton_3());
		contentPane.add(getRdbtnNewRadioButton_4());
		contentPane.add(getLblPais());
		contentPane.add(getComboBox());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setForeground(Color.WHITE);
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(0, 0, 267, 418);
			panel.setLayout(null);
			panel.add(getLblResumenDelPedido());
			panel.add(getScrollPane());
			panel.add(getBtnReservar());
			panel.add(getLblNewLabel());
			panel.add(getLblDisfruteDeSu());
		}
		return panel;
	}
	private JLabel getLblResumenDelPedido() {
		if (lblResumenDelPedido == null) {
			lblResumenDelPedido = new JLabel("Resumen del pedido");
			lblResumenDelPedido.setBounds(69, 5, 129, 16);
			lblResumenDelPedido.setForeground(Color.WHITE);
			lblResumenDelPedido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		}
		return lblResumenDelPedido;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(35, 32, 200, 106);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setBackground(Color.LIGHT_GRAY);
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{"cafe solo", "1,30€"},
					{"Zumo de naranja", "3,00€"},
					{"pintxo de jamon", "1,50"},
					{"tortilla completa", "7,00"},
					{"Total", "12,80€"},
				},
				new String[] {
					"Descripci\u00F3n", "Importe"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		}
		return table;
	}
	private JLabel getLblMetodoDePago() {
		if (lblMetodoDePago == null) {
			lblMetodoDePago = new JLabel("Metodo de pago");
			lblMetodoDePago.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
			lblMetodoDePago.setBounds(390, 39, 190, 31);
		}
		return lblMetodoDePago;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("Visa");
			rdbtnNewRadioButton.setSelected(true);
			rdbtnNewRadioButton.setBounds(354, 136, 109, 23);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("MasterCard");
			rdbtnNewRadioButton_1.setBounds(354, 180, 109, 23);
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("Maestro");
			rdbtnNewRadioButton_2.setBounds(354, 225, 109, 23);
		}
		return rdbtnNewRadioButton_2;
	}
	private JRadioButton getRdbtnNewRadioButton_3() {
		if (rdbtnNewRadioButton_3 == null) {
			rdbtnNewRadioButton_3 = new JRadioButton("Visa Electron");
			rdbtnNewRadioButton_3.setBounds(354, 269, 109, 23);
		}
		return rdbtnNewRadioButton_3;
	}
	private JRadioButton getRdbtnNewRadioButton_4() {
		if (rdbtnNewRadioButton_4 == null) {
			rdbtnNewRadioButton_4 = new JRadioButton("Wi Zink");
			rdbtnNewRadioButton_4.setBounds(354, 318, 109, 23);
		}
		return rdbtnNewRadioButton_4;
	}
	private JLabel getLblPais() {
		if (lblPais == null) {
			lblPais = new JLabel("Pais");
			lblPais.setBounds(329, 93, 46, 14);
		}
		return lblPais;
	}
	private JButton getBtnReservar() {
		if (btnReservar == null) {
			btnReservar = new JButton("Reservar");
			btnReservar.setBackground(Color.DARK_GRAY);
			btnReservar.setForeground(Color.WHITE);
			btnReservar.setBounds(152, 366, 89, 23);
		}
		return btnReservar;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Gracias por su pedido! ");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(10, 221, 158, 39);
		}
		return lblNewLabel;
	}
	private JLabel getLblDisfruteDeSu() {
		if (lblDisfruteDeSu == null) {
			lblDisfruteDeSu = new JLabel("Disfrute de su pintxo pote!!");
			lblDisfruteDeSu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblDisfruteDeSu.setForeground(Color.WHITE);
			lblDisfruteDeSu.setBounds(20, 258, 215, 48);
		}
		return lblDisfruteDeSu;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Espa\u00F1a", "Reino Unido", "Brasil", "Australia"}));
			comboBox.setBounds(372, 90, 190, 20);
		}
		return comboBox;
	}
}
