package InputControl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;

import static InputControl.InputData.* ;

public class InputHandler implements KeyListener{

	public InputHandler (Game game) {
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
		
		if(KeyIndentity == KeyEvent.VK_Z) {
			getUp().setPressed(pressed);
		}
		
		if(KeyIndentity == KeyEvent.VK_Q) {
			getLeft().setPressed(pressed);
		}
		
		if(KeyIndentity == KeyEvent.VK_S) {
			getDown().setPressed(pressed);
		}
		
		if(KeyIndentity == KeyEvent.VK_D) {
			getRight().setPressed(pressed);
		}
		
		if(KeyIndentity == KeyEvent.VK_I) {
			getInventaire().setPressed(pressed);
		}

		if(KeyIndentity == KeyEvent.VK_SPACE) {
			getAutoAttack().setPressed(pressed);
		}

		if(KeyIndentity == KeyEvent.VK_H) {
			getSpell1().setPressed(pressed);
		}

		if(KeyIndentity == KeyEvent.VK_J) {
			getSpell2().setPressed(pressed);
		}

		if(KeyIndentity == KeyEvent.VK_K) {
			getSpell3().setPressed(pressed);
		}

		if(KeyIndentity == KeyEvent.VK_L) {
			getSpell4().setPressed(pressed);
		}

		if(KeyIndentity == KeyEvent.VK_M) {
			getSpell5().setPressed(pressed);
		}
		
		if(KeyIndentity == KeyEvent.VK_ENTER) {
			getEnter().setPressed(pressed);
			;
		}
		
	}

}
