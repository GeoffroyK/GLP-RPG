package map_objects;

import java.util.HashMap;

/*
 * Data Class of the Stair, contains its position
 */
public class Stair extends Prop {

    private int levels ;
    private int startX ;
    private int startY ;

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }


    public int getStartX() {
        return startX;
    }


    public void setStartX(int startX) {
        this.startX = startX;
    }


    public int getStartY() {
        return startY;
    }


    public void setStartY(int startY) {
        this.startY = startY;
    }


    public Stair(String id, String name, String spritePath, int x, int y, int level) {
        super(id, name, spritePath, x, y);
        levels = level ;
    }

}