package personajes;

import nivel.NIVEL;

/**
 * Clase que modela la logica de un altair.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class ALTAIR extends ENEMIGOS {

    /**
     * constructor.
     * @param MiNivel nivel al que pertenece
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     */
    public ALTAIR(NIVEL MiNivel, int x, int y) {
        super(MiNivel,x,y,1);
    }

    /**
     * avanzar propio del altair.
     */
    public void avanzar() {
    }
    
    /**
     * destruccion del altair.
     */
    public void destruirme(){
    	
    }

}