
public class Rooster extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Rooster(int x, int y, int scale) {
		super("rooster", x, y, scale, scale, direction, 3, 10, 100, 2);
		
		health  = 80;
		setDamageGiven(5);
		setForcePushback(7);
	}
}