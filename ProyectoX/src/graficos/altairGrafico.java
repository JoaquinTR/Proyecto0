package graficos;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


/**
 * Clase que modela un altair gráficamente.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class altairGrafico extends Grafico{

	/**
     * constructor.
     * 
     * @param x posicion x en la matriz.
     * @param y posicion y en la matriz.
     */
	public altairGrafico(int x, int y, int seleccion){
		super(x,y);
		
		ImageIcon a=null;
		
		switch(seleccion){
		
		case 0:
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Brujita/BrujitaAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Brujita/BrujitaAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Brujita/BrujitaArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Brujita/BrujitaArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Brujita/BrujitaDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Brujita/BrujitaDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Brujita/BrujitaIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Brujita/BrujitaIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/muertes/MuerteMalo.gif"));
			this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		case 1:
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/EncapuchadoRojo/EncapuchadoRojoAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/EncapuchadoRojo/EncapuchadoRojoAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/EncapuchadoRojo/EncapuchadoRojoArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/EncapuchadoRojo/EncapuchadoRojoArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/EncapuchadoRojo/EncapuchadoRojoDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/EncapuchadoRojo/EncapuchadoRojoDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/EncapuchadoRojo/EncapuchadoRojoIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/EncapuchadoRojo/EncapuchadoRojoIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/muertes/MuerteMalo.gif"));
			this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		case 2:
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Sombra/SombraAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Sombra/SombraAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Sombra/SombraArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Sombra/SombraArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Sombra/SombraDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Sombra/SombraDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Sombra/SombraIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Sombra/SombraIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/muertes/MuerteMalo.gif"));
			this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		case 3:
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Velitas/VelitasAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Velitas/VelitasAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Velitas/VelitasArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Velitas/VelitasArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Velitas/VelitasDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Velitas/VelitasDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Velitas/VelitasIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Altair/Velitas/VelitasIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/muertes/MuerteMalo.gif"));
			this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		}
		
		
	}
	
}
