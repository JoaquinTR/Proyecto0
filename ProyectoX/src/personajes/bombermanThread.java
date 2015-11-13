package personajes;

import GUI.constantes;

/**
 * Clase que modela el Thread del bomberman.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
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
							
								mLogica.unlock();
								detener();
						
						
						} 
						//direccion -2 indica la transicion de la muerte.
						if(dir==constantes.DESTRUCCION){
							interrupt();
							detener();
							mLogica.destruirme();
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
