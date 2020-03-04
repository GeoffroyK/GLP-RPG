package game;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Window() {
		setTitle("DarkDreams");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel(1280,720)); // Contenu de la fenetre
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
