package mapa;


/**
 * 
 */
public class PARED {

	boolean destructible;
	
    /**
     * 
     */
    private CELDA celda;

 


    /**
     * @param celda 
     */
    public PARED(CELDA celda,boolean destructible) {
    	this.destructible=destructible;
        this.celda = celda;
    }
    
    public boolean getDestructible(){
    	return destructible;
    }

}