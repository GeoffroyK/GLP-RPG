package InputControl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.GamePanel;

import static InputControl.InputData.* ;

public class InputHandler implements KeyListener{

	public InputHandler (GamePanel game) {
		game.addKeyListener(this);
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		toggledKey(e.getKeyCode(), true) ;
	}

	public void keyReleased(KeyEvent e) {
		toggledKey(e.getKeyCode(), false);
	}
	
	public void toggledKey(int KeyIndentity, boolean pressed) {
		if(KeyIndentity == KeyEvent.VK_W) {
			getUp().setPressed(pressed);
			System.out.println("effectue");
		}
	}

}