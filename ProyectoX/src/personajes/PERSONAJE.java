package personajes;


import javax.swing.JLabel;

import graficos.Grafico;
import nivel.NIVEL;

/**
 * 
 */
public abstract class PERSONAJE {

    protected int x;

    protected int y;

    protected float velocidad;

    protected NIVEL MiNivel;
    
    protected Grafico grafico;

    /**
     * @param MiNivel 
     * @param x 
     * @param y 
     * @param velocidad
     */
    protected PERSONAJE(NIVEL MiNivel, int x, int y, float velocidad) {
        this.MiNivel=MiNivel;
        this.x=x;
        this.y=y;
        this.velocidad=velocidad;
        
        
    }

    /**
     * @return
     */
    public int getX() {
        return x;
    }

    public void select(int i){
    	grafico.select(i);
    }
    
    /**
     * @return
     */
    public int getY() {
        return y;
    }

    public float getVelocidad(){
    	return velocidad;
    }
    
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
    
}