package personajes;

import java.util.Random;

import GUI.constantes;
import graficos.ruguloGrafico;
import mapa.CELDA;
import nivel.NIVEL;

/**
 * Clase que modela un rugulo.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class RUGULOS extends ENEMIGOS {

	/**
	 * variable Thread que controla la transicion del rugulo.
	 */
	@SuppressWarnings("unused")
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
    		Random rnd = new Random();
			int dir = rnd.nextInt(4);
		
    		
			CELDA actual = MiNivel.getCelda(x, y, -1);
    		CELDA next= MiNivel.getCelda(x, y, dir);
    	
    		boolean puedo=(next.getPared()==null)&(!next.hayBomba());
    	
    		if(puedo){
    			
    			//avanzo de celda el personaje a nivel grafica.
    			this.grafico.mover(dir);
    			
    			//avanzo de celda el personaje a nivel logica.
    			actual.quitarPersonaje(this);
    			next.agregarPersonaje(this);
    			this.x=next.getX();
    			this.y=next.getY();
    			
    			//controlo colision con bomberman.
    			if((next.getX()==MiNivel.getBomberman().getX())&&(next.getY()==MiNivel.getBomberman().getY())){
    				MiNivel.getBomberman().select(12);//afecto al bomberman
    				MiNivel.getBomberman().destruirme();
    			}
    		
    		}
    		select(dir+4);
    		
    	
    	
		
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
    	T.destruir();
    	select(8);
    	MiNivel.setPuntaje(15);
    	MiNivel.getCelda(x, y, constantes.ACTUAL).quitarPersonaje(this);
    }
}