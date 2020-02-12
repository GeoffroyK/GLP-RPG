package loot;

public abstract class Loot {
	private String id;
	private String price;
	private String textBox;
	private String spritePath;
	
	public abstract Loot getById(String id);
	
	public String getId() {
		return id;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getSpritePath() {
		return spritePath;
	}
	
	public String getTextBox() {
		return textBox;
	}
}