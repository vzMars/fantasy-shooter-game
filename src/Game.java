import java.awt.Graphics;

public class Game extends GameBase {
	
	public void inGameLoop() {
		Room.current.inGameLoop();
	}
	
	public void paint(Graphics pen) {
		Room.current.draw(pen);
	}

	public void initialize() {
		Room.setUpInput(pressing);
		
		new WorldMap1();
		new WorldMap2();
		new WorldMap3();
		new Town();
		new Dungeon1();
		new Dungeon2();
		new Dungeon3();
		new Dungeon4();
		new Dungeon5();
		new Dungeon6();
		
		Room.current = Room.room[0];
	}

}
