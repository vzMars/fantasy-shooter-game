import java.awt.Graphics;

public class Dungeon6 extends Room {

	static String[] filename = {
			"Dungeon6_Floor&Walls.txt", 
			"Dungeon6_Objects.txt"};
	
	public Dungeon6() {
		super(filename);
	}
	
	public void inGameLoopRoomSpecific() {
		
	}
	
	// room specific draw method that overrides Room's draw method
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
		timer.draw(pen);
		hotbar.draw(pen);
	}

}
