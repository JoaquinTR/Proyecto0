package bomba;

/**
 * Clase que modela el Thread de un rugulo.
 * 
 * Tecnolog�a de Programacion 2015.
 * 
 * @author Rom�n, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anah�. LU: 99558
 * @author Tricerri, Joaqu�n. LU:100236
 */
public class bombaThread extends Thread{
	/**
	 * Logica del Thread.
	 */
	private BOMBA mLogica;
	
	/**
	 * Bandera de deteccion de este Thread.
	 */
	private volatile boolean mDetener;
	
	/**
	 * Rugulo que implementa la logica del Thread.
	 * @param logica logica utilizada.
	 */
	public bombaThread(BOMBA logica) {
		this.mLogica  = logica;
		this.mDetener = true;
	}
	
	/**
	 * Metodo de ejecucion de este Thread.
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			this.mLogica.explotar();
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
