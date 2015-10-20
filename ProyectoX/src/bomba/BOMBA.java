package bomba;


import nivel.NIVEL;

/**
 * 
 */
public class BOMBA {


    private int RadioExplosion;

    private int x;

    private int y;

    protected NIVEL MiNivel;


    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public BOMBA(int x, int y, NIVEL MiNivel) {
        this.x=x;
        this.y=y;
        this.MiNivel = MiNivel;
        this.RadioExplosion = 1;
    }

    /**
     * 
     */
    public void aumentarRadio() {
        this.RadioExplosion = 2;
    }

    /**
     * 
     */
    public void explotar() {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * 
     */
    public void resetRadio() {
       	this.RadioExplosion =1; 
    }

}