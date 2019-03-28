package ventanasAPI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;
import javax.swing.JList;

public class Bar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bar window = new Bar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		
		
		String resourceName = "./resources/examplesIvan.JSON";
		File file = new File(resourceName);
		String content=null;
		try {
			content = FileUtils.readFileToString(file, "utf-8"); //pasa a un String un file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject bar = new JSONObject(content);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>(model);
		list.setBounds(77, 190, 241, 78);
		frame.getContentPane().add(list);
		frame.setBounds(100, 100, 708, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultListModel<String> modelPrecios = new DefaultListModel<>();
		JList list_1 = new JList(modelPrecios);
		list_1.setBounds(374, 190, 241, 88);
		frame.getContentPane().add(list_1);
		
		
		String nombre = bar.getString("nombre");
		System.out.println(bar.getJSONArray("productos"));
		
		JSONArray products = bar.getJSONArray("productos");
		for(int i=0;i< products.length();i++) {
			double precio = products.getJSONObject(i).getDouble("precio");
			System.out.println(products.getJSONObject(i).getDouble("precio"));
			String nomProducto = products.getJSONObject(i).getString("name");
			
			modelPrecios.addElement(Double.toString(precio));
			model.addElement(nomProducto);
		}
		
		
		JLabel lblDescripcin = new JLabel();
		lblDescripcin.setForeground(Color.WHITE);
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblDescripcin.setBounds(144, 80, 298, 41);
		frame.getContentPane().add(lblDescripcin);
		
		JButton btnBusqueda = new JButton("Busqueda");
		btnBusqueda.setForeground(SystemColor.text);
		btnBusqueda.setBackground(SystemColor.desktop);
		btnBusqueda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBusqueda.setBounds(15, 299, 168, 69);
		frame.getContentPane().add(btnBusqueda);
		
		JButton btnCarta = new JButton("Carta");
		btnCarta.setForeground(SystemColor.text);
		btnCarta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnCarta.setBackground(SystemColor.desktop);
		btnCarta.setBounds(527, 299, 144, 69);
		frame.getContentPane().add(btnCarta);
		
		JButton button = new JButton("");
		button.setBackground(Color.DARK_GRAY);
		button.setIcon(new ImageIcon(Bar.class.getResource("/ventanasAPI/icon.png")));
		button.setBounds(618, 16, 53, 41);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel(nombre);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(144, 16, 298, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setBounds(77, 148, 106, 20);
		frame.getContentPane().add(lblProductos);
		
		
		
		JLabel lblPrecios = new JLabel("Precios");
		lblPrecios.setForeground(Color.WHITE);
		lblPrecios.setBounds(374, 148, 106, 20);
		frame.getContentPane().add(lblPrecios);
		
		
		
		
	}
}
