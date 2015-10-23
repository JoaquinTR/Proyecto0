package personajes;

import java.util.Random;


import graficos.ruguloGrafico;
import mapa.CELDA;
import nivel.NIVEL;

/**
 * 
 */
public class RUGULOS extends ENEMIGOS {

	
	private rugulosThread T;

    /**
     * @param MiNivel 
     * @param x 
     * @param y
     */
    public RUGULOS(NIVEL MiNivel, int x, int y) {
        super(MiNivel,x,y,1);
        this.grafico = new ruguloGrafico(x,y);
        T=new rugulosThread(this);
        T.start();
    }

    /**
     * 
     */
    public void avanzar() {
    	Random rnd = new Random();
		int dir = rnd.nextInt(4);
    	
		CELDA actual = MiNivel.getCelda(x, y, -1);
    	CELDA next= MiNivel.getCelda(x, y, dir);
    	
    	
    	if(next.puedoEntrar()){
    		T.setDir(dir);
    		T.iniciar();
    		actual.quitarPersonaje(this);
    		next.agregarPersonaje(this);
    		this.x=next.getX();
    		this.y=next.getY();
    		System.out.println("Pos en matriz Enemigo: "+x+"::"+y);
    		System.out.println("Pos en tablero Enemigo: "+grafico.getPos().getX()+"::"+grafico.getPos().getY());
    	}
    	if((next.getX()==MiNivel.getBomberman().getX())&&(next.getY()==MiNivel.getBomberman().getY())){
    		MiNivel.getBomberman().select(12);//afecto al bomberman
    		MiNivel.getBomberman().destruirme();
    	}
		
		
    }
    public void mover(int dir){
    	grafico.select(dir);
		grafico.mover(dir);
    }
}