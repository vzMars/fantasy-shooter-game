import java.awt.Graphics;

public class Dungeon2 extends Room {

	static String[] filename = {
			"Dungeon2_Floor&Walls.txt", 
			"Dungeon2_Objects.txt"};
	
	public Dungeon2() {
		super(filename);
	}
	
	public void inGameLoopRoomSpecific() {
		enterDungeon3();
	}
	
	public void enterDungeon3() {
		if ((player.x >= 1068 && player.x <= 1104) && 
			(player.y >= 551 && player.y <= 587)) {
				Room.current = Room.room[6];
				player.x = 1036;
				player.y = 579;
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