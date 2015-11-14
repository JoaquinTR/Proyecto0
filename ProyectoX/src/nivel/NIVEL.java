package nivel;

import java.io.IOException;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;

import bomba.BOMBA;
import GUI.GUI;
import GUI.constantes;
import mapa.CELDA;
import personajes.BOMBERMAN;
import personajes.ENEMIGOS;

/**
 * Clase que modela la logica de nivel.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class NIVEL {

	/**
	 * Puntaje de la partida.
	 */
    private int Puntaje;

    /**
     * Cantidad de paredes destructibles restantes.
     */
    private int ParedesDestructiblesRestantes;

    /**
     * Creador del nivel.
     */
    private CREADOR Creador;

    /**
     * Bomberman del jugador.
     */
    protected static BOMBERMAN Bomberman;

    /**
     * enemigos del nivel.
     */
    protected LinkedList<ENEMIGOS> Enemigos;

    /**
     * la grilla del nivel. 
     */
    protected CELDA[][] Grilla;
    
    /**
     * interfaz grafica que se encarga de las interacciones usuario-logica.
     */
    private GUI gui;

    
    
    
    /**
     * Constructor del nivel.
     * @param gui la interfaz grafica del nivel.
     */
    public NIVEL(GUI gui) {
    	this.gui=gui;
    	
    	Grilla = new CELDA[31][13];
    	//Enemigos= new ENEMIGOS[10];
    	Enemigos =new LinkedList<ENEMIGOS>();

    	Creador=new CREADORNIVEL();
    	
		Creador.crearNivel(Grilla, this, gui,Enemigos);
		
		Bomberman.start();//inicio el thread, no iniciaba nunca en el constructor de bomberman.
		
		ParedesDestructiblesRestantes = 110;
    }
    

    /**
     * Retorna el arreglo de enemigos.
     * @return los enemigos.
     */
    public LinkedList<ENEMIGOS> getEnemigos() {
        return Enemigos;
    }

    /**
     * Retorna el bomberman.
     * @return el bomberman.
     */
    public BOMBERMAN getBomberman() {
    	if(Bomberman==null)
    		Bomberman=new BOMBERMAN(this,1,1);
        return Bomberman;
    }

    /**
     * Retorna el puntaje actual.
     * @return Puntaje del nivel.
     */
    public int getPuntaje() {
        return Puntaje;
    }

    /**
     * Aumenta el puntaje p puntos.
     * @param p cantidad de puntos a aumentar.
     */
    public void setPuntaje(int p) {
    	Puntaje += p;
    }

    /**
     * Retorna la cantidad de paredes que se no se destruyeron.
     * @return cantidad de paredes restantes para ser destruidas.
     */
    public int getPDR() {
        return ParedesDestructiblesRestantes;
    }

    /**
     * decrementa la cantidad de paredes por destruir.
     */
    public void decPDR() {
    	ParedesDestructiblesRestantes --;
    }
    
    /**
     * mover al bomberman en la direccion pasada por paramentro
     * @param dir direccion del movimiento.
     */
    public void mover(int dir){
    	Bomberman.avanzarB(dir);
    }
    
    /**
     * mover a todos los enemigos ( en funcion del reloj)
     */
    public void moverM(){
    	
    	for(ENEMIGOS e:Enemigos){
    			e.avanzar();
    	}
    	
    }
    
    /**
     * destraba el teclado.
     */
    public void unlock(){
    	gui.unlock();
    }
    
    /**
     * traba el teclado.
     */
    public void lock(){
    	gui.lock();
    }
    
    /**
     * Obtiene la celda a utilizar y la retorna.
     * 
     * @param x posicion en x de la matriz.
     * @param y posicion en y de la matriz.
     * @param dir direccion a buscar en la matriz.	
     * @return la celda dependiendo de la direccion: 0 abajo, 1 arriba, 2 izquierda, 3 derecha, -1 la celda actual.
     */
    public CELDA getCelda(int x, int y,int dir){
    	
    	CELDA next = null;
    	
    	try{
    		
    		
    		switch(dir){
    			case constantes.ABAJO:
    				next= Grilla[x][y+1];
    				break;
    			case constantes.ARRIBA:
    				next = Grilla[x][y-1];
    				break;
    			case constantes.IZQUIERDA:
    				next = Grilla[x-1][y];
    				break;
    			case constantes.DERECHA:
    				next = Grilla[x+1][y];
    				break;
    			case constantes.ACTUAL:
    				next=Grilla[x][y];
    				break;
    				
    	}
    	}catch(ArrayIndexOutOfBoundsException e){
    		return null;
    	}
    	return next;
    }
    
    //distancia manhattan.
    
    /**
     * Indica al bomberman que ponga una bomba en su posicion.
     */
    public void ponerBomba(){
    	BOMBA b= Bomberman.ponerBomba();
		
		if(b!=null){
			//Reproduzco el sonido de la bomba.
			try {
 	        	AudioInputStream stream;
 				stream = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/explosiones/bomb.wav"));
 				Clip explosion = AudioSystem.getClip();
 				explosion.open(stream);
 				explosion.start();
 			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {}
			
			//agrego la bomba a la gui.
			gui.agregarObjeto(b.getGrafico());
		}
    }
    
    /**
     * Agrega un JLabel a la gui.
     * @param j JLabel a agregar.
     */
    public void agregarObjeto(JLabel j){
    	gui.agregarObjeto(j);
    }
    
}