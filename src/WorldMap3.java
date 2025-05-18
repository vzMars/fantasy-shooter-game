import java.awt.Graphics;

public class WorldMap3 extends Room {
	
	Sprite[] sprites = { 
			new Crocodile(811,955,SCALE), 
			new Crocodile(607,777,SCALE), 
			new Crocodile(349,833,SCALE), 
			new Orge(469,1005,SCALE),
			new Orge(605, 1151,SCALE),
			new Orge(785,447,SCALE)};

	static String[] filename = {
			"WorldMap3_Floor&Walls.txt", 
			"WorldMap3_Objects.txt",
			"WorldMap3_Border-Top-Left-Curve.txt",
			"WorldMap3_Border-Top-Right-Curve.txt",
			"WorldMap3_Border-Top.txt",
			"WorldMap3_Border-Bottom-Left-Curve.txt",
			"WorldMap3_Border-Bottom-Right-Curve.txt",
			"WorldMap3_Border-Bottom.txt",
			"WorldMap3_Border-Left.txt",
			"WorldMap3_Border-Right.txt"};
	
	public WorldMap3() {
		super(filename);
		
		Sprites = sprites;
	}
	
	public void inGameLoopRoomSpecific() {
		enterTown();
		for(Sprite sprite : sprites) {
			sprite.actions();
		}
		
	}
	
	public void enterTown() {
		if ((player.x >= 555 && player.x <= 599) && 
			(player.y >= 487 && player.y <= 539)) {
				Room.current = Room.room[3];
				player.x = 320;
				player.y = 1207;
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