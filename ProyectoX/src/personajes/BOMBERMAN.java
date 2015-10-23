package personajes;

import java.awt.Point;
import java.util.*;

import graficos.jugadorGrafico;
import mapa.CELDA;
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
    
    private bombermanThread b;	
    




    /**
     * @param MiNivel 
     * @param x 
     * @param y
     */
    public BOMBERMAN(NIVEL MiNivel, int x, int y) {
        super(MiNivel,x,y,3);
        this.grafico = new jugadorGrafico(x,y);
        b=new bombermanThread(this);
        //b.start(); no inicia la gui si esta aca

    }

    
    //Para usar en el bombermanThread
    public void mover(int dir){
    	
    	grafico.mover(dir);
    	
    }
    
    //start manual del bomberman externo.
    public void start(){
    	b.start();
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
    
    public void avanzarB(int dir){
    	
    	
    	CELDA actual = MiNivel.getCelda(x, y, -1);
    	CELDA next= MiNivel.getCelda(x, y, dir);
    		
    	
    	if(next.puedoEntrar()){
    		boolean hay=false;
    		hay=next.hayAlguien();
    		
    		b.setDir(dir);
    		b.iniciar();
    		actual.quitarPersonaje(this);
    		next.agregarPersonaje(this);
    		this.x=next.getX();
    		this.y=next.getY();
    		System.out.println("Pos en matriz BOMBERMAN: "+x+"::"+y);
    		System.out.println("Pos en tablero BOMBERMAN: "+grafico.getPos().getX()+"::"+grafico.getPos().getY());
    		if(hay){
    			destruirme();
    		}
    		
    	}
    	else{
    		unlock();
    		select(dir+4);
    	}
    	
    	
    	

    }
    public void unlock(){
    	MiNivel.unlock();
    }
    
    public void destruirme(){
    	b.setDir(-2);
    	
    }
}

