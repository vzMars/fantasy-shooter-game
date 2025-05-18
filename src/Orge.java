
public class Orge extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Orge(int x, int y, int scale) {
		super("orge", x, y, scale, scale, direction, 3, 10, 100, 2);
		health  = 120;
		setDamageGiven(15);
		setForcePushback(10);
	}

	
}
