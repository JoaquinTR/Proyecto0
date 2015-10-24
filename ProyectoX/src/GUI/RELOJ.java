package GUI;

import javax.swing.JLabel;

import nivel.NIVEL;

/**
 * Clase que modela el "clock" del programan ademas de mantener el tiempo de partida.
 *  Seteado cada 1.5seg.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class RELOJ extends Thread{
    
	private NIVEL MiNivel;
	
    /**
     * segundos del nivel.
     */
    private int segundos;

    /**
     * minutos del nivel.
     */
    private int minutos;

    /**
     * horas del nivel.
     */
    private int horas;
    

    /**
     * constructor.
     * @param MiNivel nivel al que pertenece.
     */
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
			} catch (InterruptedException e) {}
			
			
			MiNivel.moverM();
		
		
		}
	}
	
    /**
     * Aumenta los segundos y controla los topes (60).
     */
    public void aumentar() {
        segundos++;
        if(segundos==60)
        	minutos++;
        if(minutos==60)
        	horas++;
    }

    /**
     * retorna la cantidad de segundos en el nivel.
     * @return Segundos del nivel.
     */
    public int getSegundos() {
       	return segundos;
    }

    /**
     * retorna la cantidad de minutos en el nivel.
     * @return Minutos del nivel.
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * retorna la cantidad de horas en el nivel.
     * @return Horas del nivel.
     */
    public int getHoras() {
        return horas;
    }

}