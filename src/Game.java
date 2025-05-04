import java.awt.Graphics;

public class Game extends GameBase {
	static Menu menu;
	static boolean isPaused;
	static PauseButton pauseBtn;
	
	public void inGameLoop() {
		
		pauseBtn.inGameLoop();
		menu.inGameLoop();
		Room.current.inGameLoop();
		
		
		
	}
	
	public void paint(Graphics pen) {
		Room.current.draw(pen);
		menu.draw(pen);
		pauseBtn.draw(pen);
	}

	public void initialize() {
		setSize(1280, 1280);
		
		
		pauseBtn = new PauseButton(1205, 5, 70);
		menu     = new Menu();
		
		pauseBtn.pause();
		
//		Room.timer.setEnabled(true);
		
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
