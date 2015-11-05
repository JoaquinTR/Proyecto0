package graficos;

import GUI.constantes;
import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase que modela un objeto gráfico.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public abstract class Grafico {
	
	/**
	 * objeto grafico del frame.
	 */
	protected JLabel grafico;

	/**
	 * Arreglo con las imagenes de este objeto.
	 */
	protected Icon images[];

	/**
	 * ancho de los objetos. 
	 */
	protected final int width = 44;
	
	/**
	 * alto de los objetos. 
	 */
	protected final int height = 44;
	
	/**
	 * posicion del grafico en el frame.
	 */
	protected Point pos;
		
	
	
    /**
     * constructor.
     * 
     * @param MiNivel nivel al que pertenece
     * @param x posicion x a transformar a grafica.
     * @param y posicion y a transformar en grafica.
     */
	protected Grafico(int x, int y){
		//seteo las posiciones del label.
		pos=new Point(x*height,135+(y*width));
		
		this.images = new Icon[20];
		
		this.grafico = new JLabel();
		this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
	}
	
	/**
	 * Selecta la imagen que tiene que mostrar.
	 * @param i indice del arreglo de imagenes, correspondiente a la imagen que muestra.
	 */
	public void select(int i){
		this.grafico.setIcon(this.images[i]);
	}
	
	/**
	 * Retorna la posicion en la interfaz.
	 * @return punto (x,y) correspondiente a la posicion del grafico en la interfaz.
	 */
	public Point getPos() {
		return pos;
	}

	/**
	 * Retorna el JLabel de este grafico.
	 * @return JLabel de este grafico.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(images[0]);
			this.grafico.setBounds(this.pos.x, 135+ this.pos.y, width, height);
		}
		
		return this.grafico;
	}
	
	
	/**
	 * mueve este grafico 11 unidades en una direccion indicada.
	 * 0 bajo
	 * 1 arriba
	 * 2 izquierda
	 * 3 derecha
	 * @param dir direccion del movimiento.
	 */
	public void mover(int dir){
		
		try {
		switch(dir){
			case constantes.ABAJO: 
				select(0);
				for(int i=0;i<4;i++){
					grafico.setLocation(grafico.getX(),grafico.getY()+11);
					pos.x=grafico.getX();
					pos.y=grafico.getY();
					Thread.sleep(125);
				}
				break;
			case constantes.ARRIBA:
				select(1);
				for(int i=0;i<4;i++){
					grafico.setLocation(grafico.getX(),grafico.getY()-11);
					pos.x=grafico.getX();
					pos.y=grafico.getY();
					Thread.sleep(125);
				}
				break;
			case constantes.IZQUIERDA:
				select(2);
				for(int i=0;i<4;i++){
					grafico.setLocation(grafico.getX()-11,grafico.getY());
					pos.x=grafico.getX();
					pos.y=grafico.getY();
					Thread.sleep(125);
				}
				break;
			case constantes.DERECHA:
				select(3);
				for(int i=0;i<4;i++){
					grafico.setLocation(grafico.getX()+11,grafico.getY());
					pos.x=grafico.getX();
					pos.y=grafico.getY();
					Thread.sleep(125);
				}
				break;
		}
		} catch (InterruptedException e) {}
	}
}
