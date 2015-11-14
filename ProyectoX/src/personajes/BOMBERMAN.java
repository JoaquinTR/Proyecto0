package personajes;

import GUI.constantes;
import bomba.BOMBA;
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
    
    private boolean Fatality;
    
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
        this.grafico = new jugadorGrafico(x,y);
        b=new bombermanThread(this);
        CantBombas=1;
        Fatality=false;
        Masacre=false;
        grafico.select(4);////
    }

    
    /**
     * Mueve el objeto grafico del bomberman.
     * @param dir direccion del movimiento.
     */
    public void mover(int dir){
    	
    	grafico.mover(dir,this.velocidad);
    	
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
    	BOMBA b=null;
    	if(CantBombas>=1){
    		decCantBombas();
    		b=new BOMBA(MiNivel,this.x,this.y);
    		MiNivel.getCelda(x, y, constantes.ACTUAL).setBomba(b);
    		
    	}
    	return b;
    }

    /**
     * Indica si el power up fatality esta activo.
     */
    public boolean isFatality(){
    	return Fatality;
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
     * Intercambia los estados de fatality.
     */
    public void setFatality() {
    	Masacre=!Masacre;
    }
    
    
    /**
     * Metodo de avanze del bomberman con sus controles de avance.
     * @param dir direccion del movimiento a efectura.
     */
    public void avanzarB(int dir){

    	CELDA actual = MiNivel.getCelda(x, y, -1);
    	CELDA next= MiNivel.getCelda(x, y, dir);
    		
    	boolean puedo=(next.getPared()==null)&(!next.hayBomba());

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
    	b.setDir(constantes.DESTRUCCION);
    	MiNivel.lock();
    	grafico.select(12);
    }
}

