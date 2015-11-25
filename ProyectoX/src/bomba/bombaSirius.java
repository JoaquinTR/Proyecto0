package bomba;

import GUI.constantes;
import mapa.CELDA;
import nivel.NIVEL;

public class bombaSirius extends BOMBA{
	

    

    /**
     * constructor.
     *
     * @param x posicion x en la matriz.
     * @param y posicion y en la matriz. 
     * @param MiNivel nivel al que pertenece
     */
    public bombaSirius(NIVEL MiNivel,int x, int y ) {
    	super(MiNivel,x,y);
        grafico.select(2);
    }

    /**
     * Inicia el conteo de la explosion de esta bomba.
     */
    public void explotar() {
        grafico.select(1);
        MiNivel.getCelda(x, y, constantes.ACTUAL).quitarBomba();
        
        CELDA actual=null;
        CELDA abajo=null;
        CELDA arriba=null;
        CELDA izquierda=null;
        CELDA derecha=null;

        
        //obtiene las celdas adyacentes.
        actual=MiNivel.getCelda(x, y, constantes.ACTUAL);
        abajo=MiNivel.getCelda(x, y, constantes.ABAJO);
        arriba=MiNivel.getCelda(x, y, constantes.ARRIBA);
        izquierda=MiNivel.getCelda(x , y, constantes.IZQUIERDA);
        derecha=MiNivel.getCelda(x, y, constantes.DERECHA);
        
        
   		//afecto las celdas adyacentes.       
        actual.afectarS();
        abajo.afectarS();
        arriba.afectarS();
        izquierda.afectarS();
        derecha.afectarS();

        
        try {
			Thread.sleep(1600);
		} catch (InterruptedException e) {}
        
      //restauro las celdas adyacentes.       
        if(actual.getPared()==null)actual.restaurar();
        if(abajo.getPared()==null)abajo.restaurar();
        if(arriba.getPared()==null)arriba.restaurar();
        if(izquierda.getPared()==null)izquierda.restaurar();
        if(derecha.getPared()==null)derecha.restaurar();
     
        if(MiNivel.getPDR()==0)
        	MiNivel.ganar();
        
    }

    
}
