package InputControl;


/*
 * Class of each key Input
 */
public class Key {
	private boolean isPressed ;
	
	public Key() {
		isPressed = false ;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}
}
