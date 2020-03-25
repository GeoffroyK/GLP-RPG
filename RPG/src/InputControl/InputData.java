package InputControl;

public class InputData {
	
	private static Key up  = new Key() ;
	private static Key down = new Key() ;
	private static Key left = new Key() ;
	private static Key right = new Key() ;
	private static Key inventaire = new Key() ;
	private static Key autoAttack = new Key() ;
	private static Key spell1 = new Key() ;
	private static Key spell2 = new Key() ;
	private static Key spell3 = new Key() ;
	private static Key spell4 = new Key() ;
	private static Key spell5 = new Key() ;
	private static Key enter = new Key() ;
	
	public static Key getEnter() {
		return enter;
	}

	public static void setEnter(Key enter) {
		InputData.enter = enter;
	}

	public static void setInventaire(Key inventaire) {
		InputData.inventaire = inventaire;
	}

	public static void setAutoAttack(Key autoAttack) {
		InputData.autoAttack = autoAttack;
	}

	public static void setSpell1(Key spell1) {
		InputData.spell1 = spell1;
	}

	public static void setSpell2(Key spell2) {
		InputData.spell2 = spell2;
	}

	public static void setSpell3(Key spell3) {
		InputData.spell3 = spell3;
	}

	public static void setSpell4(Key spell4) {
		InputData.spell4 = spell4;
	}

	public static void setSpell5(Key spell5) {
		InputData.spell5 = spell5;
	}

	public static Key getInventaire() {
		return inventaire;
	}

	public static Key getAutoAttack() {
		return autoAttack;
	}

	public static Key getSpell1() {
		return spell1;
	}

	public static Key getSpell2() {
		return spell2;
	}

	public static Key getSpell3() {
		return spell3;
	}

	public static Key getSpell4() {
		return spell4;
	}

	public static Key getSpell5() {
		return spell5;
	}
	

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

	public static Key getRight() {
		return right;
	}

	public static void setRight(Key rigth) {
		InputData.right = rigth;
	}
}
