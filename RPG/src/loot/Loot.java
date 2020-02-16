package loot;

public abstract class Loot {
	private String id;
	private double price;
	private String name ;
	private String textBox;
	private String spritePath;
	
	public Loot(String id, double price, String name, String textBox, String spritePath) {
		this.id = id ;
		this.price = price ;
		this.name = name ;
		this.textBox = textBox ;
		this.spritePath = spritePath ;
	}
	
	public String toString() {
		return "id : " + id + "nom : " + name + "\ntextBox : " + textBox + "\nprice : " + price + " spritePath : " + spritePath ;
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