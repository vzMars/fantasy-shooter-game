
public class Demon extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Demon(int x, int y, int scale) {
		super("demon", x, y, scale, scale, direction, 3, 10, 100, 2);
		
		health  = 80;
		setDamageGiven(5);
		setForcePushback(7);
	}
}
