package personajes;

public class bombermanThread extends Thread{

	// Logica que implementa al malo.
			private BOMBERMAN mLogica;
			
			private int dir;
			
			// Flag que indica cuando debe detenerse la ejecución del hilo.
			// Es volatile porque es accedida desde concurrentemente desde diferentes threads.
			private volatile boolean mDetener;
			
			public bombermanThread(BOMBERMAN logica) {
				this.mLogica  = logica;
				this.mDetener = true;
			}
			
			@Override
			public void run() {
				//mDetener=false;
				// Ejecuto indefinidamente hasta que el flag sea verdadero.
				//Cambiar if por while y sacar el detener
				while(true){
					if(!this.mDetener){
						// Duermo el hilo 1 segundo.
						// De esta manera cada turno se ejecuta cada 1 segundo.
						try {
							// Realizo el movimiento
							Thread.sleep(125);
							this.mLogica.mover(dir);
							Thread.sleep(125);
							this.mLogica.mover(dir);
							Thread.sleep(125);
							this.mLogica.mover(dir);
							Thread.sleep(125);
							this.mLogica.mover(dir);
							this.mLogica.select(0);
						} catch (InterruptedException e) { }
					}
					detener();
				}
				
				//
			}
			
			public void detener() {
				// Interrumpo el hilo para que no continue con su ejecución.
				
				
				// Seteamos el flag para detener su ejecución.
				this.mDetener = true;
			}
			
			public void iniciar(){
				this.mDetener = false;
			}
			
			public void setDir(int dir){
				this.dir=dir;
			}
			
			public void destruir() {
				// Detengo la ejecucion del hilo.
				this.detener();
				
				// Notificamos a la logica que este hilo se destruyo.
				//this.mLogica.destruir();
			}
}
