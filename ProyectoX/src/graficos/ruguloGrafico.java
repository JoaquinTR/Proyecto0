package graficos;

import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * Clase que modela un rugulo gráficamente.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class ruguloGrafico extends Grafico {
	
	/**
     * constructor.
     * 
     * @param x posicion x en la matriz.
     * @param y posicion y en la matriz.
     */
	public ruguloGrafico(int x, int y){
		super(x,y);
		
		ImageIcon a=new ImageIcon(this.getClass().getResource("/images/enemigos/EncapuchadoOscuro/EncOscuroAbajoQ.gif"));
		this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/enemigos/EncapuchadoOscuro/EncOscuroAbajo.gif"));
		this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/enemigos/EncapuchadoOscuro/EncOscuroArribaQ.gif"));
		this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/enemigos/EncapuchadoOscuro/EncOscuroArriba.gif"));
		this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/enemigos/EncapuchadoOscuro/EncOscuroDerQ.gif"));
		this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/enemigos/EncapuchadoOscuro/EncOscuroDer.gif"));
		this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/enemigos/EncapuchadoOscuro/EncOscuroIzqQ.gif"));
		this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/enemigos/EncapuchadoOscuro/EncOscuroIzq.gif"));
		this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/MuerteCap.gif"));
		this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
	}
}
