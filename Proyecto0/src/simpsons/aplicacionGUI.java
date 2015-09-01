package simpsons;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class aplicacionGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aplicacionGUI frame = new aplicacionGUI();
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
	public aplicacionGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel img = new JLabel("");
		img.setVerticalAlignment(SwingConstants.TOP);
		img.setIcon(new ImageIcon("C:\\Users\\Mica\\Desktop\\index.jpg"));
		img.setBounds(0, 0, 202, 225);
		contentPane.add(img);
		
		JButton btnHablar = new JButton("hablar");
		btnHablar.setBounds(222, 34, 89, 23);
		contentPane.add(btnHablar);
	}
}
