import java.awt.Graphics;

public class Dungeon4 extends Room {
	
	Sprite[] sprites = { 
			new FireGhost(251,309,SCALE), 
			new Golem(375,869,SCALE), 
			new FireGhost(731,841,SCALE), 
			new Golem(227,701,SCALE),
			new FireGhost(763, 521,SCALE),
			new Demon(747,177,SCALE)};
	

	static String[] filename = {
			"Dungeon4_Floor&Walls.txt", 
			"Dungeon4_Objects.txt"};
	
	public Dungeon4() {
		super(filename);
		
		Sprites = sprites;
	}
	
	public void inGameLoopRoomSpecific() {
		enterDungeon5();
		for(Sprite sprite : sprites) {
			sprite.actions();
		}
	}
	
	public void enterDungeon5() {
		if ((player.x >= 556 && player.x <= 600) && 
			(player.y >= 99 && player.y <= 139)) {
				Room.current = Room.room[8];
				player.x = 512;
				player.y = 127;
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
