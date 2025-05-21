import java.awt.Graphics;

public class Dungeon1 extends Room {
	
	Sprite[] sprites = { 
			new Slime(316,359,SCALE), 
			new Slime(869,181,SCALE), 
			new Slime(869,494,SCALE), 
			new Slime(153,916,SCALE),
			new Slime(419, 1075,SCALE),
			new Slime(892,970,SCALE)};

	static String[] filename = {
			"Dungeon1_Floor&Walls.txt", 
			"Dungeon1_Objects.txt"};
	
	public Dungeon1() {
		super(filename);
		
		Sprites = sprites;
	}
	
	public void inGameLoopRoomSpecific() {
		enterDungeon2();
		for(Sprite sprite : sprites) {
			sprite.actions();
		}
	}
	
	public void enterDungeon2() {
		if ((player.x >= 1057 && player.x <= 1087) && 
			(player.y >= 1057 && player.y <= 1095)) {
				Room.current = Room.room[5];
				player.x = 1020;
				player.y = 1091;
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