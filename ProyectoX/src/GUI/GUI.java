package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import nivel.NIVEL;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private NIVEL MiNivel;
	
	private JLabel test;
	
	//constructor
	public GUI(){
		//mover personaje
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		
		setSize(698,720);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Supers-Bomberman®");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		//SACAR
		ImageIcon a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapAbajoQ.gif"));
		a = new ImageIcon(a.getImage().getScaledInstance(44, 44, Image.SCALE_DEFAULT));
		
		test = new JLabel(a);
		test.setBounds(44,179,44,44);
		add(test);
		//SACAR
		*/
		MiNivel=new NIVEL(this);
		
		
		
		contentPane.setVisible(true);
		
		
		//Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo/logo.gif"));
		//setIconImage(icon);
		ImageIcon b=new ImageIcon(this.getClass().getResource("/images/logo/logo.gif"));
		setIconImage(b.getImage());
		
		pack();
		setVisible(true);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 }
	
	 public void mover(KeyEvent arg0){
		   
		   int dir= arg0.getKeyCode();
			switch (dir){
			case KeyEvent.VK_UP : //Arriba
				MiNivel.getBomberman().moverArriba();
				
				break;
			case KeyEvent.VK_DOWN : //Abajo
				MiNivel.getBomberman().moverAbajo();	
			
				break;
			case KeyEvent.VK_LEFT : //Izquierda
				MiNivel.getBomberman().moverIzquierda();	
				
				break;
			case KeyEvent.VK_RIGHT : //Derecha
				MiNivel.getBomberman().moverDerecha();	
				break;
			}
		}
	
	
}
