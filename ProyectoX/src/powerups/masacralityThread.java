package powerups;

import bomba.BOMBA;

public class masacralityThread extends Thread {
	/**
	 * Logica del Thread.
	 */
	private MASACRALITY mLogica;
	
	/**
	 * Bandera de deteccion de este Thread.
	 */
	private volatile boolean mDetener;
	
	/**
	 * Rugulo que implementa la logica del Thread.
	 * @param logica logica utilizada.
	 */
	public masacralityThread(MASACRALITY logica) {
		this.mLogica  = logica;
		this.mDetener = true;
	}
	
	/**
	 * Metodo de ejecucion de este Thread.
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			this.mLogica.restaurar();
			detener();
		} catch (InterruptedException e) { }
	}
	
	/**
	 * Metodo de detencion del hilo.
	 */
	public void detener() {
		this.mDetener = true;
	}
	
	/**
	 * inicia la transicion del Thread.
	 */
	public void iniciar(){
		this.mDetener = false;
	}
}
