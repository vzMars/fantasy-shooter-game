import java.awt.Graphics;
import java.util.ArrayList;

public class WorldMap1 extends Room {
	
	
	
	Cyclops[] c = { new Cyclops(200,1000,SCALE), new Cyclops(1000,200,SCALE), new Cyclops(1000,1000,SCALE), new Cyclops(500,1500,SCALE)      };
	
	
	static String[] filename = {
			"WorldMap1_Floor&Walls.txt", 
			"WorldMap1_Objects.txt"};
	
	
	
	public WorldMap1() {
		super(filename);
	}
	
	public void inGameLoopRoomSpecific() {
		enterWorldMap2();
		
		
		for(Cyclops c : c) {

		if(c.isDead()) {
			
			//Death state 

		}else {
		
			for (Spell spell : new ArrayList<>(player.spells)) {
				
		        if (spell.overlaps(c.hitBox)) {
		            c.takeDamage(spell.getDamage()); 
		            c.pushAwayFromBy(spell,16);
		            player.spells.remove(spell);
		            break; // One spell per hit
		        }
		    
				}
				
		
		
		}
		
		if( !c.isDead() && c.radius.overlaps(player.radius) ) {
			c.chase(player);
		}
		checkWalls(c);
	
		
		
		}
		
	}
	
	public void enterWorldMap2() {
		if ((player.x >= 481 && player.x <= 511) && 
			(player.y >= 673 && player.y <= 725)) {
				Room.current = Room.room[1];
				player.x = 63;
				player.y = 1203;
//				Game.timer.reset();
//				Game.timer.start();
		}
	}
	
	// room specific draw method that overrides Room's draw method
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
		
		
		for(Cyclops c : c) 
			c.draw(pen);

		
		
		timer.draw(pen);
		hotbar.draw(pen);
		

	}

}
