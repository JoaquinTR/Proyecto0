package personajes;

import GUI.constantes;

/**
 * Clase que modela el Thread del bomberman.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
 */
public class bombermanThread extends Thread{

			/**
			 * logica del Thread.
			 */
			private BOMBERMAN mLogica;
			
			/**
			 * direccion del movimiento.
			 */
			private int dir;
			
			/**
			 * Control de detencion del Thread.
			 */
			private volatile boolean mDetener;
			
			
			/**
			 * Constructor del Thread.
			 * @param logica Logica del Thread.
			 */
			public bombermanThread(BOMBERMAN logica) {
				this.mLogica  = logica;
				this.mDetener = true;
			}
			
			/**
			 * Metodo encargado de la ejecucion temporal del Thread.
			 */
			@Override
			public void run() {
				
				while(true){
					
					if(!this.mDetener){
						if(dir!=constantes.DESTRUCCION){
						
								this.mLogica.mover(dir);
								this.mLogica.select(dir+4);
							
								mLogica.unlock();
								detener();
						
						
						} 
						if(dir>=4){ //se trago una pared.
						
							mLogica.select(dir);
							mLogica.unlock();
							detener();
						
						}
					
						//direccion -2 indica la transicion de la muerte.
						if(dir==constantes.DESTRUCCION){
							mLogica.select(12);
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {}
							
							interrupt();
							mLogica.getGrafico().setVisible(false);
							detener();
						}
					}
				}
				
				
			}
			
			/**
			 * detiene este Thread.
			 */
			public void detener() {
				this.mDetener = true;
				
				
			}
			
			/**
			 * inicia este Thread.
			 */
			public void iniciar(){
				this.mDetener = false;
			}
			
			/**
			 * Carga la direccion del movimiento del bomberman.
			 * @param dir direccion del movimiento siguiente.
			 */
			public void setDir(int dir){
				this.dir=dir;
			}
			
			/**
			 * destruye este hilo.
			 */
			public void destruir() {
				this.detener();
				
				//aca se notifica que el hilo se destruye deberia interrumpirse la ejecucion.
			}
}
