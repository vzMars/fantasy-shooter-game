import java.awt.Graphics;

public abstract class Room extends RoomBase {
	final static int SCALE = 64;
	
	Map map;
	
	static Player player = new Player(898, 1203, SCALE);
	static CountdownTimer timer = new CountdownTimer(550, 5, 90, 10, CountdownTimer.SECONDS);
	static Hotbar hotbar = new Hotbar();
	
	static int count = 0;
	
	static Room[] room = new Room[10];

	// top, right, bottom, left off-screen walls
	static Rect[] offscreen = {
			new Rect(0, -80, SCALE * 20, SCALE), 
			new Rect(1280, 0, SCALE, SCALE * 20),
			new Rect(0, 1280, SCALE * 20, SCALE),
			new Rect(-80, 0, SCALE, SCALE * 20)};
	
	static Room current;
	
	public Room(String[] filename) {
		map = new Map(filename, SCALE);
		room[count++] = this;
		hotbar.setLocation(640 - hotbar.getWidth() / 2,  1260 - hotbar.getHeight());
	}
	
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
		timer.draw(pen);
		hotbar.draw(pen);
	}
	
	public abstract void inGameLoopRoomSpecific();
	
	public void inGameLoop() {
//		System.out.println("Player x:" + player.x);
//		System.out.println("Player y:" + player.y);
		
		timer.inGameLoop();
		
		if(!Game.isPaused && timer.hasEnded()) Game.pauseBtn.pause();
		if(Game.isPaused) return;
		
		
		if(pressing[_1])    hotbar.setCurrentSlot(0);
		if(pressing[_2])    hotbar.setCurrentSlot(1);
		if(pressing[_3])    hotbar.setCurrentSlot(2);
		
		if(pressing[UP])	player.moveUp(4);
		if(pressing[DN])	player.moveDown(4);
		if(pressing[LT])	player.moveLeft(4);
		if(pressing[RT])	player.moveRight(4);
		
		checkWalls(player);
		checkOffScreen(player);
		inGameLoopRoomSpecific();
	}
	
	public void checkWalls(Sprite s) {
		for(int i = 0; i < map.wall.length; i++) {
			if(s.overlaps(map.wall[i])) {
				pushAway(s, map.wall[i]);
			}
		}
	}
	
	public void checkOffScreen(Sprite s) {
		for(int i = 0; i < offscreen.length; i++) {
			if(s.overlaps(offscreen[i])) {
				pushAway(s, offscreen[i]);
			}
		}
	}
	
	public void pushAway(Sprite s, Rect r) {
		s.pushAwayFrom(r);
	}
}