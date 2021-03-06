package personajes;

import GUI.constantes;
import bomba.bombaBomberman;
import graficos.jugadorGrafico;
import mapa.CELDA;
import nivel.NIVEL;

/**
 * Clase que modela la logica del bomberman.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
 */
public class BOMBERMAN extends PERSONAJE {

	
    /**
     * indica si se agarro el power-up "masacrality".
     */
    private boolean Masacre;

    /**
     *  cantidad de bombas que se pueden poner, 
     *  cada vez que se pone una bomba se decrementa, 
     *  no se pueden poner bombas cuando es 0.
     */
    private int CantBombas;
    
    private int radioBombas;
    
    /**
     * Thread del bomberman.
     */
    private bombermanThread b;	
    


    /**
     * constructor.
     * @param MiNivel nivel al que pertenece
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     */
    public BOMBERMAN(NIVEL MiNivel, int x, int y) {
        super(MiNivel,x,y,2);
        this.grafico = new jugadorGrafico(x,y, MiNivel.getSJ());
        b=new bombermanThread(this);
        CantBombas=1;
        radioBombas=1;
        Masacre=false;
        grafico.select(4);
        b.start();
    }

    
    /**
     * Mueve el objeto grafico del bomberman.
     * @param dir direccion del movimiento.
     */
    public void mover(int dir){
    	
    	grafico.mover(dir,this.velocidad);
    	
    }

    /**
     * pone una bomba en la posicion actual del bomberman.
     */
    public bombaBomberman ponerBomba() {
    	
    	bombaBomberman b=null;
    	if( ( (CantBombas > 0) | ( Masacre ) ) & (!MiNivel.getCelda(x,y,constantes.ACTUAL).hayBomba()) ){//cant bombas se va a negativo en masacre.
    		decCantBombas();
    		b=new bombaBomberman(MiNivel,this.x,this.y);
    		MiNivel.getCelda(x, y, constantes.ACTUAL).setBomba(b);
    		
    	}
    	return b;
    }

    /**
     * Aumenta el radio de explosion de las bombas.
     */
    public void aumentarRadioBombas(){
    	MiNivel.aumentarFatality();
    	radioBombas++;
    }
    
    /**
     * Obtiene el radio de explosion de las bombas.
     * @return Radio de explosion.
     */
    public int getRadioBombas(){
    	return radioBombas;
    }
    
    /**
     * Indica si el power up masacre esta activo.
     */
    public boolean isMasacre(){
    	return Masacre;
    }
    
    /**
     * Aumenta la velocidad del bomberman.
     */
    public void aumentarVelocidad() {
        MiNivel.aumentarSpeedup();
    	velocidad++;
    }

    /**
     * Aumenta la cantidad de bombas que se pueden poner al mismo tiempo.
     */
    public void aumentarCantBombas() {
        CantBombas++;
    }

    /**
     * Decrementa la cantidad de bombas que se pueden poner.
     */
    public void decCantBombas(){
    	CantBombas--;
    }
    
    /**
     * Intercambia los estados de masacre.
     */
    public void setMasacre() {
    	Masacre=!Masacre;
    }
    
    
    
    /**
     * Metodo de avanze del bomberman con sus controles de avance.
     * @param dir direccion del movimiento a efectura.
     */
    public void avanzarB(int dir){

    	CELDA actual = MiNivel.getCelda(x, y, -1);
    	CELDA next= MiNivel.getCelda(x, y, dir);
    		
    	boolean puedo=(next.getPared()==null);
    	puedo= (puedo | Masacre ) & (!next.hayBomba());
    	if(next.getPared()!=null)
    		puedo=puedo & next.getPared().getDestructible();
    	
    	if(puedo){
    		b.setDir(dir);
    		boolean hay=false;
    		hay=next.hayAlguien();

    		
    		actual.quitarPersonaje(this);
    		next.agregarPersonaje(this);
    		this.x=next.getX();
    		this.y=next.getY();

    		b.iniciar();
    		
    		if(hay){
    			b.setDir(constantes.DESTRUCCION);
    			b.iniciar();
    		}
    		if((next.getPowerup()!=null) &(next.getPared()==null)){
    			next.getPowerup().ejecutar();
    			next.quitarPowerup();
    		}
    	}
    	else{
    		grafico.select(dir+4);
    		unlock();
    	}
    	
    	

    }
    
    /**
     * destraba el teclado.
     */
    public void unlock(){
    	MiNivel.unlock();
    }
    
    /**
     * destruye el bomberman y traba el teclado. GAME OVER.
     */
    public void destruirme(){
    	if(!Masacre){
    		b.setDir(constantes.DESTRUCCION);
    		MiNivel.lock();
    		grafico.select(12);
    		MiNivel.perder();
    	}
    }


	public void stop() {
		b.detener();
	}
}

