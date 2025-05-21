import java.awt.Graphics;

public class Dungeon6 extends Room {
	
	Sprite[] sprites = { 
			new Demon(520,363,SCALE * 3)};

	static String[] filename = {
			"Dungeon6_Floor&Walls.txt", 
			"Dungeon6_Objects.txt"};
	
	public Dungeon6() {
		super(filename);
		
		Sprites = sprites;
	}
	
	public void inGameLoopRoomSpecific() {
		for(Sprite sprite : sprites) {
			sprite.actions();
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
