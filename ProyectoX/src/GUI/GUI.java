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


/**
 * Clase que modela la Interfaz Gráfica.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Panel contenedor.
	 */
	private JPanel contentPane;
	
	/**
	 * Nivel.
	 */
	private NIVEL MiNivel;
	
	/**
	 * Variable Reloj que produce el clock del nivel.
	 */
	private RELOJ r;
	
	/**
	 * Blockeo de teclado.
	 */
	private boolean lock=false;
	
	/**
	 * Flag de inicio del nivel.
	 */
	private boolean start=false;
	
	// -- ACLARACION -- 
	// ****************
	// ****************
	//los 4 label siguientes son de testeo, no van a estar en el proyectoX final.
	private JLabel pos;
	
	private JLabel pos2;

	
	/**
	 * Constructor de la gui. Inicializa todo lo necesario para que la gui funcione
	 * y crea un nivel con sus elementos.
	 */
	public GUI(){
		
		//direccion de movimiento del bomberman.
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		
		//tamaño no maximizado de la gui.
		setSize(698,500);
		
		//creacion y seteo del panel.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Supers-Bomberman®");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon b=new ImageIcon(this.getClass().getResource("/images/logo/logo.gif"));
		setIconImage(b.getImage());
		contentPane.setVisible(true);
		
		//Creacion del nivel.
		MiNivel=new NIVEL(this);
		
		//Creacion del reloj.
		r=new RELOJ(MiNivel);
		
		//AUXILIARES NO VAN A ESTAR EN EL PROYECTO FINAL. 
		//AYUDAN A SEGUIR LAS ACTUALIZACIONES DE MOVIMIENTO DEL BOMBERMAN.
		pos=new JLabel();
		pos.setText("Posicion");
		pos.setBounds(25, 25, 250, 50);
		add(pos);
		
		pos2=new JLabel();
		pos2.setText("Posicion grafica");
		pos2.setBounds(300, 25, 250, 50);
		add(pos2);
		
		
		//adicionales a la gui.
		setVisible(true);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	
	/**
	 * metodo main, crea una nueva gui (esta clase).
	 * 
	 */
	
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
	
	/**
	 * toma el teclado y manda el mensaje mover al nivel con la direccion
	 * a la que se tiene que mover el bomberman. adicionalmente, el primer
	 * movimiento inicia el reloj, y con esto el movimiento de los enemigos.
	 */
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
	 	
	 	/**
	 	 * destraba el teclado.
	 	 */
	 	public void unlock(){
	 		lock=false;
	 	}
	 	
	 	/**
	 	 * traba el teclado manualmente (se usa cuando se muere el bomberman.
	 	 */
	 	public void lock(){
	 		lock=true;
	 	}
	 	
	
}
