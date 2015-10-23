package nivel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.GUI;
import mapa.CELDA;
import personajes.BOMBERMAN;
import personajes.ENEMIGOS;
import personajes.RUGULOS;
import personajes.rugulosThread;

/**
 * 
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
    public void crearNivel(CELDA[][] grilla, NIVEL MiNivel,GUI gui,ENEMIGOS[] Enemigos) {
        int i =0;
        int outer= 31;
        int outer2=13;

		MiNivel.Bomberman=new BOMBERMAN(MiNivel,1,1);
		MiNivel.Bomberman.select(4);
		gui.add(MiNivel.Bomberman.getGrafico());
        
		Enemigos[0] = new RUGULOS(MiNivel,3,1); 
		Enemigos[0].select(1);
		gui.add(Enemigos[0].getGrafico());
		
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
        
        grilla[3][1].agregarPersonaje(Enemigos[0]);
        grilla[1][5].agregarPersonaje(Enemigos[1]);
        grilla[1][1].agregarPersonaje(MiNivel.Bomberman);
        
        
    }

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public void crearRugulos(int x, int y, NIVEL MiNivel) {
        // TODO implement here
    }

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public void crearAltair(int x, int y, NIVEL MiNivel) {
        // TODO implement here
    }

    /**
     * @param MiNivel
     */
    public void crearSirius(NIVEL MiNivel) {
        // TODO implement here
    }

    /**
     * @param MiNivel
     */
    public void crearBomberman(NIVEL MiNivel) {
        // TODO implement here
    }

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public void crearSpeedup(int x, int y, NIVEL MiNivel) {
        // TODO implement here
    }

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public void crearFatality(int x, int y, NIVEL MiNivel) {
        // TODO implement here
    }

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public void crearBombality(int x, int y, NIVEL MiNivel) {
        // TODO implement here
    }

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public void crearMasacrality(int x, int y, NIVEL MiNivel) {
        // TODO implement here
    }

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public void crearCelda(int x, int y, NIVEL MiNivel) {
        // TODO implement here
    }

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public void crearCeldaPD(int x, int y, NIVEL MiNivel) {
        // TODO implement here
    }

    /**
     * @param x 
     * @param y 
     * @param MiNivel
     */
    public void crearCeldaPI(int x, int y, NIVEL MiNivel) {
        // TODO implement here
    }

}