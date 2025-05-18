
public class Boar extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Boar(int x, int y, int scale) {
		super("boar", x, y, scale, scale, direction, 3, 10, 100);
		
		health  = 120;
		setDamageGiven(12);
		setForcePushback(100);
		setChaseSpeed(2);
	}

	
	
}
