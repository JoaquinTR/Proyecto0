package personajes;

import java.io.IOException;
import java.util.Random;
import java.util.Stack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import GUI.constantes;
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
        this.grafico=new siriusGrafico(x,y,1);
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
     * Inicia el hilo de este enemigo.
     */
    public void stop(){
    	T.stop();
    	grafico.select(4);
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
        
        if( dx>0 ) dir1 = constantes.IZQUIERDA;
        if( dx<0 ) dir1 = constantes.DERECHA;
        if( dy>0 ) dir2 = constantes.ARRIBA;
        if( dy<0 ) dir2 = constantes.ABAJO;
	
        dir=rnd.nextInt(2);
        
        if(dir==0)
        	dir=dir1;
        else
        	dir=dir2;

        
		direccion=dir;
		
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
					
										
					int p=2;
					
					int aux=-1;
					
					while(p!=0){
						
						if(!movs.isEmpty()){
							
						aux=movs.pop();
						
						
						switch(aux){
							case constantes.ABAJO:
								mover(constantes.ARRIBA);
								movsA.push(constantes.ARRIBA);
								break;
							case constantes.ARRIBA:
								mover(constantes.ABAJO);
								movsA.push(constantes.ABAJO);
								break;
							case constantes.IZQUIERDA:
								mover(constantes.DERECHA);
								movsA.push(constantes.DERECHA);
								break;
							case constantes.DERECHA:
								mover(constantes.IZQUIERDA);
								movsA.push(constantes.IZQUIERDA);
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
						case constantes.ABAJO:
							mover(constantes.ARRIBA);
							movs.push(constantes.ARRIBA);
							break;
						case constantes.ARRIBA:
							mover(constantes.ABAJO);
							movs.push(constantes.ABAJO);
							break;
						case constantes.IZQUIERDA:
							mover(constantes.DERECHA);
							movs.push(constantes.DERECHA);
							break;
						case constantes.DERECHA:
							mover(constantes.IZQUIERDA);
							movs.push(constantes.IZQUIERDA);
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
					case constantes.ABAJO:
						movsA.push(constantes.ARRIBA);
						break;
					case constantes.ARRIBA:
						movsA.push(constantes.ABAJO);
						break;
					case constantes.IZQUIERDA:
						movsA.push(constantes.DERECHA);
						break;
					case constantes.DERECHA:
						movsA.push(constantes.IZQUIERDA);
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
    	
    	//sonido de la bomba.
        try {
	        AudioInputStream stream;
			stream = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/explosiones/bomb.wav"));
			Clip explosion = AudioSystem.getClip();
			explosion.open(stream);
			explosion.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {}
        
    	
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
    	MiNivel.quitarMalo(this);
    }

}