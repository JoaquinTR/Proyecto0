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
				
				while(true){
					if((!this.mDetener)&&(dir!=-2)){
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
							
							this.mLogica.select(dir+4);
							
							mLogica.unlock();
							detener();
							
						} catch (InterruptedException e) { }
						
					} else if((!this.mDetener)&&(dir==-3)){
						try {
							Thread.sleep(200);
							} catch (InterruptedException e1) {}
						mLogica.unlock();
						detener();
						
					}
					
					//direccion -2 indica la transicion de la muerte.
					if(dir==-2){
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
			
			public void detener() {
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
