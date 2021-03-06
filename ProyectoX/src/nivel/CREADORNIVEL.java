package nivel;

import java.util.*;
import mapa.CELDA;
import personajes.ALTAIR;
import personajes.ENEMIGOS;
import personajes.RUGULOS;
import personajes.SIRIUS;
import powerups.BOMBALITY;
import powerups.FATALITY;
import powerups.MASACRALITY;
import powerups.SPEEDUP;

/**
 * Clase que modela un creador para el nivel.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
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
    public void crearNivel(CELDA[][] grilla, NIVEL MiNivel, LinkedList<ENEMIGOS> Enemigos) {
        int i =0;
        int j=1;
        int outer= 31;
        int outer2=13;

        
		
		
		//paredes indestructibles superiores e inferiores.
        for(i=0;i<outer;i++){
        	crearCeldaPI(i, 0, MiNivel,grilla);
        	MiNivel.agregarObjeto(grilla[i][0].getGrafico());
        	
        	crearCeldaPI(i, 12, MiNivel,grilla);
        	MiNivel.agregarObjeto(grilla[i][12].getGrafico());
        	
        }
        
        //paredes indestructibles laterales.
        for(i=1;i<outer2;i++){
        	crearCeldaPI(0, i, MiNivel,grilla);
        	MiNivel.agregarObjeto(grilla[0][i].getGrafico());
        	
        	crearCeldaPI(30, i, MiNivel,grilla);
        	MiNivel.agregarObjeto(grilla[30][i].getGrafico());
        }
        
        //creo paredes indestructibles centrales y celdas transitables.
        for(i=1;i<30;i++){
        	for(j=1;j<12;j++){
        		if((i%2==0)&&(j%2==0)){
        			crearCeldaPI(i, j, MiNivel,grilla);
        			MiNivel.agregarObjeto(grilla[i][j].getGrafico());
        		}
        		else{
        			crearCelda(i, j, MiNivel,grilla);
        			MiNivel.agregarObjeto(grilla[i][j].getGrafico());
        		}
        	
        	}	
        }
        
        //crear paredes destructibles
        Random px=new Random();
        Random py=new Random();
        
        int x=0;
		int y=0;
		
        for(i=0;i<127;i++){
        	x= 1+ px.nextInt(29);
			y= 1+ py.nextInt(11);
        	while( ((x==28)&(y==11)) | ((x==29)&(y==11)) | ((x==29)&(y==10)) | ((x==1)&(y==1)) | ((x==2)&(y==1)) | ((x==1)&(y==2)) | (grilla[x][y].getPared()!=null)){
				x= 1+ px.nextInt(29);
				y= 1+ py.nextInt(11);
			}
        	crearCeldaPD(x,y,MiNivel,grilla);
        }
        //creo bomberman.
        crearBomberman(MiNivel,grilla);
        
        //creo el sirius.
        crearSirius(MiNivel,grilla,Enemigos);
		
        //creo 3 rugulos aleatoriamente. se puede hacer todo dentro de crearRugulos. idem para los otros.
		for(int r=0;r<3;r++){
			
			x= 3+ px.nextInt(27);
			y= 3+ py.nextInt(9);
			
			//vuelvo a randomizar en caso de que quede en ambos x e y pares.
			while( ((x==1)&(y==1)) | ((x==2)&(y==1)) | ((x==1)&(y==2)) | (grilla[x][y].getPared()!=null) ){
				x= 3+ px.nextInt(27);
				y= 3+ py.nextInt(9);
			}
			crearRugulos(x,y,MiNivel,grilla,Enemigos);
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
			crearSpeedup(x,y,MiNivel,grilla);
	        
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
			crearFatality(x,y,MiNivel,grilla);
			        
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
			crearBombality(x,y,MiNivel,grilla);
					        
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
		crearMasacrality(x,y,MiNivel,grilla);
							        
		 //creo 2 altair aleatoriamente. se puede hacer todo dentro de crearAltair.
		for(int r=0;r<2;r++){
			
			is=false;
					
			x= 3+ px.nextInt(27);
			y= 3+ py.nextInt(9);
			
			//vuelvo a randomizar en caso de que quede en ambos x e y pares.
			while( ((x==1)&(y==1)) | ((x==2)&(y==1)) | ((x==1)&(y==2)) | (!is) ){
				x= 3+ px.nextInt(27);
				y= 3+ py.nextInt(9);
				if(grilla[x][y].getPared()!=null)
					if( (grilla[x][y].getPared().getDestructible())  )
						is=true;
			}
			crearAltair(x,y,MiNivel,grilla,Enemigos);
		}
		
		
    }
    
    
    /**
     * Crea un rugulo.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearRugulos(int x, int y, NIVEL MiNivel,CELDA[][] grilla, LinkedList<ENEMIGOS> Enemigos) {
    	
    	Enemigos.addLast(new RUGULOS(MiNivel,x,y));
		MiNivel.agregarObjeto(Enemigos.getLast().getGrafico());
		
		grilla[x][y].agregarPersonaje(Enemigos.getLast());
		
    }

    /**
     * Crea un Altair.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearAltair(int x, int y, NIVEL MiNivel,CELDA[][] grilla,LinkedList<ENEMIGOS> Enemigos) {
       
    	Enemigos.addLast(new ALTAIR(MiNivel,x,y));
		MiNivel.agregarObjeto(Enemigos.getLast().getGrafico());
		
		grilla[x][y].agregarPersonaje(Enemigos.getLast());
    	
    }

    /**
     * Crea un Sirius.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearSirius(NIVEL MiNivel,CELDA[][] grilla,LinkedList<ENEMIGOS> Enemigos) {
    	
    	Enemigos.addLast(new SIRIUS(MiNivel,29,11));
		MiNivel.agregarObjeto(Enemigos.getLast().getGrafico());
		
		grilla[29][11].agregarPersonaje(Enemigos.getLast());
    }

    /**
     * Crea el bomberman.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearBomberman(NIVEL MiNivel,CELDA[][] grilla) {
    	MiNivel.agregarObjeto(MiNivel.getBomberman().getGrafico());
		grilla[1][1].agregarPersonaje(MiNivel.getBomberman());
    }

    /**
     * Crea un Speedup.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearSpeedup(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
    	SPEEDUP pu=new SPEEDUP(x,y,MiNivel);
        grilla[x][y].setPowerup(pu);
        MiNivel.agregarObjeto(pu.getGrafico());
        pu.getGrafico().setVisible(false);
    }

    /**
     * Crea un Fatality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearFatality(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
    	FATALITY pu=new FATALITY(x,y,MiNivel);
        grilla[x][y].setPowerup(pu);
        MiNivel.agregarObjeto(pu.getGrafico());
        pu.getGrafico().setVisible(false);
    }

    /**
     * Crea un Bombality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearBombality(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
    	BOMBALITY pu=new BOMBALITY(x,y,MiNivel);
        grilla[x][y].setPowerup(pu);
        MiNivel.agregarObjeto(pu.getGrafico());
        pu.getGrafico().setVisible(false);
    }

    /**
     * Crea un Masacrality.
     * @param x Posicion en x dentro de la matriz.
     * @param y Posicion en y dentro de la matriz.
     * @param MiNivel Nivel al que pertenece.
     */
    public void crearMasacrality(int x, int y, NIVEL MiNivel,CELDA[][] grilla) {
    	MASACRALITY pu=new MASACRALITY(x,y,MiNivel);
        grilla[x][y].setPowerup(pu);
        MiNivel.agregarObjeto(pu.getGrafico());
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