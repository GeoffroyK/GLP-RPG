package map_objects;

import java.util.ArrayList;

import loot.Loot;

public class Seller extends Prop {
	
	private ArrayList<Loot> article ;
	
	public Seller(String id, String name, String spritePath, int x, int y, ArrayList<Loot> l) {
		super(id, name, spritePath, x, y);
		article = l ;
	}

	public ArrayList<Loot> getArticle() {
		return article;
	}

	public void setArticle(ArrayList<Loot> article) {
		this.article = article;
	}
	
}
