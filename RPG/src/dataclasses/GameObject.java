package dataclasses;

public abstract class GameObject{

	private String id;
//	private String spritePath;
//	private boolean priority;
	
	public GameObject(String id) {
		this.id = id;
	}
	
	public String toString() {
		return "id = " + id + " ";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
//	public String getSpritePath() {
//		return spritePath;
//	}
//	public void setSpritePath(String spritePath) {
//		this.spritePath = spritePath;
//	}
//	public boolean isPriority() {
//		return priority;
//	}
//	public void setPriority(boolean priority) {
//		this.priority = priority;
//	}
	
	
}
