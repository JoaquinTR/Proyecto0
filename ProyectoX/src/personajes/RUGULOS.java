package personajes;

import java.awt.event.KeyEvent;
import java.util.Random;

import graficos.jugadorGrafico;
import nivel.NIVEL;

/**
 * 
 */
public class RUGULOS extends ENEMIGOS {


    /**
     * @param MiNivel 
     * @param x 
     * @param y
     */
    public RUGULOS(NIVEL MiNivel, int x, int y) {
        super(MiNivel,x,y,1);
        this.grafico = new jugadorGrafico(x,y);
    }

    /**
     * 
     */
    public void avanzar() {
    	Random rnd = new Random();
		int dir = rnd.nextInt(4);
		
		grafico.mover(dir);
		
    }
}