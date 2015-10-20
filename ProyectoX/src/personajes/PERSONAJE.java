package personajes;

import java.util.*;

import nivel.NIVEL;

/**
 * 
 */
public abstract class PERSONAJE {

    protected int x;

    protected int y;

    protected float velocidad;

    protected NIVEL MiNivel;

    /**
     * @param MiNivel 
     * @param x 
     * @param y 
     * @param velocidad
     */
    protected PERSONAJE(NIVEL MiNivel, int x, int y, float velocidad) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * @return
     */
    public int getY() {
        return y;
    }

}