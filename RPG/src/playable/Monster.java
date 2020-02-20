package playable;

public class Monster extends Character {

	private int lootChance;
	private int lootPrice;

	public Monster(String id, String type, int hp, int mp, int str, int dext, int intel, int def, int atk, int range,
			int inventory, int level, int atkSpeed, int ctkChance, int dodgeChance, int lootChance, int lootPrice) {

		super(id, type, hp, mp, str, dext, intel, def, atk, range, inventory, level, atkSpeed, ctkChance, dodgeChance);
		this.lootChance = lootChance;
		this.lootPrice = lootPrice;
	}

	public String toString() {
//		return super.toString() + "\nlootChance = " + lootChance + "\nlootPrice = "
//				+ lootPrice + "\n-----------------------------------------------\n";
		return "";
	}

	public int getLootChance() {
		return lootChance;
	}

	public void setLootChance(int lootChance) {
		this.lootChance = lootChance;
	}

	public int getLootPrice() {
		return lootPrice;
	}

	public void setLootPrice(int lootPrice) {
		this.lootPrice = lootPrice;
	}

}
