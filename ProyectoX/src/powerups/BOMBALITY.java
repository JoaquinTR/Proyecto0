package powerups;

import nivel.NIVEL;

/**
 * Clase que modela un creador para el nivel.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
 */
public class BOMBALITY extends POWERUP {

    /**
     * constructor.
     * 
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     * @param MiNivel nivel al que pertenece
     */
    public BOMBALITY(int x, int y, NIVEL MiNivel) {
    	super(x,y,MiNivel);
    	grafico.select(0);
  
    }

    /**
     * afectar al bomberman. aumenta la cant de bombas para poner en 1.
     */
    public void ejecutar() {
    	MiNivel.getBomberman().aumentarCantBombas();
    	//controlar efectos graficos.
    }

}