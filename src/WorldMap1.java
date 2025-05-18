import java.awt.Graphics;
import java.util.ArrayList;

public class WorldMap1 extends Room {
	
	
	
	Sprite[] sprites = { 
			new Cyclops(1051,761,SCALE), 
			new Orge(131,733,SCALE), 
			new Wolf(519,837,SCALE), 
			new TreeMonster(1199,205,SCALE),
			new Boar(315, 21,SCALE)
			
	
	};
	
	
	static String[] filename = {
			"WorldMap1_Floor&Walls.txt", 
			"WorldMap1_Objects.txt"};
	
	
	
	public WorldMap1() {
		super(filename);
		
		Sprites = sprites;
	}
	
	public void inGameLoopRoomSpecific() {
		enterWorldMap2();
		
		
		for(Sprite sprite : sprites) {
			sprite.actions();
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
		
		
		for(Sprite s : sprites) {
			if(!s.isDead()) {
				s.draw(pen);
			}
		}

		timer.draw(pen);
		hotbar.draw(pen);
		

	}

}
