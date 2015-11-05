package personajes;

import GUI.constantes;
import bomba.BOMBA;
import graficos.jugadorGrafico;
import mapa.CELDA;
import nivel.NIVEL;

/**
 * Clase que modela la logica del bomberman.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
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
        super(MiNivel,x,y,3);
        this.grafico = new jugadorGrafico(x,y);
        b=new bombermanThread(this);
        //b.start(); no inicia la gui si esta aca

    }

    
    /**
     * Mueve el objeto grafico del bomberman.
     * @param dir direccion del movimiento.
     */
    public void mover(int dir){
    	
    	grafico.mover(dir);
    	
    }
    
    /**
     * inicia el thread del bomberman.
     */
    public void start(){
    	b.start();
    }

    /**
     * pone una bomba en la posicion actual del bomberman.
     */
    public BOMBA ponerBomba() {
    	BOMBA b=new BOMBA(MiNivel,this.x,this.y);
    	MiNivel.getCelda(x, y, constantes.ACTUAL).setBomba(b);
    	//b.start();
    	//b.explotar();
    	return b;
    }

    /**
     * Aumenta la velocidad del bomberman.
     */
    public void aumentarVelocidad() {
        velocidad*=2;
    }
    
    /**
     * Decrementa la velocidad del bomberman.
     */
    public void decrementarVelocidad(){
    	velocidad/=2;
    }

    /**
     * Aumenta la cantidad de bombas que se pueden poner al mismo tiempo.
     */
    public void aumentarCantBombas() {
        CantBombas++;
    }

    /**
     * Decrementa la cantidad de bmbas que se pueden poner.
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
    		
    	boolean puedo=next.getPared()==null;
    	
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
    			destruirme();
    		}
    		
    	}
    	else{
    		b.setDir(dir+4);
    		b.iniciar();


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
    	b.setDir(constantes.DESTRUCCION);
    	MiNivel.lock();
    	
    }
}

