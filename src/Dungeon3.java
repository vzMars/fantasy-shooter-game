import java.awt.Graphics;

public class Dungeon3 extends Room {

	
	Sprite[] sprites = { 
			new Golem(1020,1015,SCALE), 
			new Golem(1020,247,SCALE), 
			new Golem(592,271,SCALE), 
			new Golem(592,655,SCALE),
			new Golem(388, 855,SCALE),
			new Golem(153,477,SCALE)};
	
	
	static String[] filename = {
			"Dungeon3_Floor&Walls.txt", 
			"Dungeon3_Objects.txt"};
	
	public Dungeon3() {
		super(filename);
		
		Sprites = sprites;
	}
	
	public void inGameLoopRoomSpecific() {
		enterDungeon4();
		for(Sprite sprite : sprites) {
			sprite.actions();
		}
	}
	
	public void enterDungeon4() {
		if ((player.x >= 112 && player.x <= 152) && 
			(player.y >= 1059 && player.y <= 1099)) {
				Room.current = Room.room[7];
				player.x = 116;
				player.y = 1015;
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