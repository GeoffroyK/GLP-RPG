package map_objects;

import GameState.GameStateManager;
import GameState.InGameState;

public class StairTreatment {

    public static void up() {
        InGameState.setLevel(InGameState.getLevel() + 1);
    }

    public void down() {
        InGameState.setLevel(InGameState.getLevel() - 1);
    }

    public static void manage() {
        if(InGameState.getLevel() == 1 || InGameState.getLevel() == 2) {
            up() ;
        }
    }

}