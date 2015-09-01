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
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JTextField;

public class aplicacionGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txt;
	
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
		setTitle("App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, SystemColor.activeCaptionBorder, SystemColor.activeCaptionBorder, SystemColor.activeCaptionBorder));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel img = new JLabel("");
		img.setVerticalAlignment(SwingConstants.TOP);
		img.setIcon(new ImageIcon("C:\\Users\\Mica\\Desktop\\index.jpg"));
		img.setBounds(5, 5, 202, 225);
		contentPane.add(img);
		
		JButton btnHablar = new JButton("hablar");
		btnHablar.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		btnHablar.setBackground(SystemColor.windowBorder);
		btnHablar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s="\"DOH!\" -Homero.";
				txt.setText(s);
			}
		});
		btnHablar.setBounds(222, 34, 89, 23);
		contentPane.add(btnHablar);
		
		txt = new JTextField();
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setEditable(false);
		txt.setBounds(217, 97, 207, 31);
		contentPane.add(txt);
		txt.setColumns(10);
	}
}
