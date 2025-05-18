
public class FireGhost extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public FireGhost(int x, int y, int scale) {
		super("fire_ghost", x, y, scale, scale, direction, 3, 10, 100, 2);
		
		health  = 80;
		setDamageGiven(5);
		setForcePushback(7);
	}
}