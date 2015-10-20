package nivel;

import java.util.*;

import bomba.BOMBA;
import mapa.CELDA;
import personajes.BOMBERMAN;
import personajes.ENEMIGOS;

/**
 * 
 */
public class NIVEL {

    private int Puntaje;

    private int ParedesDestructiblesRestantes;

    private CREADOR Creador;

    protected BOMBERMAN Bomberman;

    protected ENEMIGOS[] Enemigos;

    protected BOMBA MiBomba;

    protected CELDA[] Grilla;

    public NIVEL() {
        //e s o
    }

    /**
     * @return
     */
    public CELDA[] getGrilla() {
        return Grilla;
    }

    /**
     * @return
     */
    public ENEMIGOS[] getEnemigos() {
        return Enemigos;
    }

    /**
     * @return
     */
    public BOMBERMAN getBomberman() {
        return Bomberman;
    }

    /**
     * @return
     */
    public int getPuntaje() {
        return Puntaje;
    }

    /**
     * @param p
     */
    public void setPuntaje(int p) {
    	Puntaje += p;
    }

    /**
     * @return
     */
    public BOMBA getBomba() {
        return MiBomba;
    }

    /**
     * @return
     */
    public int getPDR() {
        return ParedesDestructiblesRestantes;
    }

    /**
     * @param n
     */
    public void decPDR(int n) {
    	ParedesDestructiblesRestantes -= n;
    }

}