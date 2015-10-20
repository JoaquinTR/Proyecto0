package mapa;

import java.util.*;

import bomba.BOMBA;
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


    /**
     * @param Nivel 
     * @param x 
     * @param y
     */
    public CELDA(NIVEL Nivel, int x, int y) {
        this.x=x;
        this.y=y;
        this.MiNivel=Nivel;
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
    public void crearPared() {
        this.MiPared = new PARED(this);
    }

}