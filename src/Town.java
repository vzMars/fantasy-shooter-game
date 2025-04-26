import java.awt.Graphics;

public class Town extends Room {

	static String[] filename = {
			"Town_Floor&Walls.txt", 
			"Town_Objects.txt",
			"Town_Border-Bottom.txt",
			"Town_Border-Bottom-Right-Curve.txt",
			"Town_Border-Right.txt",
			"Town_Border-Bottom-Right.txt",
			"Town_Border-Top.txt",
			"Town_Border-Top-Left-Curve.txt",
			"Town_Border-Left.txt",
			"Town_Border-Top-Left.txt"};
	
	public Town() {
		super(filename);
	}
	
	public void inGameLoopRoomSpecific() {
		enterDungeon1();
	}
	
	public void enterDungeon1() {
		if ((player.x >= 33 && player.x <= 81) && 
			(player.y >= 33 && player.y <= 77)) {
				Room.current = Room.room[4];
				player.x = 460;
				player.y = 121;
		}		
	}
	
	// room specific draw method that overrides Room's draw method
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
	}
	
}
