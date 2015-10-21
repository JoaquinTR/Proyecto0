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
	protected final int width = 22;
	protected final int height = 22;
	
	protected Point pos;//posicion del grafico en el frame.
	
	
	protected Grafico(int x, int y){
		//seteo las posiciones del label.
		pos=new Point(x*height,y*width);
		
		this.images = new Icon[10];
		
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
}
