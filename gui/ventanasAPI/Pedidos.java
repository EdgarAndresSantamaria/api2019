package ventanasAPI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import modelo.Establecimiento;
import modelo.Picotea;
import modelo.Resumen;

public class Pedidos {

	private JFrame frame;
	private Establecimiento bar;
	private JList<String> pedidos;
	private JList ofertas;
	private JList items;
	private JLabel lblbar;
	
	/**
	 * Create the application.
	 */
	public Pedidos() {
		initialize();
		frame.setVisible(true);
	}
	
	private JLabel getLblOfertas() {
		JLabel lblOfertas = new JLabel();
		lblOfertas = new JLabel("Ofertas");
		lblOfertas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblOfertas.setForeground(Color.WHITE);
		lblOfertas.setBounds(380, 60, 190, 30);
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
			ofertas.setBounds(380, 100, 250, 100);
		}
		return ofertas;
	}
	
	private JLabel getLblProductos() {
		JLabel lblProductos = new JLabel();
		lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setBounds(380, 210, 190, 30);
		return lblProductos;
	}
	
	private JLabel getLblEstablecimiento() {
		JLabel lblEStablecimiento = new JLabel();
		lblEStablecimiento = new JLabel("Establecimiento");
		lblEStablecimiento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblEStablecimiento.setForeground(Color.WHITE);
		lblEStablecimiento.setBounds(50, 210, 190, 30);
		return lblEStablecimiento;
	}
	
	private JLabel getLblContenidoBar() {
		if(lblbar==null) {
			lblbar = new JLabel();
			lblbar = new JLabel("");
			lblbar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblbar.setForeground(Color.WHITE);
			lblbar.setBounds(50, 240, 190, 30);
		}
		return lblbar;
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
			items.setBounds(380, 250, 250, 100);
		}
		return items;
	}
	
	private void cambiarPedido() {
		String selectedPedido = pedidos.getSelectedValue();
		if (selectedPedido != null ) {
			// anidado para nombre item , precio y spinner
			
			JSONObject pedido = null;
			for(Object obj:Picotea.getInstance().verPedidos().getJSONArray("pedidos")) {
				JSONObject pedidoTmp = (JSONObject) obj;
				if(String.valueOf(pedidoTmp.getFloat("id")).equals(selectedPedido)) {
					pedido = (JSONObject)pedidoTmp;
				}
			}
			
			DefaultListModel<String> dataTmpItems = new DefaultListModel<String>();
			JSONArray productos = pedido.getJSONArray("productos");
			for (Object item : productos) {
				JSONObject elItem = (JSONObject) item;
				// añadir nombre item
				dataTmpItems.addElement(elItem.getString("name") + ", " + String.valueOf(elItem.getFloat("precio")) + " €");
			}
			items.setModel( dataTmpItems );
			
			DefaultListModel<String> dataTmpOffers = new DefaultListModel<String>();
			JSONArray offers = pedido.getJSONArray("ofertas");
			for (Object obj : offers) {
				JSONObject laoferta = (JSONObject) obj;
				JSONObject info = (JSONObject) laoferta.get("informacion");
				//recuperar información
				dataTmpOffers.addElement(info.getString("nombre")+ ", "+ String.valueOf(laoferta.getFloat("precio"))+ " €");
			}
			ofertas.setModel( dataTmpOffers );
			lblbar.setText(pedido.getString("nombre"));
					
		}else {
			JOptionPane
			.showMessageDialog(null,
					"Selecciona un Pedido para verlo");
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
		
		JLabel lblCarta = new JLabel("PEDIDOS");
		lblCarta.setForeground(Color.WHITE);
		lblCarta.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCarta.setBounds(291, 4, 135, 37);
		frame.getContentPane().add(lblCarta);
		
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
		
		JLabel lblItem = new JLabel("PEDIDOS");
		lblItem.setForeground(Color.WHITE);
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblItem.setBounds(50, 60, 190, 30);
		frame.getContentPane().add(lblItem);
		
		// anidado para nombre item , precio y spinner
		Vector<String> dataTmp = new Vector<String>();
		JSONObject pedidosTmp = Picotea.getInstance().verPedidos();
		JSONArray listaPedidos = pedidosTmp.getJSONArray("pedidos");
		for (Object pedido : listaPedidos) {
			JSONObject elPedido = (JSONObject) pedido;
			// añadir nombre item
			dataTmp.add(String.valueOf(elPedido.getFloat("id")));
		}
		pedidos = new JList<String>(dataTmp);
		pedidos.setBounds(50, 100, 250, 100);
		pedidos.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            cambiarPedido();
	        }
	    });
		frame.getContentPane().add(pedidos);
		
		JButton btnBusqueda = new JButton("Volver");
		btnBusqueda.setForeground(SystemColor.text);
		btnBusqueda.setBackground(SystemColor.desktop);
		btnBusqueda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnBusqueda.setBounds(50, 380, 168, 69);
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Perfil r=new Perfil();
				r.setVisible(true);	
			}
			
		});
		frame.getContentPane().add(btnBusqueda);			
		frame.getContentPane().add(getLblProductos());			
		frame.getContentPane().add(getLblOfertas());			
		frame.getContentPane().add(getProductos());		
		frame.getContentPane().add(getOfertas());	
		frame.getContentPane().add(getLblEstablecimiento());	
		frame.getContentPane().add(getLblContenidoBar());	
	}
}
