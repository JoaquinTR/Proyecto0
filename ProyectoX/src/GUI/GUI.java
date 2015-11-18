package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
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
 * Clase que modela la Interfaz Gr�fica.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
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

	private JLabel posM;

	private JLabel posG;
	
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
		
		//tama�o no maximizado de la gui.
		setSize(698,500);
		
		//creacion y seteo del panel.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Supers-Bomberman�");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon b=new ImageIcon(this.getClass().getResource("/images/logo/logo.gif"));
		setIconImage(b.getImage());
		contentPane.setVisible(true);
		
		posM=new JLabel();
		posM.setBounds(800, 10, 150, 100);
		posM.setText("POS");
		posM.setForeground(Color.WHITE);
		add(posM);
		
		posG=new JLabel();
		posG.setBounds(1000, 10, 150, 100);
		posG.setText("POS");
		posG.setForeground(Color.WHITE);
		add(posG);
		 
		
		//Creacion del nivel.
		MiNivel=new NIVEL(this);
		
		//imagen de fondo.
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1400, 1000);
		add(fondo);
		ImageIcon a=new ImageIcon(this.getClass().getResource("/images/fondo/fondo.jpg"));
		a = new ImageIcon(a.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
		fondo.setIcon(a);
		
		//Creacion del reloj.
		r=new RELOJ(MiNivel,this);
		
		
		
		
		
		
		//sonidos
		
		try {
			AudioInputStream musicaFondo = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/fondoJuego/avengers.MID"));
			clip = AudioSystem.getClip();
			clip.open(musicaFondo);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
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
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 }
	
	//puse pulse en reloj, sacar.
	public void pulse(){
		posM.setText("PosicionM: "+MiNivel.getEnemigos().getFirst().getX()+" "+MiNivel.getEnemigos().getFirst().getY());
		posG.setText("PosicionG: "+MiNivel.getEnemigos().getFirst().getGrafico().getX()+" "+MiNivel.getEnemigos().getFirst().getGrafico().getY());
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
					
					if(!start){
						start();
						start=true;
					}
				
					
					break;
				case KeyEvent.VK_DOWN :
					
					lock=true;
					
					MiNivel.mover(constantes.ABAJO);	
					
					if(!start){
						start();
						start=true;
					}
					
					
					break;
				case KeyEvent.VK_LEFT : 
					
					lock=true;
					
					MiNivel.mover(constantes.IZQUIERDA);
					
					if(!start){
						start();
						start=true;
					}
					
					
					break;
				case KeyEvent.VK_RIGHT : 
					
					lock=true;
					
					MiNivel.mover(constantes.DERECHA);	
					
					if(!start){
						start();
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
	 	
	 	/**
	 	 * Inicia el juego.
	 	 */
	 	public void start(){
	 		r.start();
	 		MiNivel.start();
	 	}
	 	
	
}
