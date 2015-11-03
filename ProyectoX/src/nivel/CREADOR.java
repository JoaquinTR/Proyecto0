package nivel;

import GUI.GUI;
import mapa.CELDA;
import personajes.BOMBERMAN;
import personajes.ENEMIGOS;

/**
 * Clase que modela la Interfaz del creador del nivel.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public abstract class CREADOR {





    /**
     * constructor. Rellena la grilla con sus elementos correspondientes.
     * 
     * @param grilla grilla a rellenar.
     * @param MiNivel nivel al que pertenece
     * @param y posicion y en la matriz.
     */
    public abstract void crearNivel(CELDA[][] grilla, NIVEL MiNivel,GUI gui, ENEMIGOS[] e);

    /**
     * Crea un rugulo.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearRugulos(int x, int y, NIVEL MiNivel);

    /**
     * Crea un Altair.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearAltair(int x, int y, NIVEL MiNivel);

    /**
     * Crea un Sirius.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearSirius(NIVEL MiNivel);

    /**
     * Crea el bomberman.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearBomberman(NIVEL MiNivel);

    /**
     * Crea un Speedup.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearSpeedup(int x, int y, NIVEL MiNivel);

    /**
     * Crea un Fatality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearFatality(int x, int y, NIVEL MiNivel);

    /**
     * Crea un Bombality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearBombality(int x, int y, NIVEL MiNivel);

    /**
     * Crea un Masacrality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearMasacrality(int x, int y, NIVEL MiNivel);

    /**
     * Crea una Celda transitable.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearCelda(int x, int y, NIVEL MiNivel);

    /**
     * Crea una celda con pared destructible.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearCeldaPD(int x, int y, NIVEL MiNivel);

    /**
     * Crea una celda con pared indestructible.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public abstract void crearCeldaPI(int x, int y, NIVEL MiNivel);

}