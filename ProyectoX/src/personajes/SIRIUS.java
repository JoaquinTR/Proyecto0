package personajes;

import java.util.Stack;

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
     * Movimientos restantes para atrapar al bomberman.
     */
    private Stack<Integer> Movimientos;


    /**
     * Bomberman del nivel. Obtiene el x e y para encontrarlo.
     */
    protected BOMBERMAN Bomberman;

    /**
     * constructor.
     * @param MiNivel nivel al que pertenece
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     */
    public SIRIUS(NIVEL MiNivel, int x, int y) {
        super(MiNivel,x,y,3);
    }

    /**
     * Avance especifico de un sirius.
     */
    public void avanzar() {
        
    }

    /**
     * Poner una bomba generica.
     */
    private void PonerBomba() {
        
    }

    /**
     * Escapar de una bomba recien puesta o encontrada.
     */
    private void Retroceder() {
        
    }

    /**
     * Rastrear al bomberman (rellena la pila de movimientos).
     */
    private void Rastrear() {
        
    }
    
    /**
     * Destruccion del sirius.
     */
    public void destruirme(){
    	MiNivel.setPuntaje(50);
    }

}