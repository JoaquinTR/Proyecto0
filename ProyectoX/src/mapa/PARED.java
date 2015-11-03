package mapa;


/**
 * Clase que modela una pared destructible o indestructible.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class PARED {

	/**
	 * Mantiene si la pared es destructible o no.
	 */
	private boolean destructible;
	
    /**
     * Celda a la que pertenece esta pared.
     */
    private CELDA celda;

 


    /**
     * Crea una pared y le asigna su celda.
     * @param celda Celda a la que pertenece esta pared. 
     */
    public PARED(CELDA celda,boolean destructible) {
    	this.destructible=destructible;
        this.celda = celda;
    }
    
    /**
     * Indica si esta pared es destructible.
     * @return	True si es destructible, falso en caso contrario.
     */
    public boolean getDestructible(){
    	return destructible;
    }

}