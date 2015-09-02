package simpsons;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class aplicacionGUI extends JFrame {

	private JLabel contentPane;
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
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 380);
	
		contentPane = new JLabel();
		ImageIcon imga=new ImageIcon(this.getClass().getResource("images/simp.jpg"));
		contentPane.setIcon(new ImageIcon(imga.getImage().getScaledInstance(getWidth(), getHeight(),Image.SCALE_SMOOTH)));	
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, SystemColor.activeCaptionBorder, SystemColor.activeCaptionBorder, SystemColor.activeCaptionBorder));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		JButton btnHablar = new JButton("Click...");
		btnHablar.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		btnHablar.setBackground(Color.yellow);
		btnHablar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String s="\"Woohoo!\" \n        -Homero.";
				textArea.setBackground(Color.orange);
				textArea.setFont(new Font("OCR A Extended", Font.BOLD, 18));
				textArea.setText(s);
				
				ImageIcon img=new ImageIcon(this.getClass().getResource("images/woohoo.png"));
				label.setIcon(new ImageIcon(img.getImage().getScaledInstance(257,225,Image.SCALE_SMOOTH)));
				
   
				AudioInputStream audioInputStream;
				try {
					audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("sounds/Woohoo!.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
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
					String s="\"DOH!\" \n        -Homero.";
					textArea.setText(s);
					
					
					ImageIcon img=new ImageIcon(this.getClass().getResource("images/hdoh.png"));
					label.setIcon(new ImageIcon(img.getImage().getScaledInstance(257,225,Image.SCALE_SMOOTH)));
					

					AudioInputStream audioInputStream;
					try {
						audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("sounds/doh.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
						e.printStackTrace();
					}
				}
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				
				if(label.isVisible()){
					String s="\"DOH!\" \n        -Homero.";
					textArea.setText(s);
					
					
					ImageIcon img=new ImageIcon(this.getClass().getResource("images/hdohh.png"));
					label.setIcon(new ImageIcon(img.getImage().getScaledInstance(257,225,Image.SCALE_SMOOTH)));
					
					AudioInputStream audioInputStream;
					try {
						audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("sounds/doh.wav"));
						Clip clip = AudioSystem.getClip();
						clip.open(audioInputStream);
						clip.start();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ee) {
						ee.printStackTrace();
					}
				}
				
				
				
				
			}
		});
		
		
		label.setIcon(new ImageIcon("C:\\Users\\Mica\\git\\Proyecto0\\Proyecto0\\src\\simpsons\\images\\woohoo.jpg"));
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
