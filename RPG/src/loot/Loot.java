package loot;

public abstract class Loot {
	private String id;
	private double price;
	private String textBox;
	private String spritePath;
	
	public Loot(String id, double price, String textBox, String spritePath) {
		this.id = id ;
		this.price = price ;
		this.textBox = textBox ;
		this.spritePath = spritePath ;
	}
	
	public String getId() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getSpritePath() {
		return spritePath;
	}
	
	public String getTextBox() {
		return textBox;
	}
}