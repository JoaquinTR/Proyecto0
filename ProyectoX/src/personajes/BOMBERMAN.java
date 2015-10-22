package personajes;

import java.util.*;

import graficos.jugadorGrafico;
import nivel.NIVEL;

/**
 * 
 */
public class BOMBERMAN extends PERSONAJE {

    /**
     * 
     */
    private boolean Masacre;

    /**
     * 
     */
    private int CantBombas;





    /**
     * @param MiNivel 
     * @param x 
     * @param y
     */
    public BOMBERMAN(NIVEL MiNivel, int x, int y) {
        super(MiNivel,x,y,3);
        
        this.grafico = new jugadorGrafico(x,y);
    }

    /**
     * 
     */
    public void moverDerecha() {
        grafico.moverDerecha();
    }

    /**
     * 
     */
    public void moverIzquierda() {
        grafico.moverIzquierda();
    }

    /**
     * 
     */
    public void moverAbajo() {
        grafico.moverAbajo();
    }

    /**
     * 
     */
    public void moverArriba() {
        grafico.moverArriba();
    }
    
    
    

    /**
     * 
     */
    public void ponerBomba() {
        // TODO implement here
    }

    /**
     * 
     */
    public void aumentarVelocidad() {
        velocidad*=2;
    }

    /**
     * 
     */
    public void aumentarCantBombas() {
        CantBombas++;
    }

    public void decCantBombas(){
    	CantBombas--;
    }
    
    /**
     * 
     */
    public void setMasacre() {
        
    	Masacre=!Masacre;
    }

}