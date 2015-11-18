package bomba;

/**
 * Clase que modela el Thread de un rugulo.
 * 
 * Tecnología de Programacion 2015.
 * 
 * @author Román, Ezequiel Jorge. LU: 97316
 * @author Waigel, Micaela Anahí. LU: 99558
 * @author Tricerri, Joaquín. LU:100236
 */
public class bombaThread extends Thread{
	/**
	 * Logica del Thread.
	 */
	private BOMBA mLogica;
	
	/**
	 * Rugulo que implementa la logica del Thread.
	 * @param bomba logica utilizada.
	 */
	public bombaThread(BOMBA bomba) {
		this.mLogica  = bomba;
	}
	
	/**
	 * Metodo de ejecucion de este Thread.
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			this.mLogica.explotar();
		} catch (InterruptedException e) { }
	}
	
}
