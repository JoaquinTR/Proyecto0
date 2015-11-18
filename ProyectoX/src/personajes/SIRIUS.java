package personajes;

import java.util.Random;
import java.util.Stack;

import GUI.constantes;
import bomba.bombaBomberman;
import bomba.bombaSirius;
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
     * Bomberman del nivel. Obtiene el x e y para encontrarlo.
     */
    protected BOMBERMAN Bomberman;
    
    /**
     * direccion en la que se va a mover.
     */
    private int direccion;
    
    /**
     * ultimos 2 movimientos del sirius.
     */
    private Stack<Integer> movs;
    
    /**
     * ultimos 2 movimientos del sirius.
     */
    private Stack<Integer> movsA;

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
        grafico.select(4);
        movs=new Stack<Integer>();
        movsA=new Stack<Integer>();
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
        
    	Random rnd = new Random();
		
		//calculo la direccion en la que esta el bomberman.
        int dx= this.x - Bomberman.getX();
        int dy= this.y - Bomberman.getY();
        
        int dir1=0;
        int dir2=0;
        
        int dir=0;
        
        if( dx>0 ) dir1 = 2;
        if( dx<0 ) dir1 = 3;
        if( dy>0 ) dir2 = 1;
        if( dy<0 ) dir2 = 0;
	
        dir=rnd.nextInt(2);
        
        if(dir==0)
        	dir=dir1;
        else
        	dir=dir2;
        
        if(dx==0)
        	dir=dir2;
        if(dy==0)
        	dir=dir1;
		direccion=dir;
		
		System.out.println("direccion PPAL: "+direccion);
		
		CELDA next= MiNivel.getCelda(x, y, direccion);
	
		boolean puedo=(next.getPared()==null)&(!next.hayBomba());
		
	
		if(puedo){
			mover(direccion);
			movs.push(direccion);
		
		}
		else{
			if(next.getPared()!=null){
				if(next.getPared().getDestructible()){
					
					ponerBomba();
					
					/*
					int dirA=0;
					
					switch(direccion){
						case 0:
							dirA=1;
							break;
						case 1:
							dirA=0;
							break;
						case 2:
							dirA=3;
							break;
						case 3:
							dirA=2;
							break;
					}
					
					mover(dirA);
					
					movs.push(direccion);
					
					
					retroceder();
					
					*/
					
					int p=2;
					int aux=-1;
					while(p!=0){
						
						if(!movs.isEmpty()){
							
						aux=movs.pop();
						
						
						switch(aux){
							case 0:
								mover(1);
								movsA.push(1);
								break;
							case 1:
								mover(0);
								movsA.push(0);
								break;
							case 2:
								mover(3);
								movsA.push(3);
								break;
							case 3:
								mover(2);
								movsA.push(2);
								break;
							}
						
						}
						else
							retroceder(aux);
						
						p--;
					}
					
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {}
					
					//vuelvo donde estaba la bomba.
					while(!movsA.isEmpty()){
						
						int aux2=movsA.pop();
						
						switch(aux2){
						case 0:
							mover(1);
							movs.push(1);
							break;
						case 1:
							mover(0);
							movs.push(0);
							break;
						case 2:
							mover(3);
							movs.push(3);
							break;
						case 3:
							mover(2);
							movs.push(2);
							break;
						}
						
					}
					
				}
				else{
					//pared Indestructible.
				}
			}
		}
    	
    }
    
    /**
     * Escapar de una bomba recien puesta o encontrada en x e y.
     */
    protected void retroceder(int d) {
        boolean encontre=false;
        
        CELDA next=null;
 
        int dir = ( d + 1 ) % 4;
        
        while( (!encontre)  ){
        	
        	next=MiNivel.getCelda(this.x, this.y, dir);
        	
        	if((next.getPared()==null) & (dir!=d)){
        		
        		//muevo en la direccion encontrada.
        		mover(dir);
        		
        		//apilo la direccion contraria para moverme.
        		switch(dir){
					case 0:
						movsA.push(1);
						break;
					case 1:
						movsA.push(0);
						break;
					case 2:
						movsA.push(3);
						break;
					case 3:
						movsA.push(2);
						break;
        		}
        		
        		encontre=true;
        	}
        	else{
        		dir = ( dir + 1 ) %4; // intento otra direccion.
        	}
        	
        }
    	
    }
    
    
    /**
     * pone una bomba en la posicion actual del bomberman.
     */
    private void ponerBomba() {
    	
    	bombaSirius b=new bombaSirius(MiNivel,this.x,this.y);
    	MiNivel.getCelda(x, y, constantes.ACTUAL).setBomba(b);
    	MiNivel.agregarObjeto(b.getGrafico());
    	
    }
    
    /**
     * mueve el sirius.
     */
    protected void mover(int dir){
    	
    	CELDA actual = MiNivel.getCelda(x, y, -1);
		CELDA next= MiNivel.getCelda(x, y, dir);
    	
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
			T.detener();
			T.stop();
		}
    }

    
    
    /**
     * Destruccion del sirius.
     */
    @SuppressWarnings("deprecation")
	public void destruirme(){
    	
    	T.destruir();
    	grafico.select(8);
    	MiNivel.setPuntaje(50);    	
    	MiNivel.getCelda(x, y, constantes.ACTUAL).quitarPersonaje(this);
    	T.stop();// si no hago esto se me consume el cpu.
    	
    }

}