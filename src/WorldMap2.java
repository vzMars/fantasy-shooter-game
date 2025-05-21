import java.awt.Graphics;

public class WorldMap2 extends Room {
	
	Sprite[] sprites = { 
			new TreeMonster(295,1023,SCALE), 
			new Boar(619,1023,SCALE), 
			new TreeMonster(927,1023,SCALE), 
			new Wolf(1151,879,SCALE),
			new TreeMonster(811, 831,SCALE),
			new Wolf(499, 831,SCALE),
			new TreeMonster(103, 831,SCALE),
			new TreeMonster(59, 635,SCALE),
			new TreeMonster(403, 635,SCALE),
			new Chicken(759, 635,SCALE),
			new Rooster(1151, 535,SCALE),
			new Wolf(249, 441,SCALE),
			new TreeMonster(195, 241,SCALE),
			new Orge(703, 241,SCALE),
			new TreeMonster(1019, 45,SCALE)};
	
	static String[] filename = {
			"WorldMap2_Floor&Walls.txt", 
			"WorldMap2_Objects.txt"};
	
	public WorldMap2() {
		super(filename);
	
		Sprites = sprites;
	}
	
	public void inGameLoopRoomSpecific() {
		enterWorldMap3();
		
		for(Sprite sprite : sprites) {
			sprite.actions();
		}
		
		
		
		
	}
	
	public void enterWorldMap3() {
		if ((player.x >= -15 && player.x <= -10) && 
			(player.y >= 33 && player.y <= 63)) {
				Room.current = Room.room[2];
				player.x = 1207;
				player.y = 1151;
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
		healthbar.draw(pen);
	}
	
}