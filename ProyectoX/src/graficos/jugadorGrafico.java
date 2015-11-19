package graficos;

import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * Clase que modela el bomberman graficamente.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class jugadorGrafico extends Grafico {

	/**
     * constructor.
     * 
     * @param x posicion x en la matriz.
     * @param y posicion y en la matriz.
     */
	public jugadorGrafico(int x, int y, int seleccion){
		super(x,y);

		
		ImageIcon a=null;
		
		switch(seleccion){
		
		case 0:
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/muertes/MuerteCap.gif"));
			this.images[12] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		case 1:
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/spiderman/SpidyAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/spiderman/SpidyAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/spiderman/SpidyArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/spiderman/SpidyArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/spiderman/SpidyIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/spiderman/SpidyIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/spiderman/SpidyDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/spiderman/SpidyDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/muertes/muerteS.gif"));
			this.images[12] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		case 2:
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/superman/supermanAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/superman/supermanAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/superman/supermanArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/superman/supermanArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/superman/supermanIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/superman/supermanIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/superman/supermanDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/superman/supermanDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/muertes/muerteS.gif"));
			this.images[12] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		case 3:
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/batman/batgirlAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/batman/batgirlAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/batman/batgirlArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/batman/batgirlArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/batman/batgirlIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/batman/batgirlIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/batman/batgirlDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/bomberman/batman/batgirlDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/muertes/muerteBatman.gif"));
			this.images[12] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		}
		
	}
	
}
