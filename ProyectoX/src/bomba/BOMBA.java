package bomba;


import nivel.NIVEL;

/**
 * Clase que modela una bomba.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class BOMBA {

    /**
     * Cantidad de celdas adyacentes que afecta esta bomba.
     */
    private int RadioExplosion;
    
    /**
     * posicion x en la matriz de esta bomba.
     */
    private int x;

    /**
     * posicion y en la matriz de esta bomba.
     */
    private int y;

    protected NIVEL MiNivel;


    /**
     * constructor.
     *
     * @param x posicion x en la matriz.
     * @param y posicion y en la matriz. 
     * @param MiNivel nivel al que pertenece
     */
    public BOMBA(int x, int y, NIVEL MiNivel) {
        this.x=x;
        this.y=y;
        this.MiNivel = MiNivel;
        this.RadioExplosion = 1;
    }

    /**
     * Aumenta el radio de explosion de esta bomba.
     */
    public void aumentarRadio() {
        this.RadioExplosion += 1;
    }

    /**
     * Inicia el conteo de la explosion de esta bomba.
     */
    public void explotar() {
        
    }

    /**
     * Retorna la posicion x en la matriz de esta bomba.
     * @return posicion x de esta bomba.
     */
    public int getX() {
        return x;
    }

    /**
     * Retorna la posicion y en la matriz de esta bomba.
     * @return posicion y de esta bomba.
     */
    public int getY() {
        return y;
    }

    /**
     * Restaura el radio de explosion de esta bomba al original.
     */
    public void resetRadio() {
       	this.RadioExplosion =1; 
    }

}