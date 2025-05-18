import java.util.ArrayList;

public class Cyclops extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Cyclops(int x, int y, int scale) {
		super("cyclops", x, y, scale, scale, direction, 3, 10, 100, 2);
		
		health  = 120;
		setDamageGiven(12);
		setForcePushback(20);
	
	
	}


	
	
	
	
	 
	
	
}
