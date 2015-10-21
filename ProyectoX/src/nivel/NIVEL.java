package nivel;

import java.util.*;

import GUI.GUI;
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

    protected CELDA[][] Grilla;

    public NIVEL(GUI gui) {
    	
    	
    	Grilla = new CELDA[31][31];
    	/*
    	Grilla[1][1]= new CELDA(this,1,1);
    	Grilla[1][1].select(0);
    	gui.add(Grilla[1][1].getGrafico());
    	*/
    	
        Creador=new CREADORNIVEL();
        Creador.crearNivel(Grilla, this, gui);
        
    }

    /**
     * @return
     */
    public CELDA[][] getGrilla() {
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