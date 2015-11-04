package nivel;

import java.util.*;

import GUI.GUI;
import mapa.CELDA;
import personajes.ENEMIGOS;
import personajes.RUGULOS;

/**
 * Clase que modela un creador para el nivel.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class CREADORNIVEL extends CREADOR{
	

    /**
     * 
     */
    public CREADORNIVEL() {
    }

    /**
     * @param grilla 
     * @param MiNivel
     */
    public void crearNivel(CELDA[][] grilla, NIVEL MiNivel,GUI gui, LinkedList<ENEMIGOS> Enemigos) {
        int i =0;
        int outer= 31;
        int outer2=13;

        
		MiNivel.getBomberman().select(4);
		gui.add(MiNivel.getBomberman().getGrafico());
        
		Enemigos.addLast(new RUGULOS(MiNivel,3,1));
		Enemigos.getLast().select(1);
		gui.add(Enemigos.getLast().getGrafico());
		
		//Enemigos[1] = new RUGULOS(MiNivel,1,5); 
		//Enemigos[1].select(1);
		//gui.add(Enemigos[1].getGrafico());
		
		
        for(i=0;i<outer;i++){
        	grilla[i][0] = new CELDA(MiNivel,i,0);  
        	grilla[i][0].crearPared(false);
        	grilla[i][0].select(5);
        	gui.add(grilla[i][0].getGrafico());
        	
        	grilla[i][12] = new CELDA(MiNivel,i,12);  
        	grilla[i][12].crearPared(false);
        	grilla[i][12].select(5);
        	gui.add(grilla[i][12].getGrafico());
        	
        }
        
        for(i=1;i<outer2;i++){
        	grilla[0][i] = new CELDA(MiNivel,0,i);
        	grilla[0][i].crearPared(false);
        	grilla[0][i].select(5);
        	gui.add(grilla[0][i].getGrafico());
        	
        	grilla[30][i] = new CELDA(MiNivel,30,i);
        	grilla[30][i].crearPared(false);
        	grilla[30][i].select(5);
        	gui.add(grilla[30][i].getGrafico());
        }
        int j=1;
        for(i=1;i<30;i++){
        	for(j=1;j<12;j++){
        		if((i%2==0)&&(j%2==0)){
        			grilla[i][j]=new CELDA(MiNivel,i,j);
        			grilla[i][j].crearPared(false);
        			grilla[i][j].select(6);
        			gui.add(grilla[i][j].getGrafico());
        		}
        		else{
        			grilla[i][j]=new CELDA(MiNivel,i,j);
        			grilla[i][j].select(0);
        			gui.add(grilla[i][j].getGrafico());
        		}
        	
        	}	
        }
        
        grilla[3][1].agregarPersonaje(Enemigos.getFirst());
        //grilla[1][5].agregarPersonaje(Enemigos[1]);
        grilla[1][1].agregarPersonaje(MiNivel.getBomberman());
        
        
    }

    /**
     * Crea un rugulo.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearRugulos(int x, int y, NIVEL MiNivel) {
        
    }

    /**
     * Crea un Altair.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearAltair(int x, int y, NIVEL MiNivel) {
       
    }

    /**
     * Crea un Sirius.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearSirius(NIVEL MiNivel) {
        
    }

    /**
     * Crea el bomberman.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearBomberman(NIVEL MiNivel) {
        
    }

    /**
     * Crea un Speedup.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearSpeedup(int x, int y, NIVEL MiNivel) {
        
    }

    /**
     * Crea un Fatality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearFatality(int x, int y, NIVEL MiNivel) {
        
    }

    /**
     * Crea un Bombality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearBombality(int x, int y, NIVEL MiNivel) {
        
    }

    /**
     * Crea un Masacrality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearMasacrality(int x, int y, NIVEL MiNivel) {
        
    }

    /**
     * Crea una Celda transitable.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearCelda(int x, int y, NIVEL MiNivel) {
        
    }

    /**
     * Crea una celda con pared destructible.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearCeldaPD(int x, int y, NIVEL MiNivel) {
       
    }

    /**
     * Crea una celda con pared indestructible.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearCeldaPI(int x, int y, NIVEL MiNivel) {
        
    }

}