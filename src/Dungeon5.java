import java.awt.Graphics;

public class Dungeon5 extends Room {

	static String[] filename = {
			"Dungeon5_Floor&Walls.txt", 
			"Dungeon5_Objects.txt"};
	
	public Dungeon5() {
		super(filename);
	}
	
	public void inGameLoopRoomSpecific() {
		enterDungeon6();
	}
	
	public void enterDungeon6() {
		if ((player.x >= 552 && player.x <= 604) && 
			(player.y >= 1059 && player.y <= 1107)) {
				Room.current = Room.room[9];
				player.x = 636;
				player.y = 1083;
		}	
	}
	
	// room specific draw method that overrides Room's draw method
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
	}
}
