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

		if(KeyIndentity == KeyEvent.VK_1) {
			getSpell1().setPressed(pressed);
		}

		if(KeyIndentity == KeyEvent.VK_2) {
			getSpell2().setPressed(pressed);
		}

		if(KeyIndentity == KeyEvent.VK_3) {
			getSpell3().setPressed(pressed);
		}

		if(KeyIndentity == KeyEvent.VK_4) {
			getSpell4().setPressed(pressed);
		}

		if(KeyIndentity == KeyEvent.VK_5) {
			getSpell5().setPressed(pressed);
		}
		
	}

}
