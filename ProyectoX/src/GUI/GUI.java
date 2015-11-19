package GUI;

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
	 * Panel contenedor.
	 */
	private JPanel contentPaneMenu;
	
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
	
	/**
	 * Indica si se termino el juego.
	 */
	private boolean end;

	
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
		
		inicializarMenu();
		
		
		//adicionales a la gui.
		setVisible(true);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	/**
	 * Genera la pantalla de presentacion.
	 */
	private void inicializarMenu() {
				//creacion y seteo del panel.
				contentPaneMenu = new JPanel();
				contentPaneMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPaneMenu);
				contentPaneMenu.setLayout(null);
				setTitle("Supers-Bomberman®");
				getContentPane().setLayout(null);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ImageIcon b=new ImageIcon(this.getClass().getResource("/images/logo/logo.gif"));
				setIconImage(b.getImage());
				contentPaneMenu.setVisible(true);
				
				JLabel PressEnter = new JLabel();
				PressEnter.setBounds(20, 375, 550, 125);
				ImageIcon IPE=new ImageIcon(this.getClass().getResource("/images/menu/PressEnter3.gif"));
				IPE = new ImageIcon(IPE.getImage().getScaledInstance(PressEnter.getWidth(), PressEnter.getHeight(), Image.SCALE_DEFAULT));
				PressEnter.setIcon(IPE);
				add(PressEnter);
				
				JLabel fondo = new JLabel();
				fondo.setBounds(0, 0, 1400, 1000);
				ImageIcon IF=new ImageIcon(this.getClass().getResource("/images/menu/EstePro.gif"));
				IF = new ImageIcon(IF.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
				fondo.setIcon(IF);
				add(fondo);
				
				
		
	}

	/**
	 * inicializa en nivel principal.
	 */
	private void initGUI(){
		//creacion y seteo del panel.
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				getContentPane().setLayout(null);
				 
				//el juego no termino cuando recien empezo.
				end=false;
				
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
				
				//arranca los Threads de los malos.
				start();
				
				//se muestra el contentPane ya cargado mas arriba.
				contentPane.setVisible(true);
	}
	
	/**
	 * metodo main, crea una nueva gui (esta clase).
	 * 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//menuPrincipal m=new menuPrincipal();
					GUI frame = new GUI();
					frame.setVisible(true);
					//m.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 }
	
	
	/**
	 * Se activa cuando se gana el juego, lo muestra graficamente.
	 */
	public void ganar(){
		if(!end){
			JLabel g =new JLabel();
			g.setBounds(388, 350, 600, 128);
			ImageIcon i=new ImageIcon(this.getClass().getResource("/images/menu/Congrats.gif"));
			i = new ImageIcon(i.getImage().getScaledInstance(g.getWidth(), g.getHeight(), Image.SCALE_DEFAULT));
			g.setIcon(i);
			this.agregarObjeto(g);
			g.setVisible(true);
			g.repaint();
			end=true;
		}
	}
	
	/**
	 * Se activa cuando se muere el bomberman, lo muestra graficamente.
	 */
	public void perder(){
		JLabel g =new JLabel();
		g.setBounds(510, 375, 338, 100);
		ImageIcon i=new ImageIcon(this.getClass().getResource("/images/menu/GameOver.gif"));
		i = new ImageIcon(i.getImage().getScaledInstance(g.getWidth(), g.getHeight(), Image.SCALE_DEFAULT));
		g.setIcon(i);
		this.agregarObjeto(g);
		g.setVisible(true);
		g.repaint();
		end=true;
	}
	
	/**
	 * toma el teclado y manda el mensaje mover al nivel con la direccion
	 * a la que se tiene que mover el bomberman. adicionalmente, el primer
	 * movimiento inicia el reloj, y con esto el movimiento de los enemigos.
	 */
	 public void mover(KeyEvent arg0){
	 		int dir= arg0.getKeyCode();
	 		
	 		if(start){

	 			if(!lock){
	 				switch (dir){
	 				case KeyEvent.VK_UP :
						lock=true;
						MiNivel.mover(constantes.ARRIBA);
						break;
					case KeyEvent.VK_DOWN :
						lock=true;
						MiNivel.mover(constantes.ABAJO);
						break;
					case KeyEvent.VK_LEFT : 
						lock=true;
						MiNivel.mover(constantes.IZQUIERDA);
						break;
					case KeyEvent.VK_RIGHT : lock=true;
						MiNivel.mover(constantes.DERECHA);	
						break;
	 				}

	 			}
	 		
	 			// Indica al nivel que el bomberman ponga una bomba en su posicion.
	 			if(dir== KeyEvent.VK_D){
	 			
	 				MiNivel.ponerBomba();

	 		
	 			}
	 		}else{
	 		
	 			if(dir== KeyEvent.VK_ENTER){
	 			
 					initGUI();

 		
 				}
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
	 		start=true;
	 		
	 	}
	 	
	
}
