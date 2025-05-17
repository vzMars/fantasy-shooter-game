import java.awt.Graphics;
import java.util.ArrayList;

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
	
	//These variable keeps track of how low a button is pressed  and prevents spamming
	int animationCounter = 0;
	int animationLimit = 0;  // Different weapon require differnt keystroke length
	
	public Room(String[] filename) {
		map = new Map(filename, SCALE);
		room[count++] = this;
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
		
		// Timer for the room
//		timer.inGameLoop();
		
		if(!Game.isPaused && timer.hasEnded()) Game.pauseBtn.pause();
		if(Game.isPaused) return;
		
		playerAttackType();
		playerMovement();
		playerAttack();
		
		checkSpellsOverLap();
		
		checkWalls(player);
		
		checkOffScreen(player);
		inGameLoopRoomSpecific();
	}
	
	public void playerAttackType() {
		// Fire Spell
		if(pressing[_1]) {
			player.setAttackType(0);
			hotbar.setCurrentSlot(0);
			animationLimit = 1;
		}		
		
		// Ice Spell
		if(pressing[_2])  { 
			player.setAttackType(1);
			hotbar.setCurrentSlot(1);
			animationLimit = 1;
		}
		
		// Lighting Spell
		if(pressing[_3])  {
			player.setAttackType(2);
			hotbar.setCurrentSlot(2);
			animationLimit = 1;
		}
		
		// Sword
		if(pressing[_4]) {
			player.setAttackType(3);
			animationLimit = 15;
//			hotbar.setCurrentSlot(3);	 Needs implementation in the HotBar class		
		}
	}
	
	public void playerMovement() {
		if(pressing[UP])	player.moveUp(4);
		if(pressing[DN])	player.moveDown(4);
		if(pressing[LT])	player.moveLeft(4);
		if(pressing[RT])	player.moveRight(4);
	}
	
	public void monsterMovement(Sprite[] monster) {
		for(int i = 0; i < monster.length; i++) {
			if(!monster[i].isDead()) {
				checkSpellDamage(monster[i]);
				checkDistanceFromPlayer(monster[i]);
				checkWalls(monster[i]);
				checkOffScreen(monster[i]);
			}
		}
	}
	
	public void checkSpellDamage(Sprite s) {
		for (Spell spell : new ArrayList<>(player.spells)) {
			if (spell.overlaps(s.hitBox)) {
				s.takeDamage(spell.getDamage()); 
				s.pushAwayFrom(spell, 16);
				player.spells.remove(spell);
				break; // One spell per hit
			}
		}
	}
	
	public void checkDistanceFromPlayer(Sprite s) {
		int distance = Math.abs(player.x - s.x);
		
		if (distance < 200) {
			s.chase(player);
		}
	}
	
	public void playerAttack() {
		if(pressing[_A] && animationCounter< animationLimit ) {  
			player.attack(); 
			animationCounter++ ;
		}
		
		
		if(!pressing[_A]) { animationCounter = 0;}
		
//		if(pressing [_A])  player.attack();
//		if(pressing )
	}
  	
	public void checkWalls(Sprite s) {
		for(int i = 0; i < map.wall.length; i++) {
			if(s.overlaps(map.wall[i])) {
				pushAway(s, map.wall[i]);
			}
		}
	}
	
	public void checkSpellsOverLap() {
		for(Sprite Spell: new ArrayList<>(player.spells)) {
			for(Rect r : map.wall) {
				if(Spell.overlaps(r)) {
					player.spells.remove(Spell);
				}
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