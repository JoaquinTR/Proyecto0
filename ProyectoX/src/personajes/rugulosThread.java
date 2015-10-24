package personajes;

/**
 * Clase que modela el Thread de un rugulo.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
 */
public class rugulosThread extends Thread{
		/**
		 * Logica del Thread.
		 */
		private RUGULOS mLogica;
		
		private int dir;
		
		/**
		 * Bandera de deteccion de este Thread.
		 */
		private volatile boolean mDetener;
		
		/**
		 * Rugulo que implementa la logica del Thread.
		 * @param logica logica utilizada.
		 */
		public rugulosThread(RUGULOS logica) {
			this.mLogica  = logica;
			this.mDetener = true;
		}
		
		/**
		 * Metodo de ejecucion de este Thread.
		 */
		@Override
		public void run() {
			
			while(true){
				if(!this.mDetener){
					
					try {
						// movimiento transitivo del rugulo, 0.5 segundos de duracion
						Thread.sleep(125);
						this.mLogica.mover(dir);
						Thread.sleep(125);
						this.mLogica.mover(dir);
						Thread.sleep(125);
						this.mLogica.mover(dir);
						Thread.sleep(125);
						this.mLogica.mover(dir);
						
						this.mLogica.select(dir+4);
						
						mLogica.unlock();
						
					} catch (InterruptedException e) { }
				}
				detener();
			}
			
			//
		}
		
		/**
		 * Metodo de detencion del hilo.
		 */
		public void detener() {
			
			this.mDetener = true;
		}
		
		/**
		 * destruccion del hilo. (rugulo).
		 */
		public void destruir() {

			this.detener();
			
			//muerte del rugulo.
		}
		
		/**
		 * Seteo de la direccion del rugulo.
		 * @param dir direccion del movimiento.
		 */
		public void setDir(int dir){
			this.dir=dir;
		}
		
		/**
		 * inicia la transicion del Thread.
		 */
		public void iniciar(){
			this.mDetener = false;
		}

}
