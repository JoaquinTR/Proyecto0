package GUI;

import java.util.Random;

import nivel.NIVEL;

/**
 * 
 */
public class RELOJ extends Thread{
    
	private NIVEL MiNivel;
	
    /**
     * 
     */
    private int segundos;

    /**
     * 
     */
    private int minutos;

    /**
     * 
     */
    private int horas;
    
    private GUI gui;


    public RELOJ(NIVEL MiNivel){
    	segundos=0;
    	minutos=0;
    	horas=0;
    	this.MiNivel= MiNivel;
    }
    
	
	public void run() {
		while(true){
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Random r = new Random();
			int dir=Math.abs(r.nextInt()%3);
			MiNivel.moverM();
		}
	}
	
    /**
     * 
     */
    public void aumentar() {
        segundos++;
        if(segundos==60)
        	minutos++;
        if(minutos==60)
        	horas++;
    }

    /**
     * 
     */
    public int getSegundos() {
       	return segundos;
    }

    /**
     * 
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * 
     */
    public int getHoras() {
        return horas;
    }

}