import java.awt.Graphics;

public class Dungeon5 extends Room {
	
	Sprite[] sprites = { 
			new FireGhost(480,351,SCALE), 
			new Demon(596,515,SCALE), 
			new FireGhost(712,351,SCALE), 
			new Demon(596,675,SCALE),
			new FireGhost(668, 947,SCALE),
			new Demon(496,835,SCALE)};

	static String[] filename = {
			"Dungeon5_Floor&Walls.txt", 
			"Dungeon5_Objects.txt"};
	
	public Dungeon5() {
		super(filename);
		
		Sprites = sprites;
	}
	
	public void inGameLoopRoomSpecific() {
		enterDungeon6();
		for(Sprite sprite : sprites) {
			sprite.actions();
		}
	}
	
	public void enterDungeon6() {
		if ((player.x >= 552 && player.x <= 604) && 
			(player.y >= 1059 && player.y <= 1107)) {
				Room.current = Room.room[9];
				player.x = 636;
				player.y = 1083;
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
