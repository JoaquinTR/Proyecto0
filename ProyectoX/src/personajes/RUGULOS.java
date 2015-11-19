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
	private enemigoThread T;

    /**
     * constructor.
     * @param MiNivel nivel al que pertenece
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     */
    public RUGULOS(NIVEL MiNivel, int x, int y) {
        super(MiNivel,x,y,1);
        this.grafico = new ruguloGrafico(x,y, MiNivel.getSR());
        //T=new enemigoThread(this);
        grafico.select(4);
    }
    
    /**
     * Inicia el hilo de este enemigo.
     */
    public void start(){
    	T=new enemigoThread(this);
    }
    
    /**
     * Inicia el hilo de este enemigo.
     */
    public void stop(){
    	T.interrupt();
    	T.detener();
    	T.stop();
    	grafico.select(4);
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
    			
    			
    			
    			//avanzo de celda el personaje a nivel logica.
    			actual.quitarPersonaje(this);
    			next.agregarPersonaje(this);
    			this.x=next.getX();
    			this.y=next.getY();
    			
    			//avanzo de celda el personaje a nivel grafica.
    			this.grafico.mover(dir,this.velocidad);
    			
    			//controlo colision con bomberman.
    			boolean agarre=(next.getX()==MiNivel.getBomberman().getX())&&(next.getY()==MiNivel.getBomberman().getY());
    			if(agarre){
    				//afecto al bomberman
    				MiNivel.getBomberman().destruirme();
    			}
    		
    		}
    		grafico.select(dir+4);
    		
    	
    	
		
    }
    
    
    /**
     * metodo de destruccion de los Rugulos.
     */
    @SuppressWarnings("deprecation")
	public void destruirme(){
    	T.destruir();
    	grafico.select(8);
    	MiNivel.setPuntaje(15);
    	MiNivel.getCelda(x, y, constantes.ACTUAL).quitarPersonaje(this);
    	T.stop();// si no hago esto se me consume el cpu.
    	MiNivel.quitarMalo(this);
    }
}