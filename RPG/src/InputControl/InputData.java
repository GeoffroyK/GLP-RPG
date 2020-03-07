package InputControl;

public class InputData {
	
	private static Key up  = new Key() ;
	private static Key down = new Key() ;
	private static Key left = new Key() ;
	private static Key rigth = new Key() ;
	
	public static Key getUp() {
		return up;
	}

	public static void setUp(Key up) {
		InputData.up = up;
	}

	public static Key getDown() {
		return down;
	}

	public static void setDown(Key down) {
		InputData.down = down;
	}

	public static Key getLeft() {
		return left;
	}

	public static void setLeft(Key left) {
		InputData.left = left;
	}

	public static Key getRigth() {
		return rigth;
	}

	public static void setRigth(Key rigth) {
		InputData.rigth = rigth;
	}
}
