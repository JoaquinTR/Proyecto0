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
        int j=1;
        int outer= 31;
        int outer2=13;

        
		
		
		//paredes indestructibles superiores e inferiores.
        for(i=0;i<outer;i++){
        	crearCeldaPI(i, 0, MiNivel,grilla);
        	gui.add(grilla[i][0].getGrafico());
        	
        	crearCeldaPI(i, 12, MiNivel,grilla);
        	gui.add(grilla[i][12].getGrafico());
        	
        }
        
        //paredes indestructibles laterales.
        for(i=1;i<outer2;i++){
        	crearCeldaPI(0, i, MiNivel,grilla);
        	gui.add(grilla[0][i].getGrafico());
        	
        	crearCeldaPI(30, i, MiNivel,grilla);
        	gui.add(grilla[30][i].getGrafico());
        }
        
        //creo paredes indestructibles centrales y celdas transitables.
        for(i=1;i<30;i++){
        	for(j=1;j<12;j++){
        		if((i%2==0)&&(j%2==0)){
        			crearCeldaPI(i, j, MiNivel,grilla);
        			gui.add(grilla[i][j].getGrafico());
        		}
        		else{
        			crearCelda(i, j, MiNivel,grilla);
        			gui.add(grilla[i][j].getGrafico());
        		}
        	
        	}	
        }
        
        //crear paredes destructibles
        
        
        MiNivel.getBomberman().select(4);
        gui.agregarObjeto(MiNivel.getBomberman().getGrafico());
		grilla[1][1].agregarPersonaje(MiNivel.getBomberman());
		
        //creo 3 rugulos aleatoriamente.
		Random Rx=new Random();
		Random Ry=new Random();
		int x= 4+ Rx.nextInt(26);
		int y= 4+ Ry.nextInt(8);
		
		for(int r=0;r<3;r++){
			
			x= 4+ Rx.nextInt(26);
			y= 4+ Ry.nextInt(8);
			
			//vuelvo a randomizar en caso de que quede en ambos x e y pares.
			while((x%2!=0)||(y%2!=0)){
				x= 4+ Rx.nextInt(25);
				y= 4+ Ry.nextInt(7);
			}
			crearRugulos(x,y,MiNivel,grilla,gui,Enemigos);
		}
        
        
    }

    /**
     * Crea un rugulo.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearRugulos(int x, int y, NIVEL MiNivel,CELDA[][] grilla,GUI gui, LinkedList<ENEMIGOS> Enemigos) {
    	
    	Enemigos.addLast(new RUGULOS(MiNivel,x,y));
		Enemigos.getLast().select(1);
		gui.agregarObjeto(Enemigos.getLast().getGrafico());
		
		grilla[x][y].agregarPersonaje(Enemigos.getLast());
    }

    /**
     * Crea un Altair.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearAltair(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
       
    }

    /**
     * Crea un Sirius.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearSirius(NIVEL MiNivel,CELDA[][] grilla) {
        
    }

    /**
     * Crea el bomberman.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearBomberman(NIVEL MiNivel,CELDA[][] grilla) {
        
    }

    /**
     * Crea un Speedup.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearSpeedup(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
        
    }

    /**
     * Crea un Fatality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearFatality(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
        
    }

    /**
     * Crea un Bombality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearBombality(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
        
    }

    /**
     * Crea un Masacrality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearMasacrality(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
        
    }

    /**
     * Crea una Celda transitable.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearCelda(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
    	grilla[x][y] = new CELDA(MiNivel,x,y);  
    }

    /**
     * Crea una celda con pared destructible.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearCeldaPD(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
    	grilla[x][y] = new CELDA(MiNivel,x,y);  
    	grilla[x][y].crearPared(true);
    }

    /**
     * Crea una celda con pared indestructible.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearCeldaPI(int x, int y, NIVEL MiNivel, CELDA[][] grilla) {
    	grilla[x][y] = new CELDA(MiNivel,x,y);  
    	grilla[x][y].crearPared(false);
    }

}