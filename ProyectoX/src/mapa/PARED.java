package mapa;


/**
 * Clase que modela una pared destructible o indestructible.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
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