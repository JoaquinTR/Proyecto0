package bomba;


import java.util.LinkedList;

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
        
        int radio = MiNivel.getBomberman().getRadioBombas();
        
        int offset = 0;
        
        LinkedList<CELDA> celdasAfectadas=new LinkedList<CELDA>();
        
        boolean stopab=false;
        boolean stopar=false;
        boolean stopi=false;
        boolean stopd=false;
        
        CELDA actual=null;
        CELDA abajo=null;
        CELDA arriba=null;
        CELDA izquierda=null;
        CELDA derecha=null;
        
        actual=MiNivel.getCelda(x, y, constantes.ACTUAL);
        
        celdasAfectadas.addLast(actual);
        
        do{
        	
        
        //si no indicaron que frene de pedir una direccion pido las celdas.
        //el pedido retorna null si se va del mapa.
        if(!stopab)abajo=MiNivel.getCelda(x, y + offset, constantes.ABAJO);
        if(!stopar)arriba=MiNivel.getCelda(x, y - offset, constantes.ARRIBA);
        if(!stopi)izquierda=MiNivel.getCelda(x - offset, y, constantes.IZQUIERDA);
        if(!stopd)derecha=MiNivel.getCelda(x+ offset, y, constantes.DERECHA);
        
        
   		//si me fui del mapa indico que pare de pedir esas celdas ("stopx" flags).         
        if(abajo!=null) celdasAfectadas.addLast(abajo); else stopab=true;
        if(arriba!=null) celdasAfectadas.addLast(arriba); else stopar=true;
        if(izquierda!=null) celdasAfectadas.addLast(izquierda); else stopi=true;
        if(derecha!=null) celdasAfectadas.addLast(derecha); else stopd=true;
        
        //si me encuentro con una pared pongo en verdadero el flag correspondiente.
        if(abajo.getPared()!=null) stopab=true;
        if(arriba.getPared()!=null)  stopar=true;
        if(izquierda.getPared()!=null)  stopi=true;
        if(derecha.getPared()!=null) stopd=true;
        
        radio--;
        
        offset++;
        }while(radio!=0);
        
        for(CELDA C: celdasAfectadas){
        	C.afectar();
        }
        
        try {
			T.sleep(1600);
		} catch (InterruptedException e) {}
        
        for(CELDA C: celdasAfectadas){
        	if(C.getPared()==null)
            	C.restaurar();
        }
        	
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