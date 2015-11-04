package personajes;

import java.util.Random;


import graficos.ruguloGrafico;
import mapa.CELDA;
import nivel.NIVEL;

/**
 * Clase que modela un rugulo.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
 */
public class RUGULOS extends ENEMIGOS {

	/**
	 * variable Thread que controla la transicion del rugulo.
	 */
	private rugulosThread T;

    /**
     * constructor.
     * @param MiNivel nivel al que pertenece
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     */
    public RUGULOS(NIVEL MiNivel, int x, int y) {
        super(MiNivel,x,y,1);
        this.grafico = new ruguloGrafico(x,y);
        T=new rugulosThread(this);
    }

    /**
     * Avance propio de un Rugulo.
     */
    public void avanzar() {
    	if(!lock){
    		Random rnd = new Random();
			int dir = rnd.nextInt(4);
		
    		T.setDir(dir);
    		select(dir+4);
			CELDA actual = MiNivel.getCelda(x, y, -1);
    		CELDA next= MiNivel.getCelda(x, y, dir);
    	
    		boolean puedo=next.getPared()==null;
    	
    		if(puedo){
    			

    			actual.quitarPersonaje(this);
    			next.agregarPersonaje(this);
    			this.x=next.getX();
    			this.y=next.getY();

    			this.grafico.mover(dir);
    		
    			if((next.getX()==MiNivel.getBomberman().getX())&&(next.getY()==MiNivel.getBomberman().getY())){
    				MiNivel.getBomberman().select(12);//afecto al bomberman
    				MiNivel.getBomberman().destruirme();
    			}
    		
    		}
    		
    	
    	}
		
    }
    
    
    /**
     * Movimiento grafico de los Rugulos.
     * @param dir direccion ordenada.
     */
    public void mover(int dir){
    	grafico.select(dir);
		grafico.mover(dir);
    }
    
    /**
     * metodo de destruccion de los Rugulos.
     */
    public void destruirme(){
    	//experimental falta borrar el malo.
    	MiNivel.setPuntaje(15);
    }
}