package GUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class menu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Panel contenedor.
	 */
	private JPanel contentPane;
	
	public menu(){
		
		
		//tamaño no maximizado de la gui.
		setSize(698,500);
		
		//creacion y seteo del panel.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Supers-Bomberman®");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon b=new ImageIcon(this.getClass().getResource("/images/logo/logo.gif"));
		setIconImage(b.getImage());
		contentPane.setVisible(true);
		
		
		//adicionales a la gui.
		setVisible(true);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
}
