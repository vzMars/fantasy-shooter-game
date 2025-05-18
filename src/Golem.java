
public class Golem extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Golem(int x, int y, int scale) {
		//(String name, int x, int y, int w, int h, String[] pose, int count, int duration, int health, int chaseSpeed)
		super("golem", x, y, scale, scale, direction, 3, 10, 100,1);
	
		
		setDamageGiven(30);
		setForcePushback(40);
	
		
	}

}
