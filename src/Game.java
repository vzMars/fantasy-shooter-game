import java.awt.Graphics;

public class Game extends GameBase {
	
//	Player p = new Player(100, 100, 120);
//	OrcNPC p = new OrcNPC(200, 200, 120);
//	PurpleNPC p = new PurpleNPC(200, 200, 120);
//	RedNPC p = new RedNPC(200, 200, 120);
	Lighting l = new Lighting(400, 0, 120);
	Fire f = new Fire(400, 200, 120);
	Ice i = new Ice(400, 400, 120);
	
	public void inGameLoop() {
		if(pressing[UP])	l.moveUp(4);
		if(pressing[DN])	l.moveDown(4);
		if(pressing[LT])	l.moveLeft(4);
		if(pressing[RT])	l.moveRight(4);
		
		if(pressing[UP])	f.moveUp(4);
		if(pressing[DN])	f.moveDown(4);
		if(pressing[LT])	f.moveLeft(4);
		if(pressing[RT])	f.moveRight(4);
		
		if(pressing[UP])	i.moveUp(4);
		if(pressing[DN])	i.moveDown(4);
		if(pressing[LT])	i.moveLeft(4);
		if(pressing[RT])	i.moveRight(4);
	}
	
	public void paint(Graphics pen) {
		l.draw(pen);
		f.draw(pen);
		i.draw(pen);
	}

	public void initialize() {

	}

}
