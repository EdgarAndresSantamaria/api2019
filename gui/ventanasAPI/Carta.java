package ventanasAPI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import modelo.Establecimiento;
import modelo.Oferta;
import modelo.Picotea;

import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Carta {

	private JFrame frame;
	private JLabel lblPrecioUnidad;
	private JLabel label_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carta window = new Carta();
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
	public Carta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 711, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCarta = new JLabel("CARTA");
		lblCarta.setForeground(Color.WHITE);
		lblCarta.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCarta.setBounds(291, 4, 135, 37);
		frame.getContentPane().add(lblCarta);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Carta.class.getResource("/ventanasAPI/icon.png")));
		btnNewButton.setBounds(624, 4, 50, 50);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblBebidas = new JLabel("Bebidas");
		lblBebidas.setForeground(Color.WHITE);
		lblBebidas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblBebidas.setBounds(52, 49, 69, 20);
		frame.getContentPane().add(lblBebidas);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(367, 106, 32, 26);
		frame.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(367, 148, 32, 26);
		frame.getContentPane().add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(367, 190, 32, 26);
		frame.getContentPane().add(spinner_2);
		
		JLabel lblComida = new JLabel("Comida");
		lblComida.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblComida.setForeground(Color.WHITE);
		lblComida.setBounds(52, 232, 69, 20);
		frame.getContentPane().add(lblComida);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(367, 268, 32, 26);
		frame.getContentPane().add(spinner_3);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>( model );
		list.setBounds(15, 101, 162, 115);
		frame.getContentPane().add(list);
		
		DefaultListModel<String> model1 = new DefaultListModel<>();
		JList<String> list2 = new JList<>(model1);
		list2.setBounds(188, 101, 162, 115);
		frame.getContentPane().add(list2);
		
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(367, 310, 32, 26);
		frame.getContentPane().add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(367, 352, 32, 26);
		frame.getContentPane().add(spinner_5);
		
		JButton btnResumen = new JButton("Resumen");
		btnResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valor1 = (Integer)spinner.getValue();
				int valor2 = (Integer)spinner_1.getValue();
				int valor3 = (Integer)spinner_2.getValue();
				 	 for(int a=1;a<=valor1;a++) {
				Object item = list.getModel().getElementAt(0);
	            System.out.println("Item = " + item);
				 	 }
				 	 for(int b=1;b<=valor2; b++) {
	            Object item1 = list.getModel().getElementAt(1);
	            System.out.println("Item = " + item1);
				 	 }
//				 	 
//	            Object item2 = list.getModel().getElementAt(2);
//	            System.out.println("Item = " + item2);
			    }
			
		});
		btnResumen.setBackground(SystemColor.desktop);
		btnResumen.setForeground(SystemColor.text);
		btnResumen.setBounds(494, 336, 146, 44);
		frame.getContentPane().add(btnResumen);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Carta.class.getResource("/ventanasAPI/450_1000.jpg")));
		lblNewLabel.setBounds(457, 85, 183, 174);
		frame.getContentPane().add(lblNewLabel);
		
		lblPrecioUnidad = new JLabel("Precio Unidad");
		lblPrecioUnidad.setForeground(Color.WHITE);
		lblPrecioUnidad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblPrecioUnidad.setBounds(188, 49, 146, 20);
		frame.getContentPane().add(lblPrecioUnidad);
		
		label_3 = new JLabel("Precio Unidad");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_3.setBounds(188, 232, 146, 20);
		frame.getContentPane().add(label_3);
		
		JList<String> list_1 = new JList<String>((ListModel) null);
		list_1.setBounds(15, 270, 162, 115);
		frame.getContentPane().add(list_1);
		
		JList<String> list_2 = new JList<String>((ListModel) null);
		list_2.setBounds(190, 270, 162, 115);
		frame.getContentPane().add(list_2);
	
		
			String resourceName = "./resources/examples.JSON";
			File file = new File(resourceName);
			String content=null;
			try {
				content = FileUtils.readFileToString(file, "utf-8"); //pasa a un String un file
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        JSONObject obj = new JSONObject(content);
			// lista de establecimientos temporal
			ArrayList<String> ofertasTmp = new ArrayList<String> ();
			JSONArray arr = obj.getJSONArray("ofertas");
			for (int i = 0; i < arr.length(); i++)
			{
				// recuperar valores generales
			    double precio = arr.getJSONObject(i).getDouble("precio");
			    JSONObject informacion = (JSONObject) arr.getJSONObject(i).get("informacion");
			    String nombre = informacion.getString("nombre");
			    model.addElement(nombre);

			    model1.addElement(Double.toString(precio));
			    JSONArray items = informacion.getJSONArray("items");
			    for(int k=0;k<items.length();k++) {
			    	precio = items.getJSONObject(k).getDouble("precio");
			    	nombre = items.getJSONObject(k).getString("name");
			    	model.addElement(nombre);
			    	model1.addElement(Double.toString(precio));
			    	
			    }
			}
			
			
			
				
	
}
}
