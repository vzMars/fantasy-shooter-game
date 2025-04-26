import java.awt.Graphics;

public class Game extends GameBase {
	
	Player p = new Player(500, 500, 64);
	
//	static String[] filename = {
//			"WorldMap1_Floor&Walls.txt", 
//			"WorldMap1_Objects.txt"};
	
//	static String[] filename = {
//			"WorldMap2_Floor&Walls.txt", 
//			"WorldMap2_Objects.txt"};
	
//	static String[] filename = {
//			"WorldMap3_Floor&Walls.txt", 
//			"WorldMap3_Objects.txt",
//			"WorldMap3_Border-Top-Left-Curve.txt",
//			"WorldMap3_Border-Top-Right-Curve.txt",
//			"WorldMap3_Border-Top.txt",
//			"WorldMap3_Border-Bottom-Left-Curve.txt",
//			"WorldMap3_Border-Bottom-Right-Curve.txt",
//			"WorldMap3_Border-Bottom.txt",
//			"WorldMap3_Border-Left.txt",
//			"WorldMap3_Border-Right.txt"};
	
//	static String[] filename = {
//			"Town_Floor&Walls.txt", 
//			"Town_Objects.txt",
//			"Town_Border-Bottom.txt",
//			"Town_Border-Bottom-Right-Curve.txt",
//			"Town_Border-Right.txt",
//			"Town_Border-Bottom-Right.txt",
//			"Town_Border-Top.txt",
//			"Town_Border-Top-Left-Curve.txt",
//			"Town_Border-Left.txt",
//			"Town_Border-Top-Left.txt"};
	
//	static String[] filename = {
//			"Dungeon1_Floor&Walls.txt", 
//			"Dungeon1_Objects.txt"};
	
//	static String[] filename = {
//			"Dungeon2_Floor&Walls.txt", 
//			"Dungeon2_Objects.txt"};
	
//	static String[] filename = {
//			"Dungeon3_Floor&Walls.txt", 
//			"Dungeon3_Objects.txt"};
	
//	static String[] filename = {
//			"Dungeon4_Floor&Walls.txt", 
//			"Dungeon4_Objects.txt"};
	
//	static String[] filename = {
//			"Dungeon5_Floor&Walls.txt", 
//			"Dungeon5_Objects.txt"};
//	
	static String[] filename = {
			"Dungeon6_Floor&Walls.txt", 
			"Dungeon6_Objects.txt"};
	
	Map map = new Map(filename, 64);
	
	public void inGameLoop() {
		if(pressing[UP])	p.moveUp(4);
		if(pressing[DN])	p.moveDown(4);
		if(pressing[LT])	p.moveLeft(4);
		if(pressing[RT])	p.moveRight(4);
		
		checkWalls(p);
	}
	
	public void paint(Graphics pen) {
		map.draw(pen);
		p.draw(pen);
	}

	public void initialize() {

	}
	
	public void checkWalls(Sprite s) {
		for(int i = 0; i < map.wall.length; i++) {
			if(s.overlaps(map.wall[i])) {
				pushAway(s, map.wall[i]);
			}
		}
	}
	
	public void pushAway(Sprite s, Rect r) {
		s.pushAwayFrom(r);
	}

}
