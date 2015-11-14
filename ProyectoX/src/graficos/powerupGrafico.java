package graficos;

import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * Clase que modela los power-up gr�ficamente.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
 */
public class powerupGrafico extends Grafico{

	public powerupGrafico(int x, int y) {
		super(x, y);
		
		ImageIcon a=new ImageIcon(this.getClass().getResource("/images/powerups/bombality.gif"));
		this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
	
		a=new ImageIcon(this.getClass().getResource("/images/powerups/fatality.gif"));
		this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/powerups/masacrality.gif"));
		this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/powerups/speedup.gif"));
		this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
	}

}
