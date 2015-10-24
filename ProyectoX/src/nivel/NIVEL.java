package nivel;

import java.util.*;

import GUI.GUI;
import bomba.BOMBA;
import mapa.CELDA;
import personajes.BOMBERMAN;
import personajes.ENEMIGOS;
import personajes.RUGULOS;
import personajes.bombermanThread;
import personajes.rugulosThread;

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
    protected BOMBERMAN Bomberman;

    /**
     * enemigos del nivel.
     */
    protected ENEMIGOS[] Enemigos;

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
    	Enemigos= new ENEMIGOS[10];
    	Creador=new CREADORNIVEL();
    	
		Creador.crearNivel(Grilla, this, gui,Enemigos);
		
		Bomberman.start();//inicio el thread, no iniciaba nunca en el constructor de bomberman.
    }
    

    /**
     * Retorna el arreglo de enemigos.
     * @return los enemigos.
     */
    public ENEMIGOS[] getEnemigos() {
        return Enemigos;
    }

    /**
     * Retorna el bomberman.
     * @return el bomberman.
     */
    public BOMBERMAN getBomberman() {
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
     * @param n cantidad de paredes destruidas (entre 0 y 3 ).
     */
    public void decPDR(int n) {
    	ParedesDestructiblesRestantes -= n;
    }
    
    /**
     * mover al bomberman en la direccion pasada por paramentro
     * @param dir direccion del movimiento.
     */
    public void mover(int dir){
    	Bomberman.select(dir);
    	Bomberman.avanzarB(dir);
    }
    
    /**
     * mover a todos los enemigos ( en funcion del reloj)
     */
    public void moverM(){
    	for(int i=0;i<Enemigos.length;i++){
    		if(Enemigos[i]!=null){
    			Enemigos[i].avanzar();
    		}
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
    	switch(dir){
    		case 0:
    			next= Grilla[x][y+1];
    			break;
    		case 1:
    			next = Grilla[x][y-1];
    			break;
    		case 2:
    			next = Grilla[x-1][y];
    			break;
    		case 3:
    			next = Grilla[x+1][y];
    			break;
    		case -1:
    			next=Grilla[x][y];
    			break;
    	}
    	return next;
    }
    
    
    
}