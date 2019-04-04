package ventanasAPI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import modelo.Establecimiento;
import modelo.Resumen;

import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class Bar {

	private JFrame frame;
	private Establecimiento elBar;
	private JList<String> ofertas;

	/**
	 * Create the application.
	 */
	public Bar(Establecimiento bar) {
		elBar = bar;
		initialize();
		frame.setVisible(true);
	}
	
	private void anadirOferta() {
		String selectedOffer = ofertas.getSelectedValue();
		if (selectedOffer ==null ) {
			JOptionPane
			.showMessageDialog(null,
					"Debes seleccionar una oferta");
		}else {
			elBar.anadirCarritoOferta(selectedOffer.split(",")[0]);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 801, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSONObject bar = elBar.verEstablecimiento();
		String nombre = bar.getString("nombre");
		String descripcion = bar.getString("descripion");
		String tipo = bar.getString("tipo");
		String barrio = bar.getString("barrio");
		String mail = bar.getString("mail");
	
	
		Vector<String>  data = new Vector<String> ();
		JSONArray offers = bar.getJSONArray("ofertas");
		for (Object obj:offers) {
			JSONObject laoferta = (JSONObject) obj;
			JSONObject info = (JSONObject) laoferta.get("informacion");
			//recuperar información
			data.add(info.getString("nombre")+ ", "+ String.valueOf(laoferta.getFloat("precio"))+ " €");
		}
		
		ofertas = new JList<String>(data);
		ofertas.setBounds(50, 225, 250, 100);
		frame.getContentPane().add(ofertas);
		
		JButton btnAnadirOferta = new JButton("Añadir oferta");
		btnAnadirOferta.setForeground(SystemColor.text);
		btnAnadirOferta.setBackground(SystemColor.desktop);
		btnAnadirOferta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnAnadirOferta.setBounds(380, 250, 168, 69);
		btnAnadirOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Resumen.getInstance().getBar().equals("")) {
					Resumen.getInstance().setBar(elBar.getNombre());
					anadirOferta();
				}else if (Resumen.getInstance().getBar().equals(elBar.getNombre())){
					anadirOferta();
				}else {
					JOptionPane
					.showMessageDialog(null,
							"Solo puedes reservar en un bar al mismo tiempo, actualmente estas reservando en " + Resumen.getInstance().getBar());
				}
			}
			
		});
		frame.getContentPane().add(btnAnadirOferta);
		

		JLabel lblNewLabel = new JLabel(nombre);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(291, 4, 300, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDescripcion = new JLabel("descripcion: "+descripcion);
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblDescripcion.setBounds(50, 40, 300, 37);
		frame.getContentPane().add(lblDescripcion);
		
		JLabel lblTipo = new JLabel("Tipo: "+tipo);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblTipo.setBounds(50, 77, 300, 37);
		frame.getContentPane().add(lblTipo);
		
		JLabel lblBarrio = new JLabel("Barrio: " +barrio);
		lblBarrio.setForeground(Color.WHITE);
		lblBarrio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblBarrio.setBounds(50, 114, 300, 37);
		frame.getContentPane().add(lblBarrio);
		
		JLabel lblMail= new JLabel("-mail: "+mail);
		lblMail.setForeground(Color.WHITE);
		lblMail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblMail.setBounds(50, 151, 300, 37);
		frame.getContentPane().add(lblMail);
		

		JLabel lblOfertas = new JLabel("Ofertas");
		lblOfertas.setForeground(Color.WHITE);
		lblOfertas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblOfertas.setBounds(50, 188, 300, 37);
		frame.getContentPane().add(lblOfertas);
		
		JButton btnBusqueda = new JButton("Volver");
		btnBusqueda.setForeground(SystemColor.text);
		btnBusqueda.setBackground(SystemColor.desktop);
		btnBusqueda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBusqueda.setBounds(50, 380, 168, 69);
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Bares("bar","Ibarrekolanda");
			}
			
		});
		frame.getContentPane().add(btnBusqueda);
		
		JButton btnCarta = new JButton("Carta");
		btnCarta.setForeground(SystemColor.text);
		btnCarta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnCarta.setBackground(SystemColor.desktop);
		btnCarta.setBounds(380, 380, 144, 69);
		btnCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Carta(elBar);
			}
			
		});
		frame.getContentPane().add(btnCarta);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Carta.class.getResource("/icon.png")));
		btnNewButton.setBounds(624, 4, 50, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Perfil p=new Perfil();
				p.setVisible(true);
			}
			
		});
		frame.getContentPane().add(btnNewButton);
		
	}
}
