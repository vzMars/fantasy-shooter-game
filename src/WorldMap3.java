import java.awt.Graphics;

public class WorldMap3 extends Room {

	static String[] filename = {
			"WorldMap3_Floor&Walls.txt", 
			"WorldMap3_Objects.txt",
			"WorldMap3_Border-Top-Left-Curve.txt",
			"WorldMap3_Border-Top-Right-Curve.txt",
			"WorldMap3_Border-Top.txt",
			"WorldMap3_Border-Bottom-Left-Curve.txt",
			"WorldMap3_Border-Bottom-Right-Curve.txt",
			"WorldMap3_Border-Bottom.txt",
			"WorldMap3_Border-Left.txt",
			"WorldMap3_Border-Right.txt"};
	
	public WorldMap3() {
		super(filename);
	}
	
	public void inGameLoopRoomSpecific() {
		enterTown();
	}
	
	public void enterTown() {
		if ((player.x >= 555 && player.x <= 599) && 
			(player.y >= 487 && player.y <= 539)) {
				Room.current = Room.room[3];
				player.x = 320;
				player.y = 1207;
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
