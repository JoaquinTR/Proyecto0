package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;
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
    private int Isegundos;

    /**
     * minutos del nivel.
     */
    private int Iminutos;

    
    /**
     * interfaz grafica de este reloj
     */
    private GUI gui;
    
    /**
     * segundos graficos. Unidad.
     */
    protected JLabel segundosU;
    
    /**
     * segundos graficos. Decena.
     */
    protected JLabel segundosD;
    
    /**
     * minutos graficos. Unidad.
     */
    private JLabel minutosU;

    /**
     * minutos graficos. Decena.
     */
    private JLabel minutosD;
    
    /**
     * Dos puntos graficos.
     */
    private JLabel dosPuntos;
    
    /**
     * Dos puntos graficos.
     */
    private JLabel Relojito;
    
    /**
     * imagenes disponibles.
     */
    private ImageIcon[] images;
    
    /**
     * unidades del puntaje, grafico.
     */
    private JLabel puntajeU;
    
    /**
     * decenas del puntaje, grafico.
     */
    private JLabel puntajeD;
    
    /**
     * centenas del puntaje, grafico.
     */
    private JLabel puntajeC;
    
    /**
     * milesimas del puntaje, grafico.
     */
    private JLabel puntajeM;
    
    /**
     * unidades de paredes destructibles restantes, grafico.
     */
    private JLabel pdrU;
    
    /**
     * decenas de paredes destructibles restantes, grafico.
     */
    private JLabel pdrD;
    
    /**
     * centenas de paredes destructibles restantes, grafico.
     */
    private JLabel pdrC;

    /**
     * constructor.
     * @param MiNivel nivel al que pertenece.
     */
    public RELOJ(NIVEL MiNivel,GUI gui){
    	Isegundos=0;
    	Iminutos=0;
    	this.MiNivel= MiNivel;
    	this.gui=gui;
    	
    	images=new ImageIcon[13];
    	
    	ImageIcon a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Cero.gif"));
		this.images[0] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Uno.gif"));
		this.images[1] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Dos.gif"));
		this.images[2] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Tres.gif"));
		this.images[3] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Cuatro.gif"));
		this.images[4] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Cinco.gif"));
		this.images[5] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Seis.gif"));
		this.images[6] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Siete.gif"));
		this.images[7] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Ocho.gif"));
		this.images[8] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Nueve.gif"));
		this.images[9] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/dosPuntos.gif"));
		this.images[10] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/numerosReloj/Relojito.gif"));
		this.images[11] = new ImageIcon(a.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    
		
		int posxPDR = 646;
		
		
		pdrU=new JLabel();
		pdrU.setBounds(posxPDR + 132, 10, 44, 44);
		pdrU.setIcon(images[0]);
    	gui.agregarObjeto(pdrU);
    	pdrU.setVisible(true);
    	
    	pdrD=new JLabel();
    	pdrD.setBounds(posxPDR + 88, 10, 44, 44);
    	pdrD.setIcon(images[0]);
    	gui.agregarObjeto(pdrD);
    	pdrD.setVisible(true);
    	
    	pdrC=new JLabel();
    	pdrC.setBounds(posxPDR + 44, 10, 44, 44);
    	pdrC.setIcon(images[0]);
    	gui.agregarObjeto(pdrC);
    	pdrC.setVisible(true);
		
		
		int posxP = 350;
		
		
		puntajeU=new JLabel();
		puntajeU.setBounds(posxP + 132, 10, 44, 44);
		puntajeU.setIcon(images[0]);
    	gui.agregarObjeto(puntajeU);
    	puntajeU.setVisible(true);
    	
    	puntajeD=new JLabel();
    	puntajeD.setBounds(posxP + 88, 10, 44, 44);
    	puntajeD.setIcon(images[0]);
    	gui.agregarObjeto(puntajeD);
    	puntajeD.setVisible(true);
    	
    	puntajeC=new JLabel();
    	puntajeC.setBounds(posxP + 44, 10, 44, 44);
    	puntajeC.setIcon(images[0]);
    	gui.agregarObjeto(puntajeC);
    	puntajeC.setVisible(true);
    	
    	puntajeM=new JLabel();
    	puntajeM.setBounds(posxP , 10, 44, 44);
    	puntajeM.setIcon(images[0]);
    	gui.agregarObjeto(puntajeM);
    	puntajeM.setVisible(true);

    	int posx = 54;
    	
    	segundosU=new JLabel();
    	segundosU.setBounds(posx + 176, 10, 44, 44);
    	segundosU.setIcon(images[0]);
    	gui.agregarObjeto(segundosU);
    	segundosU.setVisible(true);
    	
    	segundosD=new JLabel();
    	segundosD.setBounds(posx + 132, 10, 44, 44);
    	segundosD.setIcon(images[0]);
    	gui.agregarObjeto(segundosD);
    	segundosD.setVisible(true);
    	
    	dosPuntos=new JLabel();
    	dosPuntos.setBounds(posx+88, 10, 44, 44);
    	dosPuntos.setIcon(images[10]);
    	gui.agregarObjeto(dosPuntos);
    	dosPuntos.setVisible(true);
    	
    	minutosU=new JLabel();
    	minutosU.setBounds(posx+44, 10, 44, 44);
    	minutosU.setIcon(images[0]);
    	gui.agregarObjeto(minutosU);
    	minutosU.setVisible(true);
    	
    	minutosD=new JLabel();
    	minutosD.setBounds(posx, 10, 44, 44);
    	minutosD.setIcon(images[0]);
    	gui.agregarObjeto(minutosD);
    	minutosD.setVisible(true);
    	
    	Relojito=new JLabel();
    	Relojito.setBounds(posx-44, 10, 44, 44);
    	Relojito.setIcon(images[11]);
    	gui.agregarObjeto(Relojito);
    	Relojito.setVisible(true);
    	
    }
    
	
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
				dosPuntos.setVisible(false);
				
				//actualizacion de puntaje.
				int puntaje = MiNivel.getPuntaje();
				puntajeU.setIcon(images[puntaje % 10]);
				puntaje = puntaje / 10;
				puntajeD.setIcon(images[puntaje % 10]);
				puntaje = puntaje / 10;
				puntajeC.setIcon(images[puntaje % 10]);
				puntaje = puntaje / 10;
				puntajeM.setIcon(images[puntaje % 10]);
				
				//actualizacion de paredes destructibles restantes.
				int pdr = MiNivel.getPDR();
				pdrU.setIcon(images[pdr % 10]);
				pdr = pdr / 10;
				pdrD.setIcon(images[pdr % 10]);
				pdr = pdr / 10;
				pdrC.setIcon(images[pdr % 10]);
				
				Thread.sleep(500);
				dosPuntos.setVisible(true);
			} catch (InterruptedException e) {}
			
			//mando un clock al reloss.
			aumentar();

		
		
		}
	}
	
    /**
     * Aumenta los segundos y controla los topes (60).
     */
    public void aumentar() {
    	
        Isegundos++;
        
        if(Isegundos%10==0){
        	segundosD.setIcon(images[Isegundos/10]);
        }
        
        segundosU.setIcon(images[Isegundos%10]);
        
        if(Isegundos==59){
        	
        	segundosD.setIcon(images[0]);
        	segundosU.setIcon(images[0]);
        	
        	Isegundos=0;
        	Iminutos++;
        	
        	if(Iminutos%10==0){
            	minutosD.setIcon(images[Iminutos/10]);
            	
            }
            minutosU.setIcon(images[Iminutos%10]);
        }
        
    }

    /**
     * retorna la cantidad de segundos en el nivel.
     * @return Segundos del nivel.
     */
    public int getSegundos() {
       	return Isegundos;
    }

    /**
     * retorna la cantidad de minutos en el nivel.
     * @return Minutos del nivel.
     */
    public int getMinutos() {
        return Iminutos;
    }


}