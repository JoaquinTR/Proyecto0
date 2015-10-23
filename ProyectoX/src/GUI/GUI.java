package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import nivel.NIVEL;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private NIVEL MiNivel;
	
	private JLabel test;
	
	private RELOJ r;
	
	private boolean lock=false;
	
	private boolean start=false;
	
	private JLabel pos;
	
	private JLabel pos2;
	
	//constructor
	public GUI(){
		//mover personaje
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		
		
		
		
		setSize(698,500);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Supers-Bomberman®");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		MiNivel=new NIVEL(this);
		
		r=new RELOJ(MiNivel);
		//r.start();
		
		contentPane.setVisible(true);
		
		ImageIcon b=new ImageIcon(this.getClass().getResource("/images/logo/logo.gif"));
		setIconImage(b.getImage());
		
		pos=new JLabel();
		pos.setText("Posicion");
		pos.setBounds(25, 25, 250, 50);
		add(pos);
		
		pos2=new JLabel();
		pos2.setText("Posicion grafica");
		pos2.setBounds(300, 25, 250, 50);
		add(pos2);
		
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
	 		
	 			
	 			
	 		if(!lock){
	 			
	 			int dir= arg0.getKeyCode();
	 			switch (dir){
				case KeyEvent.VK_UP : //Arriba
					MiNivel.mover(1);
					String a="pos matriz: "+MiNivel.getBomberman().getX()+" "+MiNivel.getBomberman().getY();
					pos.setText(a);
					a="pos grafica: "+MiNivel.getBomberman().getGrafico().getX()+" "+MiNivel.getBomberman().getGrafico().getY();
					pos2.setText(a);
					
					if(!start){
						r.start();
						start=true;
					}
				
					break;
				case KeyEvent.VK_DOWN : //Abajo
					MiNivel.mover(0);	
					String a1="pos matriz: "+MiNivel.getBomberman().getX()+" "+MiNivel.getBomberman().getY();
					pos.setText(a1);
					a1="pos grafica: "+MiNivel.getBomberman().getGrafico().getX()+" "+MiNivel.getBomberman().getGrafico().getY();
					pos2.setText(a1);
					
					if(!start){
						r.start();
						start=true;
					}
					
					break;
				case KeyEvent.VK_LEFT : //Izquierda
					MiNivel.mover(2);
					String a2="pos matriz: "+MiNivel.getBomberman().getX()+" "+MiNivel.getBomberman().getY();
					pos.setText(a2);
					a2="pos grafica: "+MiNivel.getBomberman().getGrafico().getX()+" "+MiNivel.getBomberman().getGrafico().getY();
					pos2.setText(a2);
					
					if(!start){
						r.start();
						start=true;
					}
				
					break;
				case KeyEvent.VK_RIGHT : //Derecha
					MiNivel.mover(3);	
					String a3="pos matriz: "+MiNivel.getBomberman().getX()+" "+MiNivel.getBomberman().getY();
					pos.setText(a3);
					a3="pos grafica: "+MiNivel.getBomberman().getGrafico().getX()+" "+MiNivel.getBomberman().getGrafico().getY();
					pos2.setText(a3);
					
					if(!start){
						r.start();
						start=true;
					}
					
					break;
				}

	 		}
	 		lock=true;

		}
	 	
	 	public void unlock(){
	 		lock=false;
	 	}
	 	
	 	public void lock(){
	 		lock=true;
	 	}
	 	
	
}
