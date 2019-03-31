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
import modelo.Resumen;

import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Carta {

	private JFrame frame;
	private Establecimiento bar;
	private JList<String> items;
	private JList<String> categorias;

	
	/**
	 * Create the application.
	 */
	public Carta(Establecimiento elBar) {
		bar = elBar;
		initialize();
		frame.setVisible(true);
	}

	private void anadirItem() {
		String selectedCat = categorias.getSelectedValue();
		String selectedItem = items.getSelectedValue();
		if (selectedCat ==null || selectedItem==null ) {
			JOptionPane
			.showMessageDialog(null,
					"Debees seleccionar una categoria y un item");
		}else {
			selectedItem = selectedItem.split(",")[0];
			bar.anadirCarritoItem(selectedCat, selectedItem);
		}
	}
	
	/**
	 * 
	 */
	private void cambiarItems() {
		String selectedCat = categorias.getSelectedValue();
		if (selectedCat != null ) {
			// anidado para nombre item , precio y spinner
			DefaultListModel<String> dataTmp = new DefaultListModel<String>();
			
			JSONObject cat = null;
			for(Object obj:bar.verCarta().getJSONArray("carta")) {
				JSONObject catTmp = (JSONObject) obj;
				if(catTmp.getString("nombre").equals(selectedCat)) {
					cat = (JSONObject)catTmp;
				}
			}
			
			JSONArray productos = cat.getJSONArray("items");
			for (Object item : productos) {
				JSONObject elItem = (JSONObject) item;
				// añadir nombre item
				dataTmp.addElement(elItem.getString("name") + ", " + String.valueOf(elItem.getFloat("precio")) + " €");
			}
			items.setModel( dataTmp );
			
		}else {
			JOptionPane
			.showMessageDialog(null,
					"Selecciona una categoria para ver sus items");
		}
	}
		
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 801, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCarta = new JLabel("CARTA");
		lblCarta.setForeground(Color.WHITE);
		lblCarta.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCarta.setBounds(291, 4, 135, 37);
		frame.getContentPane().add(lblCarta);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Carta.class.getResource("/resources/icon.png")));
		btnNewButton.setBounds(624, 4, 50, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Perfil p=new Perfil();
				p.setVisible(true);
			}
			
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblCat = new JLabel("CATEGORIA");
		lblCat.setForeground(Color.WHITE);
		lblCat.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCat.setBounds(50, 20, 100, 100);
		frame.getContentPane().add(lblCat);
		
		Vector<String>  data = new Vector<String> ();
		JSONArray carta = bar.verCarta().getJSONArray("carta");
		for (Object obj:carta) {
			//recuperar información
			JSONObject categoria = (JSONObject)obj;
			// añadir panel
			data.add(categoria.getString("nombre"));
		}
		categorias = new JList<String>(data);
		categorias.setBounds(50, 101, 250, 100);
		categorias.addMouseListener(new MouseAdapter() {
		        public void mouseClicked(MouseEvent e) {
		            cambiarItems();
		        }
		    });
		frame.getContentPane().add(categorias);
	
		
		JLabel lblItem = new JLabel("PRODUCTOS");
		lblItem.setForeground(Color.WHITE);
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblItem.setBounds(50, 180, 100, 100);
		frame.getContentPane().add(lblItem);
		
		// anidado para nombre item , precio y spinner
		Vector<String> dataTmp = new Vector<String>();
		JSONObject cat = (JSONObject) bar.verCarta().getJSONArray("carta").get(0);
		JSONArray productos = cat.getJSONArray("items");
		for (Object item : productos) {
			JSONObject elItem = (JSONObject) item;
			// añadir nombre item
			dataTmp.add(elItem.getString("name") + ", " +String.valueOf(elItem.getFloat("precio")) + " €" );
		}
		items = new JList<String>(dataTmp);
		items.setBounds(50, 251, 250, 100);
		frame.getContentPane().add(items);
		
		JButton btnBusqueda = new JButton("Volver");
		btnBusqueda.setForeground(SystemColor.text);
		btnBusqueda.setBackground(SystemColor.desktop);
		btnBusqueda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBusqueda.setBounds(50, 380, 168, 69);
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Picotea.getInstance().entrarEstablecimiento(bar.getNombre());
			}
			
		});
		frame.getContentPane().add(btnBusqueda);
		
		JButton btnResumen = new JButton("Resumen");
		btnResumen.setForeground(SystemColor.text);
		btnResumen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnResumen.setBackground(SystemColor.desktop);
		btnResumen.setBounds(380, 380, 144, 69);
		btnResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				ResumenV r=new ResumenV();
				r.setVisible(true);	
			}
			
		});
		frame.getContentPane().add(btnResumen);
		
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Resumen.getInstance().getBar().equals("")) {
					Resumen.getInstance().setBar(bar.getNombre());
					anadirItem();
				} else if (Resumen.getInstance().getBar().equals(bar.getNombre())) {
					anadirItem();
				} else {
					JOptionPane.showMessageDialog(null,
							"Solo puedes reservar en un bar al mismo tiempo, actualmente estas reservando en "
									+ Resumen.getInstance().getBar());
				}		
		  }
			
		});
		btnAnadir.setBackground(SystemColor.desktop);
		btnAnadir.setForeground(SystemColor.text);
		btnAnadir.setBounds(380, 290, 146, 44);
		frame.getContentPane().add(btnAnadir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Carta.class.getResource("/resources/450_1000.jpg")));
		lblNewLabel.setBounds(380, 85, 183, 174);
		frame.getContentPane().add(lblNewLabel);
		
		
}
}
