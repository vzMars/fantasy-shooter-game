
public class Chicken extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Chicken(int x, int y, int scale) {
		super("chicken", x, y, scale, scale, direction, 3, 10, 100, 2);
		
		health  = 50;
		setDamageGiven(2);
		setForcePushback(2);
	}
}