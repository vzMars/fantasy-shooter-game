import java.awt.Graphics;

public class Menu {
	
	
	private Button newGameBtn;
	private Button retryBtn;
	private Button btnPressed;
	private int longBtnH;
	private int longBtnW;
	private int btnDist;// distance between buttons;
	private int x, y, w, h;
	
	//long button 28x12
	//short button 56x56;
	
	public Menu() {
		this(0, 0, 50);
		
		setLocation(640 - w/2, 640 - h /2 - longBtnH / 2);
		
	}
	
	public Menu(int x, int y, int scale) {
		longBtnW    = 7 * scale;
		longBtnH    = 3 * scale;
		btnDist     = longBtnH / 3;
		newGameBtn  = new Button("long", "NEW GAME", x,                      y, longBtnW, longBtnH);
		retryBtn    = new Button("long", "RETRY"   , x, y + longBtnH + btnDist, longBtnW, longBtnH);
		
		newGameBtn.isVisible = false;
		retryBtn.isVisible   = false;
		
		w = longBtnW;
		h = longBtnH * 2 + btnDist;
		
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		
		newGameBtn.x = x;
		retryBtn.x   = x;
		
		newGameBtn.y = y;
		retryBtn.y   = y + longBtnH + btnDist;
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
	
	//creates a new set of rooms
	public void restart() {
		Room.count = 0;
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
		
		Room.player.reset(898, 1203);
		Room.healthbar.update();
		Room.hotbar.deselectCurrentSlot();
	}
	
	public void retry() {
		
		// saves the 10th room in the lastRoom variable
		Room lastRoom = Room.room[9];
		
		//the number of rooms will decrease by one
		//when the new current room is created, it would increase by one
		Room.count--;
		
		int roomNum = 0;
		
		if(Room.current instanceof WorldMap1) {
			roomNum = 0;
			new WorldMap1();
			Room.player.reset(898, 1203);
		}
		
		else if(Room.current instanceof WorldMap2) {
			roomNum = 1;
			new WorldMap2();
			Room.player.reset(63, 1203);

		}
		
		else if(Room.current instanceof WorldMap3) {
			roomNum = 2;
			new WorldMap3();
			Room.player.reset(1207, 1151);

		}
		
		else if(Room.current instanceof Town) {
			roomNum = 3;
			new Town();
			Room.player.reset(320, 1207);

		}
		
		else if(Room.current instanceof Dungeon1) {
			roomNum = 4;
			new Dungeon1();
			Room.player.reset(460, 121);

		}
		
		else if(Room.current instanceof Dungeon2) {
			roomNum = 5;
			new Dungeon2();
			Room.player.reset(1020, 1091);

		}
		
		else if(Room.current instanceof Dungeon3) {
			roomNum = 6;
			new Dungeon3();
			Room.player.reset(1036, 579);

		}
		
		else if(Room.current instanceof Dungeon4) {
			roomNum = 7;
			new Dungeon4();
			Room.player.reset(116, 1015);

		}
		
		else if(Room.current instanceof Dungeon5) {
			roomNum = 8;
			new Dungeon5();
			Room.player.reset(512, 127);

			
		}
		else if(Room.current instanceof Dungeon6) {
			roomNum = 9;
			new Dungeon6();
			Room.player.reset(636, 1083);

		}
		
		Room.healthbar.update();
		Room.hotbar.deselectCurrentSlot();
		
		//the current room would be the new room created
		Room.current       = Room.room[9];
		//the curren room is placed in the correct index
		Room.room[roomNum] = Room.current;
		
		//places the previous last room to the back of the array
		// only if the the last room is not the new room (or current room) created
		if(roomNum != 9) Room.room[9] = lastRoom;
		
		
	}
	
	public void setBtnsVisible(boolean visible) {
		newGameBtn.isVisible = visible;
		retryBtn.isVisible   = visible;
	}
	
	public void inGameLoop() {
		setBtnsVisible(Game.isPaused);
			
		if(Game.mousePressed && btnPressed == null) {
			
			if(newGameBtn.isPressed(Game.mx, Game.my))    btnPressed = newGameBtn;
			
			else if(retryBtn.isPressed(Game.mx, Game.my)) btnPressed = retryBtn;
				
		}
		
		else if (!Game.mousePressed && btnPressed != null) {
			btnPressed.release();
					
						
				 if(btnPressed  == newGameBtn) restart();
			else if (btnPressed == retryBtn)   retry();
				
			Room.timer.reset();
			btnPressed = null;
		}
	}
		
	public void draw(Graphics pen) {
		
		newGameBtn.draw(pen);
		retryBtn.draw(pen);
	}
	
	
}
