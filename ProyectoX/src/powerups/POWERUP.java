package powerups;

import javax.swing.JLabel;

import graficos.Grafico;
import graficos.powerupGrafico;
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
public abstract class POWERUP {

	/**
	 * Posicion en x del power-up (en la matriz).
	 */
    protected int x;

    /**
     * Posicion en y del power-up (en la matriz).
     */
    protected int y;
    
    /**
     * Nivel al que pertenece el power-up.
     */
    protected NIVEL MiNivel;
    
    /**
     * Grafico de este powerup.
     */
    protected Grafico grafico;

    
    /**
     * constructor.
     * 
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     * @param MiNivel nivel al que pertenece
     */
    protected POWERUP(int x, int y,NIVEL MiNivel){
    	this.x=x;
    	this.y=y;
    	this.MiNivel=MiNivel;
    	this.grafico=new powerupGrafico(x,y);
    	
    }
    
    /**
     * Retorna el JLabel de esta celda.
     * @return JLabel en cuestion.
     */
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
    
    /**
     * La posicion x en la matriz del Power-up.
     * @return posicion en x.
     */
    public int getX() {
        return x;
    }

    /**
     * La posicion y en la matriz del Power-up.
     * @return posicion en y.
     */
    public int getY() {
        return y;
    }

    /**
     * Afectar al bomberman. Implementado en sub clases.
     */
    public abstract void ejecutar();

}