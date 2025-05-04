import java.awt.Graphics;

public class Dungeon3 extends Room {

	static String[] filename = {
			"Dungeon3_Floor&Walls.txt", 
			"Dungeon3_Objects.txt"};
	
	public Dungeon3() {
		super(filename);
	}
	
	public void inGameLoopRoomSpecific() {
		enterDungeon4();
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
		timer.draw(pen);
		hotbar.draw(pen);
	}
	
}
