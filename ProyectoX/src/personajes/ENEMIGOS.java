package personajes;

import nivel.NIVEL;

/**
 * 
 */
public abstract class ENEMIGOS extends PERSONAJE {

    /**
     * @param MiNivel 
     * @param x 
     * @param y 
     * @param vel
     */
    protected ENEMIGOS(NIVEL MiNivel, int x, int y, float vel) {
        super(MiNivel,x,y,vel);
    }

    /**
     * 
     */
    public abstract void avanzar();

}