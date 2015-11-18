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
