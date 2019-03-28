package ventanasAPI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;

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
		
		
		
		String resourceName = "./resources/examples.JSON";
		File file = new File(resourceName);
		String content=null;
		try {
			content = FileUtils.readFileToString(file, "utf-8"); //pasa a un String un file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject bar = new JSONObject(content);
		
		String nombre = bar.getString("nombre");
		String descripcion = bar.getString("descripcion");
		
		JLabel lblDescripcin = new JLabel(descripcion);
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
		
		JLabel lblNewLabel = new JLabel(nombre);// aqui el nombre sacado del json 
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(144, 16, 298, 41);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 708, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
