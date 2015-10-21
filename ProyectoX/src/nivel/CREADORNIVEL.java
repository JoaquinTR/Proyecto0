package nivel;

import GUI.GUI;
import mapa.CELDA;

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
    public void crearNivel(CELDA[][] grilla, NIVEL MiNivel,GUI gui) {
        int i =0;
        int outer= 31;
        
        for(i=0;i<outer;i++){
        	grilla[i][0] = new CELDA(MiNivel,i,0);  
        	grilla[i][0].crearPared(false);
        	grilla[i][0].select(5);
        	gui.add(grilla[i][0].getGrafico());
        	
        	grilla[i][30] = new CELDA(MiNivel,i,30);  
        	grilla[i][30].crearPared(false);
        	grilla[i][30].select(5);
        	gui.add(grilla[i][30].getGrafico());
        	
        }
        
        for(i=1;i<outer;i++){
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
        for(i=1;i<31;i++){
        	for(j=1;j<31;j++){
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