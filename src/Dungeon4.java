import java.awt.Graphics;

public class Dungeon4 extends Room {

	static String[] filename = {
			"Dungeon4_Floor&Walls.txt", 
			"Dungeon4_Objects.txt"};
	
	public Dungeon4() {
		super(filename);
	}
	
	public void inGameLoopRoomSpecific() {
		enterDungeon5();
	}
	
	public void enterDungeon5() {
		if ((player.x >= 556 && player.x <= 600) && 
			(player.y >= 99 && player.y <= 139)) {
				Room.current = Room.room[8];
				player.x = 512;
				player.y = 127;
		}	
	}
	
	// room specific draw method that overrides Room's draw method
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
	}
}
