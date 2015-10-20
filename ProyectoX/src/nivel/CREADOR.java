package nivel;

import mapa.CELDA;

/**
 * 
 */
public abstract class CREADOR {

    /**
     * Default constructor
     */
    public CREADOR() {
    }




    /**
     * @param grilla 
     * @param MiNivel
     */
    public abstract void crearNivel(CELDA[] grilla, NIVEL MiNivel);

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public abstract void crearRugulos(int x, int y, NIVEL MiNivel);

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public abstract void crearAltair(int x, int y, NIVEL MiNivel);

    /**
     * @param MiNivel
     */
    public abstract void crearSirius(NIVEL MiNivel);

    /**
     * @param MiNivel
     */
    public abstract void crearBomberman(NIVEL MiNivel);

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public abstract void crearSpeedup(int x, int y, NIVEL MiNivel);

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public abstract void crearFatality(int x, int y, NIVEL MiNivel);

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public abstract void crearBombality(int x, int y, NIVEL MiNivel);

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public abstract void crearMasacrality(int x, int y, NIVEL MiNivel);

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public abstract void crearCelda(int x, int y, NIVEL MiNivel);

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public abstract void crearCeldaPD(int x, int y, NIVEL MiNivel);

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public abstract void crearCeldaPI(int x, int y, NIVEL MiNivel);

}