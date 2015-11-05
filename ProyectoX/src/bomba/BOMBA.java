package bomba;


import javax.swing.JLabel;

import GUI.constantes;
import graficos.BombaGrafica;
import graficos.Grafico;
import mapa.CELDA;
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
public class BOMBA{

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


    /**
     * constructor.
     *
     * @param x posicion x en la matriz.
     * @param y posicion y en la matriz. 
     * @param MiNivel nivel al que pertenece
     */
    public BOMBA(NIVEL MiNivel,int x, int y ) {
        this.x=x;
        this.y=y;
        this.MiNivel = MiNivel;
        this.RadioExplosion = 1;
        grafico = new BombaGrafica(x,y);
        grafico.select(0);
        
        T= new bombaThread(this);
        T.start();
        T.iniciar();
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
    	MiNivel.getBomberman().aumentarCantBombas();
        grafico.select(1);
        MiNivel.getCelda(x, y, constantes.ACTUAL).quitarBomba();
        
        CELDA actual=MiNivel.getCelda(x, y, constantes.ACTUAL);
        CELDA abajo=MiNivel.getCelda(x, y, constantes.ABAJO);
        CELDA arriba=MiNivel.getCelda(x, y, constantes.ARRIBA);
        CELDA izquierda=MiNivel.getCelda(x, y, constantes.IZQUIERDA);
        CELDA derecha=MiNivel.getCelda(x, y, constantes.DERECHA);
        
        
   		actual.afectar();        
        abajo.afectar();
        arriba.afectar();
        izquierda.afectar();
        derecha.afectar();
        
        try {
			T.sleep(1000);
		} catch (InterruptedException e) {}
        
        actual.select(0);
        arriba.select(0);
        abajo.select(0);
        izquierda.select(0);
        derecha.select(0);
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

}