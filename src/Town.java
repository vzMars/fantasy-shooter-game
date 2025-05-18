import java.awt.Graphics;

public class Town extends Room {
	
	Sprite[] sprites = { 
			new BlueNPC(837,191,SCALE), 
			new OrcNPC(129,767,SCALE), 
			new PurpleNPC(255,129,SCALE), 
			new RedNPC(325,1081,SCALE)};

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
		
		for(Sprite s : sprites) {
			if(s instanceof RedNPC || s instanceof OrcNPC) {
				s.setVelocityX(1);
			} else {
				s.setVelocityY(1);
			}
		}
	}
	
	public void inGameLoopRoomSpecific() {
		enterDungeon1();
		npcMovement();  
	}
	
	public void npcMovement() {
		for(Sprite s : sprites) {
			checkWalls(s);
			checkOffScreen(s);
		}

		for(Sprite s : sprites) {
			if(s instanceof RedNPC || s instanceof OrcNPC) {
				s.moveX();
				if(player.overlaps(s)) s.bounceOffHorizontalSurface();
			} else {
				s.moveY();
				if(player.overlaps(s)) s.bounceOffVerticalSurface();
			}
		}
	}
	
	public void enterDungeon1() {
		if ((player.x >= 33 && player.x <= 81) && 
			(player.y >= 33 && player.y <= 77)) {
				Room.current = Room.room[4];
				player.x = 460;
				player.y = 121;
//				Game.timer.reset();
//				Game.timer.start();
		}		
	}
	
	// room specific draw method that overrides Room's draw method
	public void draw(Graphics pen) {
		map.draw(pen);
		player.draw(pen);
		
		for(Sprite s : sprites) {
			s.draw(pen);
		}
		
		timer.draw(pen);
		hotbar.draw(pen);
	}
	
}
