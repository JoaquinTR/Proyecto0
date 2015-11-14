package graficos;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class siriusGrafico extends Grafico{

	/**
     * constructor.
     * 
     * @param x posicion x en la matriz.
     * @param y posicion y en la matriz.
     */
	public siriusGrafico(int x, int y){
		super(x,y);
		
		Random rugulo=new Random();
		int seleccion = rugulo.nextInt(4);
		
		ImageIcon a=null;
		
		switch(seleccion){
		
		case 0:
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/deathlok/deathlokAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/deathlok/deathlokAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/deathlok/deathlokArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/deathlok/deathlokArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/deathlok/deathlokDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/deathlok/deathlokDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/deathlok/deathlokIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/deathlok/deathlokIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/MuerteMalo.gif"));
			this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		case 1:
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/joker/jokerAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/joker/jokerAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/joker/jokerArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/joker/jokerArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/joker/jokerDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/joker/jokerDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/joker/jokerIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/joker/jokerIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/MuerteMalo.gif"));
			this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		case 2:
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/venom/venomAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/venom/venomAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/venom/venomArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/venom/venomArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/venom/venomDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/venom/venomDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/venom/venomIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/venom/venomIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/MuerteMalo.gif"));
			this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		
			
		}
		
		
	}
	
}
