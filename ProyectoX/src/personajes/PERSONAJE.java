package personajes;


import javax.swing.JLabel;

import graficos.Grafico;
import nivel.NIVEL;

/**
 * Clase abstracta que modela un personaje.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
 */
public abstract class PERSONAJE {

	/**
	 * Posicion en x del personaje en la matriz.
	 */
    protected int x;

    /**
	 * Posicion en y del personaje en la matriz.
	 */
    protected int y;

    /**
     * velocidad de avance del personaje.
     */
    protected int velocidad;

    /**
     * el nivel al que pertenece el personaje.
     */
    protected NIVEL MiNivel;
    
    /**
     * Grafico (JLabel) al que esta relacionado este personaje.
     */
    protected Grafico grafico;

    /**
     * constructor.
     * @param MiNivel nivel al que pertenece
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     * @param vel velocidad del personaje.
     */
    protected PERSONAJE(NIVEL MiNivel, int x, int y, int velocidad) {
        this.MiNivel=MiNivel;
        this.x=x;
        this.y=y;
        this.velocidad=velocidad;
        
        
    }

    /**
     * Obtiene el valor x actual de este personaje.
     * @return la posicion en x logica de la matriz.
     */
    public int getX() {
        return x;
    }

    /**
     * Obtiene el valor y actual de este personaje.
     * @return la posicion en y logica de la matriz.
     */
    public int getY() {
        return y;
    }
    
    /**
     * Retorna la velocidad del personaje.
     * @return velocidad del personaje en cuestion.
     */
    public float getVelocidad(){
    	return velocidad;
    }
    
    /**
     * retorna el objeto grafico de este personaje.
     * @return el grafico de este personaje.
     */
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
    
    /**
     * metodo a implementar, relacionado con la destruccion de este personaje.
     */
    public abstract void destruirme();
}