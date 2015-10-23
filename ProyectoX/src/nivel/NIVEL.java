package nivel;

import java.util.*;

import GUI.GUI;
import bomba.BOMBA;
import mapa.CELDA;
import personajes.BOMBERMAN;
import personajes.ENEMIGOS;
import personajes.RUGULOS;
import personajes.bombermanThread;
import personajes.rugulosThread;

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
    
    
    private GUI gui;

    public NIVEL(GUI gui) {
    	this.gui=gui;
    	
    	Grilla = new CELDA[31][13];
    	Enemigos= new ENEMIGOS[10];
    	Creador=new CREADORNIVEL();
    	
		Creador.crearNivel(Grilla, this, gui,Enemigos);
		
		Bomberman.start();//inicio el thread, no iniciaba nunca en el constructor de bomberman.
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
    
    public void mover(int dir){
    	Bomberman.select(dir);
    	Bomberman.avanzarB(dir);
    }
    
    public void moverM(){
    	for(int i=0;i<Enemigos.length;i++){
    		if(Enemigos[i]!=null){
    			Enemigos[i].avanzar();
    		}
    	}

    	
    }
    
    public void unlock(){
    	gui.unlock();
    }
    
    public void lock(){
    	gui.lock();
    }
    
    public CELDA getCelda(int x, int y,int dir){
    	CELDA next = null;
    	switch(dir){
    		case 0:
    			next= Grilla[x][y+1];
    			break;
    		case 1:
    			next = Grilla[x][y-1];
    			break;
    		case 2:
    			next = Grilla[x-1][y];
    			break;
    		case 3:
    			next = Grilla[x+1][y];
    			break;
    		case -1:
    			next=Grilla[x][y];
    			break;
    	}
    	return next;
    }
    
    
    
}