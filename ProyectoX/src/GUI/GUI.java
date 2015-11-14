package GUI;

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import GUI.constantes;
import nivel.NIVEL;

/*------ANOTACIONES------
*	consultar un metodo para iniciar los thread de los enemigos,
*	cuando se mueva el bomberman se llama a un iniciar en esta gui.
*/



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
	private volatile boolean lock=false;
	
	/**
	 * Flag de inicio del nivel.
	 */
	private boolean start=false;
	
	/**
	 * sonido de fondo.
	 */
	private Clip clip;

	
	
	// -- ACLARACION -- 
	// ****************
	// ****************
	//los 4 label siguientes son de testeo, no van a estar en el proyectoX final.
	private JLabel pos;
	
	private JLabel pos2;
	
	private JLabel pos3;
	
	private JLabel pos4;

	
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
		r=new RELOJ(MiNivel,this);
		
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
		
		pos3=new JLabel();
		pos3.setText("Posicion");
		pos3.setBounds(575, 25, 250, 50);
		add(pos3);
		
		pos4=new JLabel();
		pos4.setText("Posicion grafica");
		pos4.setBounds(800, 25, 250, 50);
		add(pos4);
		
		
		
		
		//sonidos
		
		try {
			AudioInputStream musicaFondo = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/fondoJuego/avengers.MID"));
			clip = AudioSystem.getClip();
			clip.open(musicaFondo);
			clip.loop(clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {}
		

		 
		
		
		
		
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
					//menu Menu=new menu();
					//Menu.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 }
	
	// ---METODO AUXILIAR---
	// *********************
	// usado desde el reloj, le indica que hubo un pulso y
	// se debe actualizar los display de posicion del enemigo0 (el rugulo)
	public void pulse(){
		String a="Puntaje: "+MiNivel.getPuntaje();
		pos3.setText(a);
		a="Tiempo: "+r.getHoras()+":"+r.getMinutos()+":"+r.getSegundos();
		pos4.setText(a);
	}
	
	/**
	 * toma el teclado y manda el mensaje mover al nivel con la direccion
	 * a la que se tiene que mover el bomberman. adicionalmente, el primer
	 * movimiento inicia el reloj, y con esto el movimiento de los enemigos.
	 */
	 public void mover(KeyEvent arg0){
	 		int dir= arg0.getKeyCode();
	 		


	 		if(!lock){
	 			
	 			
	 			switch (dir){
				case KeyEvent.VK_UP :
					
					lock=true;
					
					MiNivel.mover(constantes.ARRIBA);
					
					String a="pos matriz: "+MiNivel.getBomberman().getX()+" "+MiNivel.getBomberman().getY();
					pos.setText(a);
					a="pos grafica: "+MiNivel.getBomberman().getGrafico().getX()+" "+MiNivel.getBomberman().getGrafico().getY();
					pos2.setText(a);
					
					if(!start){
						r.start();
						start=true;
					}
				
					
					break;
				case KeyEvent.VK_DOWN :
					
					lock=true;
					
					MiNivel.mover(constantes.ABAJO);	

					String a1="pos matriz: "+MiNivel.getBomberman().getX()+" "+MiNivel.getBomberman().getY();
					pos.setText(a1);
					a1="pos grafica: "+MiNivel.getBomberman().getGrafico().getX()+" "+MiNivel.getBomberman().getGrafico().getY();
					pos2.setText(a1);
					
					if(!start){
						r.start();
						start=true;
					}
					
					
					break;
				case KeyEvent.VK_LEFT : 
					
					lock=true;
					
					MiNivel.mover(constantes.IZQUIERDA);
					
					String a2="pos matriz: "+MiNivel.getBomberman().getX()+" "+MiNivel.getBomberman().getY();
					pos.setText(a2);
					a2="pos grafica: "+MiNivel.getBomberman().getGrafico().getX()+" "+MiNivel.getBomberman().getGrafico().getY();
					pos2.setText(a2);
					
					if(!start){
						r.start();
						start=true;
					}
					
					
					break;
				case KeyEvent.VK_RIGHT : 
					
					lock=true;
					
					MiNivel.mover(constantes.DERECHA);	
					
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
	 		
	 		// Indica al nivel que el bomberman ponga una bomba en su posicion.
	 		if(dir== KeyEvent.VK_D){
	 			
	 			MiNivel.ponerBomba();

	 		
	 		}

		}
	 	
	 /**
	  * Agrega un objeto a la gui.
	  * @param j JLabel a agregar.
	  */
	 public void agregarObjeto(JLabel j){
		 add(j);
		 contentPane.setComponentZOrder(j, 0);
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
