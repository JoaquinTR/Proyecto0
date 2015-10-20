package powerups;

import nivel.NIVEL;

/**
 * 
 */
public abstract class POWERUP {

    protected int x;

    protected int y;

    protected NIVEL MiNivel;

    protected POWERUP(int x, int y,NIVEL MiNivel){
    	this.x=x;
    	this.y=y;
    	this.MiNivel=MiNivel;
    	
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
    public abstract void ejecutar();

}