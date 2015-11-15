package personajes;

public class siriusThread extends Thread{

	/**
	 * Logica del Thread.
	 */
	private ENEMIGOS mLogica;
	
	/**
	 * Bandera de deteccion de este Thread.
	 */
	private volatile boolean mDetener;
	
	/**
	 * si es 1, indica que se esta esperando una explosion.
	 */
	public volatile int command;
	
	/**
	 * Rugulo que implementa la logica del Thread.
	 * @param logica logica utilizada.
	 */
	public siriusThread(ENEMIGOS logica) {
		this.mLogica  = logica;
		this.mDetener = false;
		iniciar();
		start();
		command=0;
	}
	
	/**
	 * Metodo de ejecucion de este Thread.
	 */
	@Override
	public void run() {
		
		while(true){
			
			if(!this.mDetener){
			
				try {
						//duermo el hilo 1 seg
						Thread.sleep(1000);
					
						//indico a la logica que se mueva.
						this.mLogica.avanzar();
					
				} catch (InterruptedException e) {}
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
		interrupt();
		detener();
	}
	
	/**
	 * inicia la transicion del Thread.
	 */
	public void iniciar(){
		this.mDetener = false;
	}
	
	/**
	 * setea el comando.
	 */
	public void setCommand(int i){
		command=i;
	}
	
}
	