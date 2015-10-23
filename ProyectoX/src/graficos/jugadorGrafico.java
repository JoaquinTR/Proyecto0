package graficos;

import java.awt.Image;

import javax.swing.ImageIcon;

public class jugadorGrafico extends Grafico {

	public jugadorGrafico(int x, int y){
		super(x,y);
		
		ImageIcon a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapAbajoQ.gif"));
		this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapAbajo.gif"));
		this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapAbajoP.gif"));
		this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapArribaQ.gif"));
		this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapArriba.gif"));
		this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapArribaP.gif"));
		this.images[9] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapIzqQ.gif"));
		this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapIzq.gif"));
		this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapIzqP.gif"));
		this.images[10] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapDerQ.gif"));
		this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapDer.gif"));
		this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/CapDerP.gif"));
		this.images[11] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/bomberman/Cap/MuerteCap.gif"));
		this.images[12] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
	}
	
}
