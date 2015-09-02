package simpsons;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class aplicacionGUI extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	JTextArea textArea;
	
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
		
		JButton btnHablar = new JButton("hablar");
		btnHablar.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		btnHablar.setBackground(Color.GRAY);
		btnHablar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s="\"Woohoo!\" \n        -Homero.";
				textArea.setText(s);
				
				
				String soundName = "Woohoo!.wav";    
				AudioInputStream audioInputStream;
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
				
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				 label.setVisible(true);				
				
				
			}
		});
		btnHablar.setBounds(272, 31, 89, 23);
		contentPane.add(btnHablar);
		
		label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
				if(label.isVisible()){
					String soundName = "doh.wav";    
					AudioInputStream audioInputStream;
					try {
						audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
				
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				
				if(label.isVisible()){
					String soundName = "doh.wav";    
					AudioInputStream audioInputStream;
					try {
						audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
				
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}
				}
				
				
				
				
			}
		});
		
		
		label.setIcon(new ImageIcon("C:\\Users\\Mica\\git\\Proyecto0\\Proyecto0\\woohoo.jpg"));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(5, 5, 257, 225);
		label.setVisible(false);
		contentPane.add(label);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.GRAY);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBounds(272, 65, 184, 51);
		contentPane.add(textArea);
	}
	
}
