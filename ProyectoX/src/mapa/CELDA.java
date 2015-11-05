package mapa;


import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bomba.BOMBA;
import graficos.Grafico;
import graficos.celdaGrafica;
import nivel.NIVEL;
import personajes.PERSONAJE;
import powerups.POWERUP;

/**
 * Clase que modela una celda.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
 */
public class CELDA {

	/**
	 * posicion en x de esta celda en la matriz.
	 */
    private int x;

    /**
	 * posicion en y de esta celda en la matriz.
	 */
    private int y;

    /**
     * el nivel al que pertenece esta celda.
     */
    protected NIVEL MiNivel;

    /**
     * La pared que contiene esta celda.
     */
    protected PARED MiPared;

    /**
     * El power-up que contiene esta celda. Puede no tener.
     */
    protected POWERUP Powerup;

    /**
     * La bomba que contiene esta celda. Puede no tener.
     */
    protected BOMBA Bomba;

    /**
     * Los personajes presentes en esta celda, puede no haber.
     */
    protected LinkedList<PERSONAJE> Presentes;
    
    /**
     * el grafico de esta celda.
     */
    protected Grafico grafico;


    /**
     * constructor
     * @param Nivel Nivel al que va a pertenecer esta celda. 
     * @param x Coordenada x que va a ocupar esta celda en la matriz.
     * @param y Coordenada y que va a ocupar esta celda en la matriz.
     */
    public CELDA(NIVEL Nivel, int x, int y) {
    	MiPared=null;
        this.x=x;
        this.y=y;
        this.MiNivel=Nivel;
        grafico = new celdaGrafica(x,y);
        Presentes=new LinkedList<PERSONAJE>();
    }

    /**
     * selecciona la imagen que el grafico va a mostrar esta celda.
     * @param i Indice de la foto que se va a mostrar.
     */
    public void select(int i){
		grafico.select(i);
	}
    
    /**
     * Retorna la posicion x de la posicion en la matriz que ocupa esta celda.
     * @return La coordenada x.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Retorna la posicion y de la posicion en la matriz que ocupa esta celda.
     * @return La coordenada y.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Retorna la pared que contiene esta celda. Retorna null en caso de que no tenga.
     * @return La pared sobre esta celda
     */
    public PARED getPared(){
    	return MiPared;
    }


    /**
     * Retorna los personajes que contiene esta celda.
     * @return Coleccion de personajes.
     */
    public LinkedList<PERSONAJE> getPresentes() {
        return this.Presentes;
    }
    
    
    /**
     * Retorna si hay alguien en esta celda.
     * @return True si hay alguien, falso caso contrario.
     */
    public boolean hayAlguien(){
    	
    	return !Presentes.isEmpty();
    	
    }

    /**
     * Retorna el power-up contenido. Retorna null si no hay.
     * @return El power-up en cuestion.
     */
    public POWERUP getPowerup() {
        return this.Powerup;
    }

    /**
     * Quita una bomba en caso que tenga.
     * @return La bomba en cuestion.
     */
    public void quitarBomba() {
        Bomba=null;
    }

    /**
     * Retorna la bomba contenido. Retorna null si no hay.
     * @return La bomba en cuestion.
     */
    public void setBomba(BOMBA b) {
        Bomba=b;
    }
    
    /**
     * Destruye la pared contenida en esta celda.
     */
    public void destruirPared() {
    	this.MiPared=null;
    }

    /**
     * Crea una pared destructible si se pasa verdadero, 
     * indestructible si se pasa falso por parametro.
     */
    public void crearPared(boolean DI) {
        this.MiPared = new PARED(this,DI);
    }
    
    /**
     * Retorna el JLabel de esta celda.
     * @return JLabel en cuestion.
     */
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
    
    /**
     * Agrega un personaje que acaba de entrar en esta celda.
     * @param p Personaje ingresante.
     */
    public void agregarPersonaje(PERSONAJE p){
    	Presentes.addLast(p);
    }
    
    /**
     * Quita un personaje que acaba de salir de esta celda.
     * @param p Personaje saliente.
     */
    public void quitarPersonaje(PERSONAJE p){
    	
    	Presentes.remove(p);
    		
    }

    /**
     * indica si hay una bomba en esta celda.
     * @return verdadero si hay una bomba falso caso contrario.
     */
	public boolean hayBomba() {
		return Bomba!=null;
	}
	
	/**
	 * Afecta a todos los personajes dentro de esta celda.
	 */
    public void afectar(){
    	grafico.select(9);
    	
    	destruirPared();
    	
    	for(PERSONAJE p: Presentes){
    		p.destruirme();
    	}
    }
    
    /**
	 * Restaurar.
	 */
    public void Restaurar(){
    	grafico.select(0);
    }
}