package inventory;

import java.util.Scanner;

import loot.Loot;
import playable.Player;

public class InventoryKey {
	
	public static void choice(Player p) {
		
		System.out.println(InventoryThread.showInv(p.getInventory()));
		
		System.out.println("CHOOSE ITEM's ID TO USE : (IF YOU WANNA QUIT PRESS 'E')");
		
		Scanner sc  = new Scanner(System.in) ;
		String str = sc.nextLine();
		
		int find = 0 ;
		Loot tmp = null ;
		
		for (Loot l : p.getInventory().getDrops()) {
			if(l.getId().equals(str)) {
				find = 1 ;
				tmp = l ;
			}
		}
		
		if(!str.equals("E")) {
			if(str.equals("P")) {
				System.out.println(p);
			}
			else if(find == 1){
				InventoryThread.Action(tmp, p);
			}
			else {
				System.out.println("ID Not Found !");
			}
		}
		
		System.out.println("QUIT INVENTORY");
		find = 0 ;
	}
	
	public static void addLoot(Loot lootDrop, Player p) {
		if(p.getInventory().getSize() + lootDrop.getSize() <= p.getInventory().getSizeMax()) {
			int size = p.getInventory().getSize() + lootDrop.getSize();
			p.getInventory().setSize(size);
			if(p.getInventory().getDrops().contains(lootDrop)) {
				int index = p.getInventory().getDrops().indexOf(lootDrop);
				p.getInventory().getDrops().get(index).setItemCounter(p.getInventory().getDrops().get(index).getItemCounter() + 1);
			}
			else {
				p.getInventory().getDrops().add(lootDrop);
			}
		}
	}
	
	public static void suppLoot(Loot lootThrow, Player p) {
		int size = p.getInventory().getSize() - lootThrow.getSize();
		p.getInventory().setSize(size);
		if(lootThrow.getItemCounter() > 1) {
			lootThrow.setItemCounter(lootThrow.getItemCounter() - 1);
		}
		else {
			p.getInventory().getDrops().remove(lootThrow) ;
		}

	}
	
}
