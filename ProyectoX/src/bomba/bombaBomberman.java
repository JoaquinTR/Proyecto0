package bomba;


import java.util.LinkedList;

import GUI.constantes;
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
public class bombaBomberman extends BOMBA{

    /**
     * constructor.
     *
     * @param x posicion x en la matriz.
     * @param y posicion y en la matriz. 
     * @param MiNivel nivel al que pertenece
     */
    public bombaBomberman(NIVEL MiNivel,int x, int y ) {
    	super(MiNivel,x,y);
    	
        switch(MiNivel.getSJ()){
        case 0:
        	grafico.select(0);
        	break;
        case 1: case 2:
        	grafico.select(3);
        	break;
        case 3:
        	grafico.select(4);
        	break;
        }
        
        this.RadioExplosion=MiNivel.getBomberman().getRadioBombas();
        
    }

   

    /**
     * Inicia el conteo de la explosion de esta bomba.
     */
    public void explotar() {
    	MiNivel.getBomberman().aumentarCantBombas();
        grafico.select(1);
        MiNivel.getCelda(x, y, constantes.ACTUAL).quitarBomba();
        
        int radio = RadioExplosion;
        
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
        	MiNivel.setPuntaje(C.afectar());
        }
        
        try {
			Thread.sleep(1600);
		} catch (InterruptedException e) {}
        
        for(CELDA C: celdasAfectadas){
        	if(C.getPared()==null)
            	C.restaurar();
        }
        	
        if(MiNivel.getPDR()==0)
        	MiNivel.ganar();
    }
    
   

}