package bomba;

import javax.swing.JLabel;

import graficos.BombaGrafica;
import graficos.Grafico;
import nivel.NIVEL;

public abstract class BOMBA {
	 /**
     * Cantidad de celdas adyacentes que afecta esta bomba.
     */
    protected int RadioExplosion;
    
    /**
     * posicion x en la matriz de esta bomba.
     */
    protected int x;

    /**
     * posicion y en la matriz de esta bomba.
     */
    protected int y;
    
    /**
     * Grafico (JLabel) al que esta relacionado esta bomba.
     */
    protected Grafico grafico;

    /**
     * Nivel de la bomba.
     */
    protected NIVEL MiNivel;
    
    /**
     * Thread de ejecucion de la bomba.
     */
    protected bombaThread T;

    protected BOMBA(NIVEL MiNivel,int x, int y){
    	this.x=x;
        this.y=y;
        this.MiNivel = MiNivel;
        this.RadioExplosion = 1;
        grafico = new BombaGrafica(x,y);
        T= new bombaThread(this);
        T.start();
    	
    }
    
    /**
     * Aumenta el radio de explosion de esta bomba.
     */
    public void aumentarRadio() {
        this.RadioExplosion += 1;
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
    
    /**
     * retorna el objeto grafico de esta bomba.
     * @return el grafico de esta bomba.
     */
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
    
    /**
     * Inicia el conteo de la explosion de esta bomba.
     */
    public abstract void explotar();
}
