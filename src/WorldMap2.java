import java.awt.Graphics;

public class WorldMap2 extends Room {
	
	static String[] filename = {
			"WorldMap2_Floor&Walls.txt", 
			"WorldMap2_Objects.txt"};
	
	public WorldMap2() {
		super(filename);
	}
	
	public void inGameLoopRoomSpecific() {
		enterWorldMap3();
	}
	
	public void enterWorldMap3() {
		if ((player.x >= -15 && player.x <= -10) && 
			(player.y >= 33 && player.y <= 63)) {
				Room.current = Room.room[2];
				player.x = 1207;
				player.y = 1151;
		}
	}
	
	// room specific draw method that overrides Room's draw method
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
	}
	
}
