package playable;
import java.util.Scanner;
import map.*;

public class Move {
	private Character Hero;
	private Map map;
	private Scanner sc = new Scanner(System.in);
	
	public Move(Character Hero, Map map) {
		this.Hero = Hero;
		this.map = map;	
		Hero.setX(0);
		Hero.setY(0);
	}
	
	public void move() {
		System.out.println("Direction ?");
		String tmp = sc.nextLine();
		switch(tmp) {
			case "z":
				if(Hero.getY() != 0) {
					if(map.isOccupied(Hero.getX(), Hero.getY() - 1)){
						System.err.println("Case occupée ! C'est le monstre :"+map.getMonsterNameByPos(Hero.getX(), Hero.getY() - 1));
					}
					else {
						Hero.setY(Hero.getY() - 1);
					}
				}
				break;
			case "s":
				if(Hero.getY() != map.getLength()) {
					if(map.isOccupied(Hero.getX(), Hero.getY() + 1)){
						System.err.println("Case occupée ! C'est le monstre :"+map.getMonsterNameByPos(Hero.getX(), Hero.getY() + 1));
					}
					else {
						Hero.setY(Hero.getY() + 1);
					}
				}
				break;
			case "q":
				if(Hero.getX() != 0) {
					if(map.isOccupied(Hero.getX() - 1, Hero.getY())){
						System.err.println("Case occupée ! C'est le monstre :"+map.getMonsterNameByPos(Hero.getX() - 1, Hero.getY()));
					}
					else {
						Hero.setX(Hero.getX() - 1);
					}
				}
				break;
			case "d":
				if (Hero.getX() != map.getWidth()) {
					if(map.isOccupied(Hero.getX() + 1, Hero.getY())){
						System.err.println("Case occupée ! C'est le monstre :"+map.getMonsterNameByPos(Hero.getX() + 1, Hero.getY()));
					}
					else {
						Hero.setX(Hero.getX() + 1);
					}
				}
				break;
		}
	}
	
	public static void main(String[]args) {
		Monster ronflex = new Monster("ma2","Ronflex",60,0,0,0,0,20,20,60,0,1,2,0,0,50,40);
		ronflex.setX(5);
		ronflex.setY(5);
		ronflex.setDirection(0);
		Move test = new Move(new Player("pg1","Michel",100,100,60,40,5,50,35,10,1,1,2,20,10,0), new Map());
		test.map.addMonster(ronflex);
		while(0 != 1) {
			System.out.println("Position du personnage : (" + test.Hero.getX() + "," + test.Hero.getY() + ")\n");
			test.move();
		}	
	}
}
