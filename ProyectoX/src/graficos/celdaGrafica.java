package graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class celdaGrafica extends Grafico {

	public celdaGrafica(int x, int y) {
		super(x, y);
		ImageIcon a=new ImageIcon(this.getClass().getResource("/images/mapa/pasto.gif"));
		this.images[0] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/mapa/Entera.gif"));
		this.images[1] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/mapa/GrietaCostado.gif"));
		this.images[2] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/mapa/GrietaCostado2.gif"));
		this.images[3] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/mapa/GrietaPunta.gif"));
		this.images[4] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/mapa/Indestructible0.gif"));
		this.images[5] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/mapa/Indestructible1.gif"));
		this.images[6] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/mapa/RotaAbajo.gif"));
		this.images[7] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
		a=new ImageIcon(this.getClass().getResource("/images/mapa/RotaAbajo2.gif"));
		this.images[8] = new ImageIcon(a.getImage().getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT));
		
	}

}
