package powerups;

import nivel.NIVEL;

/**
 * Clase que modela un creador para el nivel.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class MASACRALITY extends POWERUP {

	/**
	 * timer de powerup.
	 */
	private masacralityThread m;
	
	/**
     * constructor.
     * 
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     * @param MiNivel nivel al que pertenece
     */
    public MASACRALITY(int x, int y, NIVEL MiNivel) {
    	super(x,y,MiNivel);
    	grafico.select(2);
    	m=new masacralityThread(this);
    	
    }

    /**
     * Afectar al bomberman. Le permite poner bombas ilimitadas y 
     * atravezar paredes destructibles.
     */
    public void ejecutar() {
    	MiNivel.setPuntaje(50);
        MiNivel.getBomberman().setMasacre();
        grafico.getGrafico().setVisible(false);
        m.start();
    	m.iniciar();
    }
    
    /**
     * Revierte el efecto de este powerup.
     */
    public void restaurar() {
        MiNivel.getBomberman().setMasacre();
        m.stop();
    }
}