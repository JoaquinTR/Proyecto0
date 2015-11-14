package graficos;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


/**
 * Clase que modela un rugulo gr�ficamente.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
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
		
		Random rugulo=new Random();
		int seleccion = rugulo.nextInt(4);
		
		ImageIcon a=null;
		seleccion=1;
		switch(seleccion){
		case 0:
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/EncapuchadoOscuro/EncOscuroAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/EncapuchadoOscuro/EncOscuroAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/EncapuchadoOscuro/EncOscuroArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/EncapuchadoOscuro/EncOscuroArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/EncapuchadoOscuro/EncOscuroDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/EncapuchadoOscuro/EncOscuroDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/EncapuchadoOscuro/EncOscuroIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/EncapuchadoOscuro/EncOscuroIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/MuerteMalo.gif"));
			this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
			
		case 1:
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/CaballeritoMalo/CaballeritoMaloAbajoQ.gif"));
			this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/CaballeritoMalo/CaballeritoMaloAbajo.gif"));
			this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/CaballeritoMalo/CaballeritoMaloArribaQ.gif"));
			this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/CaballeritoMalo/CaballeritoMaloArriba.gif"));
			this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/CaballeritoMalo/CaballeritoMaloDerQ.gif"));
			this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/CaballeritoMalo/CaballeritoMaloDer.gif"));
			this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/CaballeritoMalo/CaballeritoMaloIzqQ.gif"));
			this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/CaballeritoMalo/CaballeritoMaloIzq.gif"));
			this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			a=new ImageIcon(this.getClass().getResource("/images/enemigos/Rugulos/MuerteMalo.gif"));
			this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
			
			break;
		case 2:
			break;
		case 3:
			break;
		}
		
		
	}
}
