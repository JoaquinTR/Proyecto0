package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class menuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * Panel contenedor.
	 */
	private JPanel contentPane;
	
	//private JButton b;
	
	public menuPrincipal(){
		//tamaño no maximizado de la gui.
		setSize(700,500);
		
		//creacion y seteo del panel.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Supers-Bomberman®");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon c=new ImageIcon(this.getClass().getResource("/images/logo/logo.gif"));
		setIconImage(c.getImage());
		contentPane.setVisible(true);
		
		
		JButton b=new JButton("presione aqui.");
		b.setBounds(50, 50, 100, 50);
		b.setVisible(true);
		add(b);
		b.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
                GUI gui=new GUI();
                gui.setVisible(true);
                dispose();
            }
        });      
	}
	
	
}
