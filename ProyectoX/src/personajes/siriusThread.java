package personajes;

public class siriusThread extends Thread{

	/**
	 * Logica del Thread.
	 */
	private SIRIUS mLogica;
	
	/**
	 * Bandera de deteccion de este Thread.
	 */
	private volatile boolean mDetener;
	
	/**
	 * si es 1, indica que se esta esperando una explosion.
	 */
	public int command;
	
	/**
	 * si es 1, indica que se esta esperando una explosion.
	 */
	public  int direccion;
	
	/**
	 * Rugulo que implementa la logica del Thread.
	 * @param logica logica utilizada.
	 */
	public siriusThread(SIRIUS logica) {
		this.mLogica  = logica;
		this.mDetener = false;
		iniciar();
		start();
		command=-5;
	}
	
	/**
	 * Metodo de ejecucion de este Thread.
	 */
	@Override
	public void run() {
		
		while(true){
			
			if(!this.mDetener){
			
				try {
					
					
					
					
					if(command==-5){
						//duermo el hilo 1 seg
						Thread.sleep(1000);
					
						//indico a la logica que se mueva.
						this.mLogica.avanzar();
					}	
					if(command==-10){
						//duermo el hilo 3 seg esperando explosion.
						Thread.sleep(3000);
						
					}	
					if(command==-15){
						//duermo el hilo 1 seg
						Thread.sleep(1000);
					
						//indico a la logica que se mueva.
						this.mLogica.mover(direccion);
					}
						
						
					
				} catch (InterruptedException e) {}
				detener();
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

	/**
	 * setea la direccion del movimiento.
	 * @param nueva direccion.
	 */
	public void setDireccion(int direccion2) {
		direccion=direccion2;
		
	}
	
}
	