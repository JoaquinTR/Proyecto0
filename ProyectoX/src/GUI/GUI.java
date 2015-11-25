package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
	 * Panel contenedor de la pantalla principal.
	 */
	private JPanel contentPaneMenu;
	
	/**
	 * Panel contenedor del selector de personaje.
	 */
	private JPanel contentPaneChar;
	
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
	 * indica si se esta en el menu.
	 */
	private boolean menu; 
	
	/**
	 * indica si se esta en la seleccion de personajes.
	 */
	private boolean character; 
	
	/**
	 * Imagenes de los JLabel de la pantalla de seleccion de personajes.
	 */
	private ImageIcon[] Images;
	
	/**
	 * personaje seleccionado.
	 */
	private int pointer;
	
	/**
	 * Labels de los personajes en seleccion de personajes.
	 */
	private JLabel[] personajes;
	
	/**
	 * Label de estado del power-up masacrality.
	 */
	private JLabel masacrality;
	
	/**
	 * Label de estado del power-up speedup.
	 */
	private JLabel speedup;
	
	/**
	 * Label contador del power-up speedup.
	 */
	private JLabel Cspeedup;
	
	/**
	 * Label de estado del power-up bombality.
	 */
	private JLabel bombality;
	
	/**
	 * Label contador del power-up bombality.
	 */
	private JLabel Cbombality;
	
	/**
	 * Label de estado del power-up fatality.
	 */
	private JLabel fatality;
	
	/**
	 * Label contador del power-up fatality.
	 */
	private JLabel Cfatality;
	
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
		
		//seteo inicial
		character=false;
		inicializarMenu();
		
		
		pointer = 0;
		//adicionales a la gui.
		setVisible(true);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	/**
	 * Genera la pantalla de presentacion.
	 */
	private void inicializarMenu() {
			
				menu=true;
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
				ImageIcon IPE=new ImageIcon(this.getClass().getResource("/images/menu/PressEnter.gif"));
				IPE = new ImageIcon(IPE.getImage().getScaledInstance(PressEnter.getWidth(), PressEnter.getHeight(), Image.SCALE_DEFAULT));
				PressEnter.setIcon(IPE);
				add(PressEnter);
				
				JLabel fondo = new JLabel();
				fondo.setBounds(0, 0, 1400, 1000);
				ImageIcon IF=new ImageIcon(this.getClass().getResource("/images/menu/EstePro.gif"));
				IF = new ImageIcon(IF.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
				fondo.setIcon(IF);
				add(fondo);
				
				try {
					
					AudioInputStream musicaFondo = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/fondoJuego/avengers.mid"));
					
					clip = AudioSystem.getClip();
					clip.open(musicaFondo);
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {}
		
	}

	/**
	 * Inicializa el panel de seleccion de caracteres.
	 */
	private void initCharSelect() {
		
		character=true;
		//creacion y seteo del panel.
		contentPaneChar= new JPanel();
		contentPaneChar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneChar);
		contentPaneChar.setLayout(null);
		setTitle("Supers-Bomberman®");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon b=new ImageIcon(this.getClass().getResource("/images/logo/logo.gif"));
		setIconImage(b.getImage());
		contentPaneChar.setVisible(true);
		
		Images = new ImageIcon[10];
		
		personajes = new JLabel[4];
		
		JLabel select = new JLabel();
		
		JLabel fondo = new JLabel();
		
		fondo.setBounds(0, 0, 1400, 1000);
		
		select.setBounds(400, 25, 550, 125);
		
		int offset= 325;
		
		personajes[0] =new JLabel();
		personajes[0].setBounds(100, 250, 169, 220);
		
		personajes[1] =new JLabel();
		personajes[1].setBounds(personajes[0].getX() + offset, 250, personajes[0].getWidth(), personajes[0].getHeight());
		
		personajes[2] =new JLabel();
		personajes[2].setBounds(personajes[1].getX() + offset, 250, personajes[0].getWidth(), personajes[0].getHeight());
		
		personajes[3] =new JLabel();
		personajes[3].setBounds(personajes[2].getX() + offset, 250, personajes[0].getWidth(), personajes[0].getHeight());
		
		ImageIcon a=new ImageIcon(this.getClass().getResource("/images/seleccionPersonajes/CapFocus.gif"));
		Images[0] = new ImageIcon(a.getImage().getScaledInstance(personajes[0].getWidth(), personajes[0].getHeight(), Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/seleccionPersonajes/SpidermanFocus.gif"));
		Images[1] = new ImageIcon(a.getImage().getScaledInstance(personajes[0].getWidth(), personajes[0].getHeight(), Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/seleccionPersonajes/SupermanFocus.gif"));
		Images[2] = new ImageIcon(a.getImage().getScaledInstance(personajes[0].getWidth(), personajes[0].getHeight(), Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/seleccionPersonajes/BatmanFocus.gif"));
		Images[3] = new ImageIcon(a.getImage().getScaledInstance(personajes[0].getWidth(), personajes[0].getHeight(), Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/seleccionPersonajes/CapOscuro.gif"));
		Images[4] = new ImageIcon(a.getImage().getScaledInstance(personajes[0].getWidth(), personajes[0].getHeight(), Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/seleccionPersonajes/SpidermanOscuro.gif"));
		Images[5] = new ImageIcon(a.getImage().getScaledInstance(personajes[0].getWidth(), personajes[0].getHeight(), Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/seleccionPersonajes/SupermanOscuro.gif"));
		Images[6] = new ImageIcon(a.getImage().getScaledInstance(personajes[0].getWidth(), personajes[0].getHeight(), Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/seleccionPersonajes/BatmanOscuro.gif"));
		Images[7] = new ImageIcon(a.getImage().getScaledInstance(personajes[0].getWidth(), personajes[0].getHeight(), Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/seleccionPersonajes/SelectSinBlanco.gif"));
		Images[8] = new ImageIcon(a.getImage().getScaledInstance(select.getWidth(), select.getHeight(), Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/fondo/fondo.jpg"));
		Images[9] = new ImageIcon(a.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
		
		personajes[0].setIcon(Images[0]);
		personajes[1].setIcon(Images[5]);
		personajes[2].setIcon(Images[6]);
		personajes[3].setIcon(Images[7]);
		
		select.setIcon(Images[8]);
		
		fondo.setIcon(Images[9]);
		
		add(personajes[0]);
		add(personajes[1]);
		add(personajes[2]);
		add(personajes[3]);
		
		add(select);
		
		add(fondo);
		
	}
	
	
	/**
	 * inicializa en nivel principal.
	 */
	private void initGUI(){
		
		//creacion y seteo del panel.
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(null);
				 
				//el juego no termino cuando recien empezo.
				end=false;
				
				//Creacion del nivel con su respectivo personaje y esta gui.
				MiNivel=new NIVEL(this, pointer);
				
				//Controles.
				JLabel D = new JLabel();
				D.setBounds(this.getWidth()-100, 10, 75, 75);
				contentPane.add(D);
				ImageIcon a=new ImageIcon(this.getClass().getResource("/images/controles/D.gif"));
				a = new ImageIcon(a.getImage().getScaledInstance(D.getWidth(), D.getHeight(), Image.SCALE_DEFAULT));
				D.setIcon(a);
				
				JLabel controles = new JLabel("CONTROLES: ");
				controles.setBounds(this.getWidth()-450, 10, 250, 75);
				controles.setForeground(Color.WHITE);
				controles.setFont(new Font(controles.getFont().getName(),Font.PLAIN,35));
				controles.setOpaque(false);
				contentPane.add(controles);
				
				JLabel flechas = new JLabel();
				flechas.setBounds(this.getWidth()-210, 10, 100, 75);
				contentPane.add(flechas);
				a=new ImageIcon(this.getClass().getResource("/images/controles/flechas.gif"));
				a = new ImageIcon(a.getImage().getScaledInstance(flechas.getWidth(), flechas.getHeight(), Image.SCALE_DEFAULT));
				flechas.setIcon(a);
				
				int offset = 75;
				
				int posY = 50;
				
				Cspeedup = new JLabel();
				Cspeedup.setBounds(5, posY, 75, 75);
				contentPane.add(Cspeedup);
				Cspeedup.setText("0");
				Cspeedup.setFont(new Font(controles.getFont().getName(),Font.PLAIN,45));
				Cspeedup.setForeground(Color.YELLOW);
				Cspeedup.setVisible(false);
				
				speedup = new JLabel();
				speedup.setBounds(5, posY, 75, 75);
				contentPane.add(speedup);
				a=new ImageIcon(this.getClass().getResource("/images/powerups/SpeedUpQ.gif"));
				a = new ImageIcon(a.getImage().getScaledInstance(speedup.getWidth(), speedup.getHeight(), Image.SCALE_DEFAULT));
				speedup.setIcon(a);
				speedup.setEnabled(false);
				
				Cbombality = new JLabel();
				Cbombality.setBounds(5 + offset, posY, 75, 75);
				contentPane.add(Cbombality);
				Cbombality.setText("0");
				Cbombality.setFont(new Font(controles.getFont().getName(),Font.PLAIN,45));
				Cbombality.setForeground(Color.YELLOW);
				Cbombality.setVisible(false);
				
				bombality = new JLabel();
				bombality.setBounds(5 + offset, posY, 75, 75);
				contentPane.add(bombality);
				a=new ImageIcon(this.getClass().getResource("/images/powerups/BombalityQ.gif"));
				a = new ImageIcon(a.getImage().getScaledInstance(bombality.getWidth(), bombality.getHeight(), Image.SCALE_DEFAULT));
				bombality.setIcon(a);
				bombality.setEnabled(false);
				
				Cfatality = new JLabel();
				Cfatality.setBounds(5 + offset*2, posY, 75, 75);
				contentPane.add(Cfatality);
				Cfatality.setText("0");
				Cfatality.setFont(new Font(controles.getFont().getName(),Font.PLAIN,45));
				Cfatality.setForeground(Color.YELLOW);
				Cfatality.setVisible(false);
				
				fatality = new JLabel();
				fatality.setBounds(5 + offset*2, posY, 75, 75);
				contentPane.add(fatality);
				a=new ImageIcon(this.getClass().getResource("/images/powerups/FatalityQ.gif"));
				a = new ImageIcon(a.getImage().getScaledInstance(fatality.getWidth(), fatality.getHeight(), Image.SCALE_DEFAULT));
				fatality.setIcon(a);
				fatality.setEnabled(false);
				
				masacrality = new JLabel();
				masacrality.setBounds(5 + offset*3, posY, 75, 75);
				contentPane.add(masacrality);
				a=new ImageIcon(this.getClass().getResource("/images/powerups/MasacralityQ.gif"));
				a = new ImageIcon(a.getImage().getScaledInstance(masacrality.getWidth(), masacrality.getHeight(), Image.SCALE_DEFAULT));
				masacrality.setIcon(a);
				masacrality.setEnabled(false);
				
				
				
				//imagen de fondo.
				JLabel fondo = new JLabel();
				fondo.setBounds(0, 0, 1400, 1000);
				contentPane.add(fondo);
				a=new ImageIcon(this.getClass().getResource("/images/fondo/fondo.jpg"));
				a = new ImageIcon(a.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
				fondo.setIcon(a);
				
				
				
				//Creacion del reloj.
				r=new RELOJ(MiNivel,this);
				
				//sonidos
				
				try {
					AudioInputStream musicaFondo=null;
					
					switch(MiNivel.getSJ()){
						case 0:
							musicaFondo = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/fondoJuego/CaptainAmerica.MID"));
							break;
						case 1:
							musicaFondo = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/fondoJuego/Spiderman.MID"));
							break;
						case 2:
							musicaFondo = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/fondoJuego/Superman.MID"));
							break;
						case 3:
							musicaFondo = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/fondoJuego/Batman.mid"));
							break;
					}
					
					clip = AudioSystem.getClip();
					clip.open(musicaFondo);
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {}
				
				//arranca los Threads de los malos.
				setContentPane(contentPane);
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
					
					GUI frame = new GUI();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 }
	
	
	/**
	 * Se activa cuando se gana el juego, lo muestra graficamente.
	 */
	@SuppressWarnings("deprecation")
	public void ganar(){
		if(!end){
			clip.stop();
			r.stop();
			try {
				
				AudioInputStream musicaFondo = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/fondoJuego/Win.mid"));
				
				clip = AudioSystem.getClip();
				clip.open(musicaFondo);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {}
			
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
	@SuppressWarnings("deprecation")
	public void perder(){
		clip.stop();
		r.stop();
		try {
			
			AudioInputStream musicaFondo = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/fondoJuego/GameOver.mid"));
			
			clip = AudioSystem.getClip();
			clip.open(musicaFondo);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {}
		
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
					case KeyEvent.VK_RIGHT : 
						lock=true;
						MiNivel.mover(constantes.DERECHA);	
						break;
	 				}

	 			}
	 		
	 			// Indica al nivel que el bomberman ponga una bomba en su posicion.
	 			if(dir== KeyEvent.VK_D){
	 			
	 				MiNivel.ponerBomba();

	 		
	 			}
	 			if(dir== KeyEvent.VK_ENTER){
	 				if(end) {
	 					System.exit(0);;
					}
	 			}
	 		}else{
	 		
	 			//selecciones del usuario, pasaje entre gui's.
	 			if(dir== KeyEvent.VK_ENTER){
	 			
	 				if(menu){
	 					initCharSelect();
	 					menu=false;
	 					contentPaneChar.updateUI();
	 				}
	 				else 
	 					if(character){
	 						character=false;
	 						clip.stop();
	 						initGUI();
	 					}
	 						
 				}
	 			
	 			if(character){
	 				//selecciones de personaje.
	 				switch (dir){
	 				case KeyEvent.VK_LEFT :
	 					if(pointer>0){
	 						personajes[pointer].setIcon(Images[pointer+4]);
	 						pointer--;
	 						personajes[pointer].setIcon(Images[pointer]);
	 					}
	 					break;
	 				case KeyEvent.VK_RIGHT :
	 					if(pointer<3){
	 						personajes[pointer].setIcon(Images[pointer+4]);
	 						pointer++;
	 						personajes[pointer].setIcon(Images[pointer]);
	 					}
	 					break;
	 				}
	 			}
	 			
	 		}
	 		
		}
	 

	/**
	  * Agrega un objeto a la gui.
	  * @param j JLabel a agregar.
	  */
	 public void agregarObjeto(JLabel j){
		 contentPane.add(j);
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
	 	
	 	/**
	 	 * aumenta la cantidad de speedups agarrados.
	 	 */
	 	public void aumentarSpeedup(){
	 		speedup.setEnabled(true);
	 		Cspeedup.setVisible(true);
	 		String S = Cspeedup.getText();
	 		Cspeedup.setText(""+(Integer.parseInt(S)+1));
	 		
	 	}
	 	
	 	/**
	 	 * aumenta la cantidad de speedups agarrados.
	 	 */
	 	public void aumentarBombality(){
	 		bombality.setEnabled(true);
	 		Cbombality.setVisible(true);
	 		String S = Cbombality.getText();
	 		Cbombality.setText(""+(Integer.parseInt(S)+1));
	 	}
	 	
	 	/**
	 	 * aumenta la cantidad de speedups agarrados.
	 	 */
	 	public void aumentarFatality(){
	 		fatality.setEnabled(true);
	 		Cfatality.setVisible(true);
	 		String S = Cfatality.getText();
	 		Cfatality.setText(""+(Integer.parseInt(S)+1));
	 	}
	 	
	 	/**
	 	 * activa masacrality.
	 	 */
	 	public void prenderMasacrality(){
	 		masacrality.setEnabled(true);
	 	}
	 	
	 	/**
	 	 * activa masacrality.
	 	 */
	 	public void apagarMasacrality(){
	 		masacrality.setEnabled(true);
	 	}
	 	
	 	
	
}
