package personajes;

import nivel.NIVEL;

/**
 * Clase abstracta que modela un enemigo.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public abstract class ENEMIGOS extends PERSONAJE {

    /**
     * constructor.
     * @param MiNivel nivel al que pertenece
     * @param x posicion x en la matriz
     * @param y posicion y en la matriz.
     * @param vel velocidad del enemigo.
     */
    protected ENEMIGOS(NIVEL MiNivel, int x, int y, float vel) {
        super(MiNivel,x,y,vel);
    }

    /**
     * avance a implementar en las sublclases implementadoras.
     */
    public abstract void avanzar();

}