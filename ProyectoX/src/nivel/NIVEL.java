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
    
    protected rugulosThread r;
    
    protected bombermanThread b;

    public NIVEL(GUI gui) {
    	
    	
    	Grilla = new CELDA[31][13];
    	/*
    	Grilla[1][1]= new CELDA(this,1,1);
    	Grilla[1][1].select(0);
    	gui.add(Grilla[1][1].getGrafico());
    	*/
    	Enemigos= new ENEMIGOS[10];
    	Creador=new CREADORNIVEL();
		RUGULOS u= new RUGULOS(this,20,1); 
		Enemigos[0]=  u;
		Enemigos[0].select(1);
		r =new rugulosThread(u);
		gui.add(Enemigos[0].getGrafico());
		Creador.crearNivel(Grilla, this, gui);
		b= new bombermanThread(Bomberman);
		r.start();
		b.start();
    }
    
    public rugulosThread r(){
    	return r;
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
    	b.setDir(dir);
    	b.iniciar();
    	
    }
}