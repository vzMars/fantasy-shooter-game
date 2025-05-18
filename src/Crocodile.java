
public class Crocodile extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Crocodile(int x, int y, int scale) {
		super("crocodile", x, y, scale, scale, direction, 3, 10, 100, 2);
		
		health  = 90;
		setDamageGiven(7);
		setForcePushback(20);
	}
}