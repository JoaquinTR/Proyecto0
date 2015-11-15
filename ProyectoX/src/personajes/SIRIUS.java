package personajes;

import java.util.Random;
import java.util.Stack;

import GUI.constantes;
import bomba.BOMBA;
import graficos.siriusGrafico;
import mapa.CELDA;
import nivel.NIVEL;

/**
 * Clase que modela la logica del SIRIUS.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class SIRIUS extends ENEMIGOS {

	/**
	 * variable Thread que controla la transicion del rugulo.
	 */
	private siriusThread T;

    /**
     * Movimientos restantes para atrapar al bomberman.
     */
    private Stack<Integer> Movimientos;


    /**
     * Bomberman del nivel. Obtiene el x e y para encontrarlo.
     */
    protected BOMBERMAN Bomberman;
    
    /**
     * direccion en la que se va a mover.
     */
    private int direccion;

    /**
     * constructor.
     * @param MiNivel nivel al que pertenece
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     */
    public SIRIUS(NIVEL MiNivel, int x, int y) {
        super(MiNivel,x,y,3);
        Bomberman = MiNivel.getBomberman();
        this.grafico=new siriusGrafico(x,y);
        //T=new enemigoThread(this);
        grafico.select(4);
    }
    
    /**
     * Inicia el hilo de este enemigo.
     */
    public void start(){
    	T=new siriusThread(this);
    }

    /**
     * Avance especifico de un sirius.
     */
    public void avanzar() {
        /*
    	Random rnd = new Random();
		
		//calculo la direccion en la que esta el bomberman.
        int dx= this.x - Bomberman.getX();
        int dy= this.y - Bomberman.getY();
        
        int dir1=0;
        int dir2=0;
        
        int dir=0;
        
        if( dx>0 ) dir1 = 2;
        if( dx<0 ) dir1 = 3;
        if( dy>0 ) dir2 = 0;
        if( dy<0 ) dir2 = 1;
	
        dir=rnd.nextInt(2);
        
        if(dir==0)
        	dir=dir1;
        else
        	dir=dir2;
        
		direccion=dir;
		
		System.out.println("direccion: "+direccion);
		
		CELDA next= MiNivel.getCelda(x, y, direccion);
	
		boolean puedo=(next.getPared()==null)&(!next.hayBomba());
		
	
		if(puedo){
			T.setDireccion(direccion);
			T.setCommand(-15);
			T.iniciar();
			//mover(direccion);
		
		}
		else{
			if(next.getPared()!=null){
				if(next.getPared().getDestructible()){
					ponerBomba();
					
					switch(direccion){
						case 0:
							direccion=1;
							break;
						case 1:
							direccion=0;
							break;
						case 2:
							direccion=3;
							break;
						case 3:
							direccion=2;
							break;
					}
					
					mover(direccion);
					
					retroceder(this.x,this.y);
				}
				else{
					//pared Indestructible.
				}
			}
		}
		grafico.select(dir+4);
        
		T.setCommand(-5);
		T.iniciar();*/
    	
    }
    
    /**
     * Escapar de una bomba recien puesta o encontrada en x e y.
     */
    protected void retroceder(int x, int y) {
        boolean encontre=false;
        
        CELDA next=null;
        
        int pasos=4;
        
        int direccionV=direccion;
        
        switch(direccion){
			case 0:
				direccion=1;
				break;
			case 1:
				direccion=0;
				break;
			case 2:
				direccion=3;
				break;
			case 3:
				direccion=2;
				break;
        }
	
		T.setDireccion(direccion);
		T.setCommand(-15);
		T.iniciar();
        
        while( (!encontre) & (pasos > 0 ) & (direccion==direccionV) ){
        	
        	next=MiNivel.getCelda(this.x, this.y, direccion);
        	
        	if(next.getPared()==null){
        		
    			T.setDireccion(direccion);
    			T.setCommand(-15);
    			T.iniciar();
        		
        		//esperar explosion.
        		T.setCommand(-10);
        		T.iniciar();
        		
        		encontre=true;
        	}
        	else{
        		pasos--;
        		direccion = ( direccion + 1 ) %4; // intento otra direccion.
        	}
        	
        }
    	
    }
    
    
    /**
     * pone una bomba en la posicion actual del bomberman.
     */
    private void ponerBomba() {
    	
    	BOMBA b=null;
    	if((!MiNivel.getCelda(x,y,constantes.ACTUAL).hayBomba()) ){
    		b=new BOMBA(MiNivel,this.x,this.y);
    		MiNivel.getCelda(x, y, constantes.ACTUAL).setBomba(b);
    		MiNivel.agregarObjeto(b.getGrafico());
    	}
    	
    	
    }
    
    /**
     * mueve el sirius.
     */
    protected void mover(int dir){
    	
    	CELDA actual = MiNivel.getCelda(x, y, -1);
		CELDA next= MiNivel.getCelda(x, y, direccion);
    	
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

    
    
    /**
     * Destruccion del sirius.
     */
    public void destruirme(){
    	
    	T.destruir();
    	grafico.select(8);
    	MiNivel.setPuntaje(50);    	
    	MiNivel.getCelda(x, y, constantes.ACTUAL).quitarPersonaje(this);
    	T.stop();// si no hago esto se me consume el cpu.
    	
    }

}