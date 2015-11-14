package personajes;

import nivel.NIVEL;

/**
 * Clase abstracta que modela un enemigo.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public abstract class ENEMIGOS extends PERSONAJE {

	/**
	 * Traba el movimiento de este enemigo, con el fin de 
	 * evitar errores propios de la combinacion de los Thread 
	 * y la logica (traspasaban paredes cuando no debian).
	 */
	protected volatile boolean lock;
	
    /**
     * constructor.
     * @param MiNivel nivel al que pertenece
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     * @param vel velocidad del enemigo.
     */
    protected ENEMIGOS(NIVEL MiNivel, int x, int y, int vel) {
        super(MiNivel,x,y,vel);
        lock=false;
    }

    /**
     * avance a implementar en las sublclases implementadoras.
     */
    public abstract void avanzar();
    
    /**
     * Traba el movimiento de este personaje.
     */
    public void lock(){
    	lock=true;
    }

    /**
     * Destraba el movimiento de este personaje.
     */
    public void unlock(){
    	lock=false;
    }
}