package personajes;

/**
 * Clase que modela el Thread de un rugulo.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class rugulosThread extends Thread{
		/**
		 * Logica del Thread.
		 */
		private RUGULOS mLogica;
		
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
			this.mDetener = false;
			iniciar();
			start();
		}
		
		/**
		 * Metodo de ejecucion de este Thread.
		 */
		@Override
		public void run() {
			
			while(true){
				if(!this.mDetener){
					
					try {
						Thread.sleep(1000);
						
						this.mLogica.avanzar();
						
						
						mLogica.unlock();
						
					} catch (InterruptedException e) { }
				}

			}
			
			
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
		 * inicia la transicion del Thread.
		 */
		public void iniciar(){
			this.mDetener = false;
		}

}
