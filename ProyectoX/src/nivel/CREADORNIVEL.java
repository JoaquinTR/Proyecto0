package nivel;

import java.util.*;

import GUI.GUI;
import mapa.CELDA;
import personajes.ENEMIGOS;
import personajes.RUGULOS;
import powerups.BOMBALITY;
import powerups.FATALITY;
import powerups.MASACRALITY;
import powerups.SPEEDUP;

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
        Random px=new Random();
        Random py=new Random();
        
        int x=0;
		int y=0;
		
        for(i=0;i<=110;i++){
        	x= 1+ px.nextInt(29);
			y= 1+ py.nextInt(11);
        	while( ((x==1)&(y==1)) | ((x==2)&(y==1)) | ((x==1)&(y==2)) | (grilla[x][y].getPared()!=null)){
				x= 1+ px.nextInt(29);
				y= 1+ py.nextInt(11);
			}
        	crearCeldaPD(x,y,MiNivel,grilla);
        }
        
        //creo bomberman
        crearBomberman(MiNivel,grilla,gui);
		
        //creo 3 rugulos aleatoriamente. se puede hacer todo dentro de crearRugulos. idem para los otros.

		for(int r=0;r<3;r++){
			
			x= 3+ px.nextInt(27);
			y= 3+ py.nextInt(9);
			
			//vuelvo a randomizar en caso de que quede en ambos x e y pares.
			while( ((x==1)&(y==1)) | ((x==2)&(y==1)) | ((x==1)&(y==2)) | (grilla[x][y].getPared()!=null) ){
				x= 3+ px.nextInt(27);
				y= 3+ py.nextInt(9);
			}
			crearRugulos(x,y,MiNivel,grilla,gui,Enemigos);
		}
		
		
		// ---CREACION POWER-UPS---
		
		//---SPEEDUP---
		for(int r=0;r<4;r++){
			
			x= 3+ px.nextInt(27);
			y= 3+ py.nextInt(9);
			boolean is=false;
			//rerandomizado.
			
				while( ((x==1)&(y==1)) | ((x==2)&(y==1)) | ((x==1)&(y==2)) | (!is) ){
					x= 3+ px.nextInt(27);
					y= 3+ py.nextInt(9);
					if(grilla[x][y].getPared()!=null)
						if( (grilla[x][y].getPared().getDestructible()) & (grilla[x][y].getPowerup()==null) )
							is=true;
				}
			crearSpeedup(x,y,MiNivel,grilla,gui);
	        
		}
		
		//---FATALITY---
		for(int r=0;r<3;r++){
					
			x= 3+ px.nextInt(27);
			y= 3+ py.nextInt(9);
			boolean is=false;
			//rerandomizado.
					
			while( ((x==1)&(y==1)) | ((x==2)&(y==1)) | ((x==1)&(y==2)) | (!is) ){
				x= 3+ px.nextInt(27);
				y= 3+ py.nextInt(9);
				if(grilla[x][y].getPared()!=null)
					if( (grilla[x][y].getPared().getDestructible()) & (grilla[x][y].getPowerup()==null) )
						is=true;
			}
			crearFatality(x,y,MiNivel,grilla,gui);
			        
		}
		
		//---BOMBALITY---
		for(int r=0;r<3;r++){
							
			x= 3+ px.nextInt(27);
			y= 3+ py.nextInt(9);
			boolean is=false;
			//rerandomizado.
							
			while( ((x==1)&(y==1)) | ((x==2)&(y==1)) | ((x==1)&(y==2)) | (!is) ){
				x= 3+ px.nextInt(27);
				y= 3+ py.nextInt(9);
				if(grilla[x][y].getPared()!=null)
					if( (grilla[x][y].getPared().getDestructible()) & (grilla[x][y].getPowerup()==null) )
						is=true;
			}
			crearBombality(x,y,MiNivel,grilla,gui);
					        
		}
		
		//---MASACRALITY---

									
		x= 3+ px.nextInt(27);
		y= 3+ py.nextInt(9);
		boolean is=false;
		//rerandomizado.
									
		while( ((x==1)&(y==1)) | ((x==2)&(y==1)) | ((x==1)&(y==2)) | (!is) ){
			x= 3+ px.nextInt(27);
			y= 3+ py.nextInt(9);
			if(grilla[x][y].getPared()!=null)
				if( (grilla[x][y].getPared().getDestructible()) & (grilla[x][y].getPowerup()==null) )
					is=true;
		}
		crearMasacrality(x,y,MiNivel,grilla,gui);
							        
				
		
		
    }
    
    
    
    

    /**
     * Crea un rugulo.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearRugulos(int x, int y, NIVEL MiNivel,CELDA[][] grilla,GUI gui, LinkedList<ENEMIGOS> Enemigos) {
    	
    	Enemigos.addLast(new RUGULOS(MiNivel,x,y));
		gui.agregarObjeto(Enemigos.getLast().getGrafico());
		
		grilla[x][y].agregarPersonaje(Enemigos.getLast());
    }

    /**
     * Crea un Altair.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearAltair(int x, int y, NIVEL MiNivel,CELDA[][] grilla,GUI gui) {
       
    }

    /**
     * Crea un Sirius.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearSirius(NIVEL MiNivel,CELDA[][] grilla,GUI gui) {
        
    }

    /**
     * Crea el bomberman.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearBomberman(NIVEL MiNivel,CELDA[][] grilla,GUI gui) {
    	gui.agregarObjeto(MiNivel.getBomberman().getGrafico());
		grilla[1][1].agregarPersonaje(MiNivel.getBomberman());
    }

    /**
     * Crea un Speedup.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearSpeedup(int x, int y, NIVEL MiNivel,CELDA[][] grilla,GUI gui) {
    	SPEEDUP pu=new SPEEDUP(x,y,MiNivel);
        grilla[x][y].setPowerup(pu);
        gui.agregarObjeto(pu.getGrafico());
        pu.getGrafico().setVisible(false);
    }

    /**
     * Crea un Fatality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearFatality(int x, int y, NIVEL MiNivel,CELDA[][] grilla,GUI gui) {
    	FATALITY pu=new FATALITY(x,y,MiNivel);
        grilla[x][y].setPowerup(pu);
        gui.agregarObjeto(pu.getGrafico());
        pu.getGrafico().setVisible(false);
    }

    /**
     * Crea un Bombality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearBombality(int x, int y, NIVEL MiNivel,CELDA[][] grilla,GUI gui) {
    	BOMBALITY pu=new BOMBALITY(x,y,MiNivel);
        grilla[x][y].setPowerup(pu);
        gui.agregarObjeto(pu.getGrafico());
        pu.getGrafico().setVisible(false);
    }

    /**
     * Crea un Masacrality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearMasacrality(int x, int y, NIVEL MiNivel,CELDA[][] grilla,GUI gui) {
    	MASACRALITY pu=new MASACRALITY(x,y,MiNivel);
        grilla[x][y].setPowerup(pu);
        gui.agregarObjeto(pu.getGrafico());
        pu.getGrafico().setVisible(false); 
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