package dataclasses;

public abstract class GameObject{

	private String id;
	private String spritePath;
	private boolean priority;
	
	public GameObject(String id, String spritePath, boolean priority) {
		this.id = id ;
		this.spritePath = spritePath ;
		this.priority = priority ;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSpritePath() {
		return spritePath;
	}
	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
	}
	public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
	
	
}
