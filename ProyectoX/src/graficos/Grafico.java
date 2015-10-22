package graficos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;


public abstract class Grafico {
	//objeto grafico en el frame.
	protected JLabel grafico;
	//imagenes del grafico.
	protected Icon images[];
	//ancho y altura del objeto.
	protected final int width = 44;
	protected final int height = 44;
	
	protected Point pos;//posicion del grafico en el frame.
		
	protected Grafico(int x, int y){
		//seteo las posiciones del label.
		pos=new Point(x*height,135+(y*width));
		
		this.images = new Icon[20];
		
		this.grafico = new JLabel();
		this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		
	}
	
	
	public void select(int i){
		this.grafico.setIcon(this.images[i]);
	}
	public Point getPos() {
		return pos;
	}

	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(images[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}
	
	
	
	public void mover(int dir){
		switch(dir){
			case 0:
				select(1);
				pos.setLocation(grafico.getX(),grafico.getY()+11);
				grafico.setLocation(grafico.getX(),grafico.getY()+11);
				grafico.setVisible(true);
				break;
			case 1:
				select(4);
				pos.setLocation(grafico.getX(),grafico.getY()-11);
				grafico.setLocation(grafico.getX(),grafico.getY()-11);
				grafico.setVisible(true);
				break;
			case 2:
				select(7);
				pos.setLocation(grafico.getX()-11,grafico.getY());
				grafico.setLocation(grafico.getX()-11,grafico.getY());
				grafico.setVisible(true);
				break;
			case 3:
				select(10);
				pos.setLocation(grafico.getX()+11,grafico.getY());
				grafico.setLocation(grafico.getX()+11,grafico.getY());
				grafico.setVisible(true);
				break;
		}
	}
}
