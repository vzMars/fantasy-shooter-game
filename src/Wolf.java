
public class Wolf extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Wolf(int x, int y, int scale) {
		super("wolf", x, y, scale, scale, direction, 3, 10, 100, 2);
		
		health  = 80;
		setDamageGiven(5);
		setForcePushback(7);
	}
}
