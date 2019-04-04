package ventanasAPI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import modelo.Picotea;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class Bares {

	private JFrame frame;
	private JList<String> bares;

	/**
	 * Create the application.
	 */
	public Bares(String categoria, String barrio) {
		initialize(categoria, barrio);
		frame.setVisible(true);
	}
	
	private void verBar() {
		String selectedBar = bares.getSelectedValue();
		if (selectedBar ==null ) {
			JOptionPane
			.showMessageDialog(null,
					"Debees seleccionar un bar");
		}else {
			frame.dispose();
			Picotea.getInstance().entrarEstablecimiento(selectedBar);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String categoria, String barrio) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 801, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBares = new JLabel("Bares");
		lblBares.setForeground(Color.WHITE);
		lblBares.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblBares.setBounds(291, 4, 300, 37);
		frame.getContentPane().add(lblBares);
		
		JSONObject establecimientos = Picotea.getInstance().verEstablecimientos(categoria,barrio);		
		
		Vector<String>  data = new Vector<String> ();
		JSONArray carta = establecimientos.getJSONArray("establecimientos");
		for (Object obj:carta) {
			//recuperar información
			data.add((String)obj);
		}
		bares = new JList<String>(data);
		bares.setBounds(50, 101, 250, 250);
		frame.getContentPane().add(bares);
		
		JButton btnAnadir = new JButton("Ver Bar");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verBar();
			}
			
		});
		btnAnadir.setForeground(SystemColor.text);
		btnAnadir.setBackground(SystemColor.desktop);
		btnAnadir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnAnadir.setBounds(380, 380, 168, 69);
		frame.getContentPane().add(btnAnadir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Perfil p=new Perfil();
				p.setVisible(true);
			}
			
		});
		btnVolver.setForeground(SystemColor.text);
		btnVolver.setBackground(SystemColor.desktop);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnVolver.setBounds(50, 380, 168, 69);
		frame.getContentPane().add(btnVolver);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Perfil.class.getResource("/calabacin.png")));
		lblNewLabel_1.setBounds(380, 101, 164, 150);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
