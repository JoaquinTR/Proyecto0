package mapa;

import java.util.*;

import javax.swing.JLabel;

import bomba.BOMBA;
import graficos.Grafico;
import graficos.celdaGrafica;
import nivel.NIVEL;
import personajes.PERSONAJE;
import powerups.POWERUP;

/**
 * 
 */
public class CELDA {

    private int x;

    private int y;

    protected NIVEL MiNivel;

    protected PARED MiPared;

    protected POWERUP Powerup;

    protected BOMBA Bomba;

    protected PERSONAJE Presentes[];
    
    protected Grafico grafico;


    /**
     * @param Nivel 
     * @param x 
     * @param y
     */
    public CELDA(NIVEL Nivel, int x, int y) {
    	MiPared=null;
        this.x=x;
        this.y=y;
        this.MiNivel=Nivel;
        grafico = new celdaGrafica(x,y);
    }

    public void select(int i){
		grafico.select(i);
	}
    
    /**
     * @return
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return
     */
    public int getY() {
        return this.y;
    }

    /**
     * @return
     */
    public boolean puedoEntrar() {
        return this.MiPared==null;
    }

    /**
     * @return
     */
    public boolean puedoRomper() {
        return this.MiPared!=null;
    }

    /**
     * @return
     */
    public PERSONAJE[] getPresentes() {
        return this.Presentes;
    }

    /**
     * @return
     */
    public POWERUP getPowerup() {
        return this.Powerup;
    }

    /**
     * @return
     */
    public BOMBA getBomba() {
        return Bomba;
    }

    /**
     * 
     */
    public void destruirPared() {
        this.MiPared=null;
    }

    /**
     *
     */
    public void crearPared(boolean DI) {
        this.MiPared = new PARED(this,DI);
    }
    
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}

}