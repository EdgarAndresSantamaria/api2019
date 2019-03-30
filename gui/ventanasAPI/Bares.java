package ventanasAPI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Bares {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bares window = new Bares();
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
	public Bares() {
		initialize();
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
		
		JLabel lblBares = new JLabel("Bares");
		lblBares.setForeground(Color.WHITE);
		lblBares.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblBares.setBounds(188, 0, 165, 57);
		frame.getContentPane().add(lblBares);
		
		JButton btnMuditoBar = new JButton("Mudito Bar");
		btnMuditoBar.setBounds(34, 73, 225, 60);
		frame.getContentPane().add(btnMuditoBar);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Bares.class.getResource("/ventanasAPI/icon.png")));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(611, 16, 53, 41);
		frame.getContentPane().add(button);
		
		JButton btnBarVader = new JButton("Bar Vader");
		btnBarVader.setBounds(34, 151, 225, 60);
		frame.getContentPane().add(btnBarVader);
		
		JButton btnBarBestial = new JButton("Bar Bestial");
		btnBarBestial.setBounds(288, 73, 225, 60);
		frame.getContentPane().add(btnBarBestial);
		
		JButton btnBarGolfo = new JButton("Bar Golfo");
		btnBarGolfo.setBounds(288, 151, 225, 60);
		frame.getContentPane().add(btnBarGolfo);
		
		JButton btnBarParque = new JButton("Bar Parque");
		btnBarParque.setBounds(34, 227, 225, 60);
		frame.getContentPane().add(btnBarParque);
		
		JButton btnBarTequila = new JButton("Bar Tequila");
		btnBarTequila.setBounds(288, 227, 225, 60);
		frame.getContentPane().add(btnBarTequila);
		
		JButton btnPicotea = new JButton("Picotea");
		btnPicotea.setBounds(15, 410, 115, 29);
		frame.getContentPane().add(btnPicotea);
	}
}
