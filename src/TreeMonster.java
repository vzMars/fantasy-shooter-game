
public class TreeMonster extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public 	TreeMonster(int x, int y, int scale) {
		super("tree_monster", x, y, scale, scale, direction, 3, 10, 100);
		
		
		health  = 90;
		setDamageGiven(7);
		setForcePushback(20);
		setChaseSpeed(2);
		
		
	}

	

	
}
